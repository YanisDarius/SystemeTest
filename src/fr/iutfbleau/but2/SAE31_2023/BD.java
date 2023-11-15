import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

public class BD {

    Connection cnx;
    PreparedStatement pst;

    public BD() {

        String cheminFichier = "login.txt";

        List<String> valeurLogin = lireValeurLogin(cheminFichier);

        String url = valeurLogin.get(0);
        String user = valeurLogin.get(1);
        String password = valeurLogin.get(2);

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            cnx = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.out.printf("Pas de connexion" + e);
        }
    }

    public static List<String> lireValeurLogin(String cheminFichier) {

        File fichier = new File(cheminFichier);
        List<String> valeur = new ArrayList<>();
        String ligne;

        try (BufferedReader lecteur = new BufferedReader(new FileReader(fichier))) {
            for (int i = 0; i < 3 && (ligne = lecteur.readLine()) != null; i++) {
                valeur.add(ligne);
            }
        } catch (Exception e) {
            System.out.println("Problème" + e);
        }
        return valeur;
    }

    public ArrayList<Object> getProtocole() {

        ArrayList<Object> protocoleListe = new ArrayList<Object>();

        try {

            pst = cnx.prepareStatement("SELECT * FROM `protocole`;");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                ArrayList<Object> protocole = new ArrayList<Object>();

                protocole.add(rs.getInt(1)); // id du protocole
                protocole.add(rs.getString(3)); // titre du protocole
                protocole.add(rs.getString(4)); // description du protocole

                protocoleListe.add(protocole);
            }

        } catch (Exception e) {
            System.out.printf("erreur getProtocole :" + e);
        }

        return protocoleListe;

    }

    public void setTest(int IdTest, int ref) {

        ArrayList<Integer> tabIdTest = new ArrayList<Integer>();
        ArrayList<Integer> tabRef = new ArrayList<Integer>();

        try {

            pst = cnx.prepareStatement("INSERT INTO test (IdTest, ref) Values (?, ?)");
            pst.setInt(1, IdTest);
            pst.setInt(2, ref);

            int insertion = pst.executeUpdate();

            if (insertion > 0) {
                System.out.println("L'ID de protocole a ete insere avec succes !");
            } else {
                System.out.println("Erreur lors de l'insertion de l'ID de protocole.");
            }

        } catch (SQLIntegrityConstraintViolationException e) {

            try {
                pst = cnx.prepareStatement("SELECT IdTest FROM `test`");
                ResultSet rs = pst.executeQuery();

                pst = cnx.prepareStatement("SELECT ref FROM `protocole`");
                ResultSet rs2 = pst.executeQuery();

                while (rs.next()) {

                    tabIdTest.add(rs.getInt("IdTest"));
                }

                while (rs2.next()) {
                    tabRef.add(rs2.getInt("ref"));
                }

                for (int i = 0; i < tabIdTest.size(); i++) {
                    if (tabIdTest.contains(IdTest)) {
                        System.out.println(
                                "La cle primaire \"IdTest\" de la table \"test\" que vous essayez d'ajouter existe deja.");
                        if (!tabRef.contains(ref)) {
                            System.out.println("La cle referentielle \"ref\" de la table \"protcole\" n'existe pas.");
                            break;
                        }
                        break;
                    }
                    if (!tabRef.contains(ref)) {
                        System.out.println("La cle referentielle \"ref\" de la table \"protcole\" n'existe pas.");
                        break;
                    }
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }

        } catch (Exception e) {
            System.out.printf("Erreur IdTest : " + e);
        }
    }

    public void fermerRessource() {

        try {
            cnx.close();
            System.out.println("Base de données fermer !");
        } catch (Exception e) {
            System.out.printf("erreur fermerRessource :" + e);
        }
    }

    public Noeud getFils(int id) {
        Noeud root = null;
        try {
            // recup la racine
            PreparedStatement pst = this.cnx.prepareStatement("SELECT * FROM `menu` WHERE idmenu = ? ORDER BY poids;");
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                // recup les enfants
                root = new Noeud(rs.getInt(1), rs.getString(2), rs.getInt(4));
                PreparedStatement pst2 = cnx.prepareStatement("SELECT * FROM `menu` WHERE idpere = ? ORDER BY poids;");
                pst2.setInt(1, id);
                ResultSet rs2 = pst2.executeQuery();
                while (rs2.next()) {
                    Noeud fils = getFils(rs2.getInt(1));
                    root.ajouterEnfant(fils);
                }
            }
        } catch (Exception e) {
            // TODO
        }
        return root;
    }

}
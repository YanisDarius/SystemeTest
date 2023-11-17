import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BD {

    private Connection cnx;
    private PreparedStatement pst;
    private ArrayList<Object> actionList = new ArrayList<Object>();;

    public BD() {

        String cheminFichier = "src/fr/iutfbleau/but2/SAE31_2023/login.txt";

        List<String> valeurLogin = lireValeurLogin(cheminFichier);

        String url = valeurLogin.get(0);
        String user = valeurLogin.get(1);
        String password = valeurLogin.get(2);

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            cnx = DriverManager.getConnection(url, user, password);
            pst = cnx.prepareStatement("SELECT * FROM `menu` ORDER BY `menu`.`idmenu` ASC, `menu`.`idpere` ASC, `menu`.`poids` ASC");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {

                ArrayList<Object> act = new ArrayList<Object>();

                act.add(rs.getInt(1));      // id 
                act.add(rs.getString(2));   // titre
                act.add(rs.getInt(3));      // pid
                act.add(rs.getInt(4));      // poids

                actionList.add(act);
            }

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

                protocole.add(rs.getInt(2)); // id du menu
                protocole.add(rs.getString(3)); // titre du protocole
                protocole.add(rs.getString(4)); // description du protocole

                protocoleListe.add(protocole);
            }

        } catch (Exception e) {
            System.out.printf("erreur getProtocole :" + e);
        }

        return protocoleListe;

    }

    public void setTest(int ref, int idMenu) {

        ArrayList<Integer> tabIdTest = new ArrayList<Integer>();
        ArrayList<Integer> tabRef = new ArrayList<Integer>();

        try {

            pst = cnx.prepareStatement("INSERT INTO test (IdTest, ref, idMenu) Values (null, ?, ?)");
            pst.setInt(1, ref);
            pst.setInt(2, idMenu);

            int insertion = pst.executeUpdate();

            if (insertion > 0) {
                System.out.println("L'ID du protocole a été inséré avec succès !");
            } else {
                System.out.println("Erreur lors de l'insertion de l'ID de protocole.");
            }

        } catch (SQLIntegrityConstraintViolationException e) {

            try {
                pst = cnx.prepareStatement("SELECT idMenu FROM `test`");
                ResultSet rs = pst.executeQuery();

                pst = cnx.prepareStatement("SELECT ref FROM `protocole`");
                ResultSet rs2 = pst.executeQuery();

                while (rs.next()) {

                    tabIdTest.add(rs.getInt("idMenu"));
                }

                while (rs2.next()) {
                    tabRef.add(rs2.getInt("ref"));
                }

                for (int i = 0; i < tabIdTest.size(); i++) {
                    if (!tabIdTest.contains(idMenu)) {
                        System.out.println(
                                "La clé référentielle \"idMenu\" de la table \"test\" sur laquelle vous voulez faire votre test n'existe pas.\nVeuillez choisir un \"idMenu\" existant.");
                        if (!tabRef.contains(ref)) {
                            System.out.println("La clé référentielle \"ref\" de la table \"protcole\" n'existe pas.");
                            break;
                        }
                        break;
                    }
                    if (!tabRef.contains(ref)) {
                        System.out.println("La clé référentielle \"ref\" de la table \"protcole\" n'existe pas.");
                        break;
                    }
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }

        } catch (Exception e) {
            System.out.printf("Erreur fonction setTest : \n" + e);
        }
    }

    public void setHistorique(int idTest, int idMenu, int rank) {
        try {
            pst = cnx.prepareStatement("INSERT INTO `historique` (`idhist`, `idtest`, `idmenu`, `rank`) VALUES (NULL, ?, ?, ?)");
            pst.setInt(1, idTest);
            pst.setInt(2, idMenu);
            pst.setInt(2, rank);

            pst.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void fermerRessource() {

        try {
            cnx.close();
            System.out.println("Base de données fermée !");
        } catch (Exception e) {
            System.out.printf("erreur fonction fermerRessource :\n" + e);
        }
    } 
    /*
    public Noeud getFils(int id) {
        Noeud root = null;
        try {
            // recup la racine
            PreparedStatement pst = this.cnx.prepareStatement("SELECT * FROM `menu` WHERE idMenu = ? ORDER BY poids;");
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                // recup les enfants
                root = new Noeud(rs.getInt(1), rs.getString(2), rs.getInt(4));
                PreparedStatement pst2 = cnx.prepareStatement("SELECT * FROM `menu` WHERE idPere = ? ORDER BY poids;");
                pst2.setInt(1, id);
                ResultSet rs2 = pst2.executeQuery();
                while (rs2.next()) {
                    Noeud fils = getFils(rs2.getInt(1));
                    root.ajouterEnfant(fils);
                }
            }
        } catch (Exception e) {
            System.out.println("Erreur fonction getFils :\n" + e);
        }
        return root;
    }
     */
    
    public Noeud getFils(int idRacine) {
        Noeud racine = null;
        Map<Integer, Noeud> mapNoeuds = new HashMap<>();        //dico id/noeud
    
        for (Object action : actionList) {
            if (action instanceof ArrayList) {
                ArrayList<Object> act = (ArrayList<Object>) action;
                //les cast parce que c'est dans des Objects
                int id = (int) act.get(0);
                String titre = (String) act.get(1);
                int pid = (int) act.get(2);
                int poids = (int) act.get(3);
    
                Noeud noeud = new Noeud(id, titre, poids);
                mapNoeuds.put(id, noeud);
    
                if (id == idRacine) {
                    racine = noeud;
                } else {                        //enfant
                    Noeud parent = mapNoeuds.get(pid);
                    if (parent != null) {
                        parent.ajouterEnfant(noeud);
                    }
                }
            }
        }
    
        return racine;
    }

}
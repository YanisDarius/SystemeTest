import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

public class Contr {

    Connection cnx;
    PreparedStatement pst;

    public Contr() {

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            cnx = DriverManager.getConnection("jdbc:mariadb://dwarves.iut-fbleau.fr/sayebabu", "sayebabu", "kjrzB5S4kqKAwdT");
        } catch (Exception e) {
            System.out.printf("pas de connexion" + e);
        }
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
                        System.out.println("La cle primaire \"IdTest\" de la table \"test\" que vous essayez d'ajouter existe deja.");
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
            pst.close();
            cnx.close();
        } catch (Exception e) {
            System.out.printf("erreur fermerRessource :" + e);
        }
    }

    public ArrayList<Menu> getFils(int id) { 
        ArrayList<Menu> fils = new ArrayList<Menu>();
 
        try { PreparedStatement pst =
            this.cnx.prepareStatement("SELECT * FROM `menu` WHERE idpere = ?;");
            pst.setInt(1, id); 
            ResultSet rs = pst.executeQuery(); 
            while (rs.next()) {
                PreparedStatement pst2 = cnx.prepareStatement("SELECT COUNT(*) FROM `menu` WHERE idpere = ?;");
                pst2.setInt(1, rs.getInt(1));
                ResultSet rs2 = pst2.executeQuery();
                rs2.next();
                if (rs2.getInt(1) != 0) {
                    //TODO } else { Action output; //TODO }
                }
            }
        } catch (Exception e) {
            // TODO: handle exception } finally {
        }
        return fils;
    }


    public static void main(String[] args) {
        Contr contr = new Contr();
        contr.setTest(4, 3);
        System.out.println(contr.getProtocole());

        contr.fermerRessource();
    }

}
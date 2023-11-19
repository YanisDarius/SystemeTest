import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

/**
 * La classe BD (Base de Données) gère la connexion à une base de données MariaDB,
 * récupère des données à partir de requêtes SQL, et effectue des opérations sur la base de données.
 */
public class BD {

    /** La connexion à la base de données */
    private Connection cnx;

    /** La déclaration préparée pour les requêtes SQL */
    private PreparedStatement pst;

    /** Liste des actions récupérées depuis la base de données */
    private ArrayList<Object> actionList = new ArrayList<Object>();;

    /**
     * Constructeur de la classe BD. Initialise la connexion à la base de données
     * en utilisant les informations de connexion stockées dans un fichier.
     */
    public BD() {

        String url = "jdbc:mariadb://dwarves.iut-fbleau.fr/sayebabu";
        String user = "sayebabu";
        String password = "kjrzB5S4kqKAwdT";

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            cnx = DriverManager.getConnection(url, user, password);

            // Initialisation de la liste des actions en récupérant les données depuis la table 'menu'
            pst = cnx.prepareStatement("SELECT * FROM `menu` ORDER BY `menu`.`idmenu` ASC, `menu`.`idpere` ASC, `menu`.`poids` ASC");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {

                ArrayList<Object> act = new ArrayList<Object>();

                act.add(rs.getInt(1)); // id 
                act.add(rs.getString(2)); // titre
                act.add(rs.getInt(3)); // pid
                act.add(rs.getInt(4)); // poids

                actionList.add(act);
            }

        } catch (Exception e) {
            System.out.printf("Pas de connexion" + e);
        }
    }

    /**
     * Lit les informations de connexion à la base de données à partir d'un fichier et retourne les informations.
     *
     * @param cheminFichier Le chemin du fichier contenant les informations de connexion.
     * @return Une liste contenant l'URL, le nom d'utilisateur et le mot de passe.
     */
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

    /**
     * Récupère la liste des protocoles depuis la table 'protocole'.
     *
     * @param id L'identifiant du protocole.
     * @return Une liste d'objets représentant les protocoles (titre et description du protocole ainsi que l'ID du fichier a tester).
     */
    public ArrayList<Object> getProtocole(int id) {

        
        ArrayList<Object> protocole = new ArrayList<Object>();

        try {

            pst = cnx.prepareStatement("SELECT * FROM `protocole` WHERE ref = ?;");
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            rs.next();

            protocole.add(rs.getString(3)); // titre du protocole
            protocole.add(rs.getString(4)); // description du protocole
            protocole.add(rs.getInt(5));    // id de l'action correcte    


        } catch (Exception e) {
            System.out.printf("erreur getProtocole :" + e);
        }
        return protocole;
    }    

    /**
     * Ferme la connexion à la base de données.
     */
    public void fermerRessource() {

        try {
            cnx.close();
            System.out.println("Base de données fermée !");
        } catch (Exception e) {
            System.out.printf("erreur fonction fermerRessource :\n" + e);
        }
    }
    
    /**
     * Récupère la liste des actions de test associées à un protocole.
     *
     * @param refProt L'identifiant du protocole.
     * @return Une liste d'entiers représentant les actions de test associées au protocole.
     */
    public ArrayList<Integer> getTest(int refProt)
    {
        ArrayList<Integer> testRes = new ArrayList<Integer>();

        try {
            //Récupération de tous les tests du protocole choisi
            pst = cnx.prepareStatement("SELECT * FROM `test` WHERE ref = ? ORDER BY `test`.`idmenu`;");
            pst.setInt(1, refProt);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                //Ajout de l'id de l'action chosi à la fin du test
                testRes.add(rs.getInt(3));
            }

        } catch (Exception e) {
            System.out.printf("erreur getTest :" + e);
        }
        return testRes;
    }

    /**
     * Récupère la liste des actions de test effectuées pour un protocole.
     *
     * @param refProt L'identifiant du protocole.
     * @return Une liste d'entiers représentant les actions de test effectuées pour le protocole.
     */
    public ArrayList<Integer> getHist(int refProt)
    {
        ArrayList<Integer> histRes = new ArrayList<Integer>();

        try {
            //Récupération de tous les tests du protocole choisi
            pst = cnx.prepareStatement("SELECT h.idmenu FROM historique h JOIN test t ON t.idtest = h.idtest where ref = ?;");
            pst.setInt(1, refProt);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                //Ajout de l'id de tous les différents click à travers les tests
                histRes.add(rs.getInt(1));
            }

        } catch (Exception e) {
            System.out.printf("erreur getHist :" + e);
        }
        return histRes;
    }

    /**
     * Récupère le libellé d'une action à partir de son identifiant.
     *
     * @param idAction L'identifiant de l'action.
     * @return Le libellé de l'action correspondant à l'identifiant.
     */
    public String getActionLabel(int idAction)
    {
        String label = "erreur";
        
        try {
            //Récupération de tous les tests du protocole choisi
            pst = cnx.prepareStatement("SELECT nom FROM `menu` where idmenu = ?;");
            pst.setInt(1, idAction);
            ResultSet rs = pst.executeQuery();
            rs.next();
            label = rs.getString(1);

        } catch (Exception e) {
            System.out.printf("erreur getActionLabel :" + e);
        }

        return label;
    }
}
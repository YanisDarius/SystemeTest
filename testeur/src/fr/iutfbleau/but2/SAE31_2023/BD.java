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
    private ArrayList<Object> actionList = new ArrayList<Object>();

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
     * @return Une liste d'objets représentant les protocoles (titre et description du protocole ainsi que l'ID du fichier a tester).
     */
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
                protocole.add(rs.getInt(1));// id protocole
                protocoleListe.add(protocole);
            }
        } catch (Exception e) {
            System.out.printf("erreur getProtocole :" + e);
        }
        return protocoleListe;
    }

    /**
     * Insère un test dans la table 'test' avec les références spécifiées.
     *
     * @param ref La référence du test.
     * @param idMenu L'ID du menu associé au test.
     * @return L'ID généré lors de l'insertion du test.
     */
    public int setTest(int ref, int idMenu) {

        ArrayList<Integer> tabIdTest = new ArrayList<Integer>();
        ArrayList<Integer> tabRef = new ArrayList<Integer>();
        int insertion = -1;

        try {
            pst = cnx.prepareStatement("INSERT INTO test (IdTest, ref, idMenu) Values (null, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setInt(1, ref);
            pst.setInt(2, idMenu);

            insertion = pst.executeUpdate();

            if (insertion > 0) {
                ResultSet generatedKeys = pst.getGeneratedKeys();
                if (generatedKeys.next()) {
                    insertion = generatedKeys.getInt(1);
                    System.out.println("L'ID du protocole a été inséré avec succès ! (ID : " + insertion + ")");
                }
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
        return insertion;
    }

    /**
     * Insère une entrée dans la table 'historique'.
     *
     * @param idTest L'ID du test.
     * @param

 idMenu L'ID du menu associé.
     * @param rank Le rang de l'historique.
     */
    public void setHistorique(int idTest, int idMenu, int rank) {

        try {
            pst = cnx.prepareStatement("INSERT INTO `historique` (`idhist`, `idtest`, `idmenu`, `rank`) VALUES (NULL, ?, ?, ?)");
            pst.setInt(1, idTest);
            pst.setInt(2, idMenu);
            pst.setInt(3, rank);
            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
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
     * Récupère les nœuds fils d'un nœud donné à partir de la liste des actions.
     *
     * @param idRacine L'ID du nœud racine.
     * @return Le nœud racine avec ses enfants.
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
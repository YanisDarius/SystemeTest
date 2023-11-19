import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.awt.Color;

/**
 * La classe Donnee représente les données associées à un protocole, notamment son identifiant, son titre, sa description,
 * la réponse attendue, ainsi que les résultats des tests effectués.
 */
public class Donnee {
    
    /** L'identifiant du protocole */
    private int idprotocole;

    /** Le titre du protocole */
    private String titreprotocole;

    /** La description du protocole */
    private String descriptionprotocole;

    /** La réponse attendue pour le protocole */
    private int reponse;

    /** Les résultats des tests effectués pour le protocole */
    private ArrayList<Integer> reponsetest;

    private BD bdd;

    /**
     * Construit un objet Donnee en récupérant les informations associées à un protocole depuis la base de données.
     *
     * @param bdd La base de données à partir de laquelle les informations sont récupérées.
     * @param id L'identifiant du protocole.
     */
    public Donnee(BD bdd, int id) {
        ArrayList<Object> bdddonnee = bdd.getProtocole(id);
        this.bdd = bdd;
        this.idprotocole = id;
        this.titreprotocole = (String) bdddonnee.get(0);
        this.descriptionprotocole = (String) bdddonnee.get(1);
        this.reponse = (int) bdddonnee.get(2);
        System.out.println("la reponse du protocole est : " +reponse);
        this.reponsetest=bdd.getTest(id);
    }

    /**
     * Calcule la répartition des résultats des tests en termes de réussites et d'échecs.
     *
     * @param reponsetest Les résultats des tests.
     * @return Une carte (Map) avec les clés "réussie" et "échoue" associées au nombre correspondant de réussites et d'échecs.
     */
    private Map<String, Object[]> reussite(ArrayList<Integer> reponsetest,BD bdd) {
        Map<String,Object[]> data = new HashMap<>();
        int valeurs = 0;
        int echoue = 0;
        Object[] reussie = {valeurs,Color.green} ;
        data.put("réussie",reussie);
      
        for (Integer element : reponsetest ) {
            System.out.println(element);
            if( element == reponse ) {
                data.put("réussie",++reussie[0]);
                System.out.println(valeurs);
            }else{
                data.put(bdd.getActionLabel(element), ++echoue);
                System.out.println(echoue);
            }
        }
        return data;
    }

    /**
     * Obtient la répartition des résultats des tests en termes de réussites et d'échecs.
     *
     * @return Une carte (Map) avec les clés "réussie" et "échoue" associées au nombre correspondant de réussites et d'échecs.
     */
    public Map<String, Integer> getReussite() {
        return reussite(reponsetest,bdd);
    }

    /**
     * Obtient la description du protocole.
     *
     * @return La description du protocole.
     */
    public String getDescriptionprotocole() {
        return descriptionprotocole;
    }

    /**
     * Obtient l'identifiant du protocole.
     *
     * @return L'identifiant du protocole.
     */
    public int getIdprotocole() {
        return idprotocole;
    }

    /**
     * Obtient la réponse attendue pour le protocole.
     *
     * @return La réponse attendue pour le protocole.
     */
    public int getReponse() {
        return reponse;
    }

    /**
     * Obtient les résultats des tests effectués pour le protocole.
     *
     * @return Les résultats des tests effectués pour le protocole.
     */
    public ArrayList<Integer> getReponsetest() {
        return reponsetest;
    }

    /**
     * Obtient le titre du protocole.
     *
     * @return Le titre du protocole.
     */
    public String getTitreprotocole() {
        return titreprotocole;
    }
}
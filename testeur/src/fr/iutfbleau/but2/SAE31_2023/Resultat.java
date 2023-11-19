import java.util.ArrayList;

/**
 * La classe Resultat représente les résultats d'un test, incluant l'historique des sélections effectuées.
 * Elle offre des méthodes pour enregistrer une nouvelle sélection dans l'historique, récupérer l'historique
 * des sélections, obtenir le dernier choix effectué, obtenir le dernier ID choisi, et finaliser le test en
 * enregistrant les résultats dans la base de données.
 */
public class Resultat {

    /** L'historique des sélections effectuées pendant le test */
    private ArrayList<Integer> historique;

    /** L'indice du dernier choix effectué dans l'historique */
    private int dernierChoisi;

    /** L'identifiant du dernier choix effectué */
    private int dernierID;

    /**
     * Construit un objet Resultat avec un historique vide.
     */
    public Resultat() {

        historique = new ArrayList<>();
        dernierChoisi = 0;
        
    }

    /**
     * Ajoute une nouvelle sélection à l'historique.
     *
     * @param chemin L'indice de la sélection effectuée.
     */
    public void ajouterSelection(int chemin) {

        System.out.println(chemin);

        System.out.println("\n");
        historique.add(chemin); // Cloner le tableau pour éviter les modifications ultérieures
        dernierChoisi = chemin;
    }

    /**
     * Obtient l'historique des sélections effectuées pendant le test.
     *
     * @return L'historique des sélections.
     */
    public ArrayList<Integer> getHistorique() {
        return historique;
    }

    /**
     * Obtient l'indice du dernier choix effectué dans l'historique.
     *
     * @return L'indice du dernier choix effectué.
     */
    public int getDernierChoisi() {
        return dernierChoisi;
    }

    /**
     * Définit l'identifiant du dernier choix effectué.
     *
     * @param id L'identifiant du dernier choix effectué.
     */
    public void setIDDernierChoisi(int id) {
        dernierID = id;
    }

    /**
     * Obtient l'identifiant du dernier choix effectué.
     *
     * @return L'identifiant du dernier choix effectué.
     */
    public int getIDDernierChoisi() {
        return dernierID;
    }

    /**
     * Finalise le test en enregistrant les résultats dans la base de données.
     *
     * @param bdd La base de données utilisée pour enregistrer les résultats.
     * @param protocole L'instance de la classe Protocole pour récupérer l'ID du protocole en cours.
     */
    public void finTest(BD bdd, Protocole protocole) {
        
        int idtest = bdd.setTest(protocole.getIDProtocolchoisie(), this.getIDDernierChoisi());
        System.out.println(idtest+"  id test");
        int rang = 0;
        for(int i : historique) {
            bdd.setHistorique(idtest, i, rang);
            rang++;
        }
    }
}

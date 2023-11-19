import java.util.ArrayList;

/**
 * La classe Noeud représente un nœud dans une structure d'arbre.
 * Chaque nœud possède un identifiant unique (ID), un nom, un rang, et une liste d'enfants.
 */
public class Noeud {

    /** L'identifiant unique du nœud */
    public int ID;

    /** Le nom du nœud */
    public String name;

    /** Le rang du nœud */
    public int rang;

    /** La liste des enfants du nœud */
    public ArrayList<Noeud> enfants;

    /**
     * Constructeur de la classe Noeud.
     *
     * @param ID   L'identifiant unique du nœud.
     * @param nom  Le nom du nœud.
     * @param rang Le rang du nœud.
     */
    public Noeud(int ID, String nom, int rang) {

        this.ID = ID;
        this.name = nom;
        this.rang = rang;
        this.enfants = new ArrayList<>();
    }

    /**
     * Ajoute un nœud en tant qu'enfant du nœud actuel.
     *
     * @param enfant Le nœud à ajouter en tant qu'enfant.
     */
    public void ajouterEnfant(Noeud enfant) {
        this.enfants.add(enfant);
    }

    /**
     * Obtient la liste des enfants du nœud.
     *
     * @return La liste des enfants du nœud.
     */
    public ArrayList<Noeud> getEnfants() {
        return enfants;
    }

    /**
     * Obtient l'identifiant du nœud.
     *
     * @return L'identifiant du nœud.
     */
    public int getID() {
        return ID;
    }

    /**
     * Obtient une représentation textuelle du nœud (son nom).
     *
     * @return Le nom du nœud.
     */
    @Override
    public String toString() {
        return name;
    }
}
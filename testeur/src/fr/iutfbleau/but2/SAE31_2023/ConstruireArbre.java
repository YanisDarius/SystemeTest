import javax.swing.tree.DefaultMutableTreeNode;

/**
 * La classe ConstruireArbre étend DefaultMutableTreeNode et représente un nœud
 * d'un arbre. Chaque nœud a un nom (représenté par la classe parente
 * DefaultMutableTreeNode) et un identifiant unique.
 */
public class ConstruireArbre extends DefaultMutableTreeNode {

    /** L'identifiant unique du nœud */
    private int ID;

    /**
     * Constructeur de la classe ConstruireArbre.
     *
     * @param nomNoeud Le nom du nœud.
     * @param ID       L'identifiant unique du nœud.
     */
    public ConstruireArbre(String nomNoeud, int ID) {
        
        super(nomNoeud);
        this.ID = ID;
    }

    /**
     * Obtient l'identifiant unique du nœud.
     *
     * @return L'identifiant unique du nœud.
     */
    public int getID() {
        return ID;
    }

    /**
     * Retourne une représentation sous forme de chaîne de caractères du nœud.
     *
     * @return Le nom du nœud.
     */
    @Override
    public String toString() {
        return super.toString();
    }
}
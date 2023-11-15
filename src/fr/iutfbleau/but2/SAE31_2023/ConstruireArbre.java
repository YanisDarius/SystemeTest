import javax.swing.tree.DefaultMutableTreeNode;

public class ConstruireArbre extends DefaultMutableTreeNode {
    private int ID;

    public ConstruireArbre(String nomNoeud,int ID ){
        super(nomNoeud);
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    @Override
    public String toString() {
        return super.toString();
    }
    
}

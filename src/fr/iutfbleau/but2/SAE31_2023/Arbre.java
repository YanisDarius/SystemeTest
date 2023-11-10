import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;



public class Arbre extends JTree {

    public Arbre() {
        Noeud root = this.buildTree();
        DefaultMutableTreeNode rootNode = convertToTreeNode(root);

        // Création du modèle du JTree avec la racine
        DefaultTreeModel treeModel = new DefaultTreeModel(rootNode);

        // Appeler le constructeur de la classe parent avec le modèle
        super.setModel(treeModel);
    }

    private DefaultMutableTreeNode convertToTreeNode(Noeud node) {
        DefaultMutableTreeNode treeNode = new DefaultMutableTreeNode(node.name);
        for (Noeud child : node.enfants) {
            treeNode.add(convertToTreeNode(child));
        }
        return treeNode;
    }

    
    private Noeud buildTree() {
        Noeud root = new Noeud("Root",2);

        Noeud documents = new Noeud("Documents", 2);
        documents.ajouterEnfant(new Noeud("Images", 1));
        documents.ajouterEnfant(new Noeud("Vacation", 3));

        Noeud work = new Noeud("Work", 1);
        work.ajouterEnfant(new Noeud("Reports", 2));
        work.ajouterEnfant(new Noeud("Presentations", 1));

        documents.ajouterEnfant(work);
        root.ajouterEnfant(documents);

        Noeud downloads = new Noeud("Downloads", 2);
        root.ajouterEnfant(downloads);

        Noeud applications = new Noeud("Applications", 1);
        applications.ajouterEnfant(new Noeud("Games", 3));
        applications.ajouterEnfant(new Noeud("Utilities", 2));

        root.ajouterEnfant(applications);

        return root;
    } 
}


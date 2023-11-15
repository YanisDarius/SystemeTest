import java.awt.Color;
import java.awt.Font;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;

public class Arbre extends JTree {

    private Noeud root;

    public Arbre() {
        root = this.buildTree();
        DefaultMutableTreeNode rootNode = convertToTreeNode(root);

        // Création du modèle du JTree avec la racine
        DefaultTreeModel treeModel = new DefaultTreeModel(rootNode);
        super.setModel(treeModel);

        // Personnalisez le rendu pour améliorer l'esthétique
        DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
        renderer.setFont(new Font("Arial", Font.PLAIN, 14));
        renderer.setBackgroundSelectionColor(Color.LIGHT_GRAY);
        renderer.setBorderSelectionColor(Color.LIGHT_GRAY);
        renderer.setTextSelectionColor(Color.BLACK);

        // Définissez une icône personnalisée pour les nœuds
        URL customIconURL = Menu.class.getResource("custom_icon.png");
        if (customIconURL != null) {
            ImageIcon customIcon = new ImageIcon(customIconURL);
            renderer.setLeafIcon(customIcon);
            renderer.setOpenIcon(customIcon);
            renderer.setClosedIcon(customIcon);
        }
        this.setCellRenderer(renderer);
    }

    public Arbre(Noeud racine) {
        root = racine;
        DefaultMutableTreeNode rootNode = convertToTreeNode(root);
        DefaultTreeModel treeModel = new DefaultTreeModel(rootNode);
        super.setModel(treeModel);

        DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
        renderer.setFont(new Font("Arial", Font.PLAIN, 14));
        renderer.setBackgroundSelectionColor(Color.LIGHT_GRAY);
        renderer.setBorderSelectionColor(Color.LIGHT_GRAY);
        renderer.setTextSelectionColor(Color.BLACK);

        //personalisation des noeuds
        URL customIconURL = Menu.class.getResource("custom_icon.png");
        if (customIconURL != null) {
            ImageIcon customIcon = new ImageIcon(customIconURL);
            renderer.setLeafIcon(customIcon);
            renderer.setOpenIcon(customIcon);
            renderer.setClosedIcon(customIcon);
        }
        this.setCellRenderer(renderer);


    }

    private ConstruireArbre convertToTreeNode(Noeud node) {
        ConstruireArbre treeNode = new ConstruireArbre(node.name,node.ID);
        for (Noeud child : node.enfants) {
            treeNode.add(convertToTreeNode(child));
        }
        return treeNode;
    }

    private static Noeud buildTree() {
        Noeud root = new Noeud("Root", 2);

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

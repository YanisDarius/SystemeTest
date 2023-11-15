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

    
}

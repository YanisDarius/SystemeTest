import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;


public class Menu {

    private JScrollPane scrollPane;

    public Menu() {
    DefaultMutableTreeNode root = new DefaultMutableTreeNode("Menu Principal");
            DefaultMutableTreeNode menu1 = new DefaultMutableTreeNode("Menu 1");
            DefaultMutableTreeNode menu2 = new DefaultMutableTreeNode("Menu 2");
            DefaultMutableTreeNode submenu1 = new DefaultMutableTreeNode("Sous-Menu 1");
            DefaultMutableTreeNode submenu2 = new DefaultMutableTreeNode("Sous-Menu 2");
            DefaultMutableTreeNode subsubmenu1 = new DefaultMutableTreeNode("Sous-Sous-Menu 1");
            DefaultMutableTreeNode subsubmenu2 = new DefaultMutableTreeNode("Sous-Sous-Menu 2");

            // Ajoutez les nœuds à la structure arbre
            root.add(menu1);
            root.add(menu2);
            menu1.add(submenu1);
            menu1.add(submenu2);
            submenu1.add(subsubmenu1);
            submenu1.add(subsubmenu2);

            // Créez le modèle du JTree avec la racine
            DefaultTreeModel treeModel = new DefaultTreeModel(root);

            // Créez le JTree avec le modèle
            JTree tree = new JTree(treeModel);

            // Ajoutez le JTree à un JScrollPane pour la gestion des défilements
            scrollPane = new JScrollPane(tree);
    }

   public JScrollPane getTree() {
    return scrollPane;
   }
        
}

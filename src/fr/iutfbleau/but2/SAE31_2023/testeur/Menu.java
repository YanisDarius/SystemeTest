import java.awt.Color;
import java.awt.Font;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
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
        root.add(menu2);
        root.add(menu1);

        menu1.add(submenu1);
        menu1.add(submenu2);
        submenu1.add(subsubmenu1);
        submenu1.add(subsubmenu2);

        // Créez le modèle du JTree avec la racine
        DefaultTreeModel treeModel = new DefaultTreeModel(root);

        // Créez le JTree avec le modèle
        JTree tree = new JTree(treeModel);

        // Personnalisez le rendu pour améliorer l'esthétique
        DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
        renderer.setFont(new Font("Arial", Font.PLAIN, 14)); // Définissez la police
        renderer.setBackgroundSelectionColor(Color.LIGHT_GRAY); // Couleur de fond en sélection
        renderer.setBorderSelectionColor(Color.LIGHT_GRAY); // Couleur de bordure en sélection
        renderer.setTextSelectionColor(Color.BLACK); // Couleur du texte en sélection

        // Définissez une icône personnalisée pour les nœuds
        URL customIconURL = Menu.class.getResource("custom_icon.png");
        if (customIconURL != null) {
            ImageIcon customIcon = new ImageIcon(customIconURL);
            renderer.setLeafIcon(customIcon); // Icône pour les feuilles
            renderer.setOpenIcon(customIcon); // Icône pour les nœuds ouverts
            renderer.setClosedIcon(customIcon); // Icône pour les nœuds fermés
        }

        tree.setCellRenderer(renderer);

        // Ajoutez le JTree à un JScrollPane pour la gestion des défilements
        scrollPane = new JScrollPane(tree);

    }

    public JScrollPane getTree() {
        return scrollPane;
    }

    // public static void main(String[] args) {
    // Ecran ecran = new Ecran();

    // Menu menu = new Menu();
    // ecran.ajouterEcran(menu.scrollPane);
    // }
}

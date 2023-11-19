import java.awt.Color;
import java.awt.Font;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;

/**
 * La classe Arbre étend la classe JTree pour représenter un arbre graphique.
 * Elle utilise des nœuds de type Noeud pour construire la structure de l'arbre.
 */
public class Arbre extends JTree {

    /** Le nœud racine de l'arbre */
    private Noeud root;

    /**
     * Constructeur de la classe Arbre.
     *
     * @param racine Le nœud racine de l'arbre.
     */
    public Arbre(Noeud racine) {
        
        root = racine;
        ConstruireArbre rootNode = convertToTreeNode(root);
        DefaultTreeModel treeModel = new DefaultTreeModel(rootNode);
        super.setModel(treeModel);

        // Configuration du rendu des cellules de l'arbre
        DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
        renderer.setFont(new Font("Arial", Font.PLAIN, 14));
        renderer.setBackgroundSelectionColor(Color.LIGHT_GRAY);
        renderer.setBorderSelectionColor(Color.LIGHT_GRAY);
        renderer.setTextSelectionColor(Color.BLACK);

        // Personnalisation des icônes des nœuds
        URL customIconURL = Menu.class.getResource("custom_icon.png");

        if (customIconURL != null) {
            ImageIcon customIcon = new ImageIcon(customIconURL);
            renderer.setLeafIcon(customIcon);
            renderer.setOpenIcon(customIcon);
            renderer.setClosedIcon(customIcon);
        }

        this.setCellRenderer(renderer);
    }

    /**
     * Convertit un nœud de type Noeud en un nœud de type ConstruireArbre pour la
     * construction de l'arbre graphique.
     *
     * @param node Le nœud de type Noeud à convertir.
     * @return Le nœud de type ConstruireArbre correspondant.
     */
    private ConstruireArbre convertToTreeNode(Noeud node) {

        if (node == null) {
            return null;
        }

        ConstruireArbre treeNode = new ConstruireArbre(node.name, node.ID);

        for (Noeud child : node.enfants) {
            treeNode.add(convertToTreeNode(child));
        }
        return treeNode;
    }
}
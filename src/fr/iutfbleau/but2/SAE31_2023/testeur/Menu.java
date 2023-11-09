import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

public class Menu extends JPanel {

    private JScrollPane scrollPane;
    private JLabel cheminLabel;
    

    public Menu(Ecran ecran) {

        Resultat resultat = new Resultat();

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

        // Créer le bouton "Retour"
        JButton retourButton = new JButton("Retour");
        retourButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ManipulationEcran(ecran, "protocole");
            }
        });

         JButton valideButton = new JButton("valide");
        valideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });


        // Créer le label pour afficher le chemin parcouru
        cheminLabel = new JLabel("Chemin : ");

        // Ajouter un écouteur de sélection pour mettre à jour le cheminLabel
        tree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                // Récupérer le chemin sélectionné
                Object[] path = e.getPath().getPath();
                resultat.setCheminActuel(path);
                // Mettre à jour le texte du label avec le chemin
                StringBuilder chemin = new StringBuilder("Chemin : ");
                for (Object noeud : path) {
                    chemin.append(noeud.toString()).append(" > ");
                }
                cheminLabel.setText(chemin.toString());
            }
        });

        setLayout(new BorderLayout());
        JPanel jpanel2 = new JPanel();

        add(scrollPane, BorderLayout.CENTER);
        jpanel2.add(valideButton);
        add(jpanel2,BorderLayout.EAST);
        // Utiliser BorderLayout pour le panneau principal
        JPanel jpanel = new JPanel();
        jpanel.setLayout(new BorderLayout());
        // Utiliser FlowLayout avec alignement à droite pour le panneau contenant le bouton et le label
        JPanel flowPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPanel flowPane2 = new JPanel(new FlowLayout(FlowLayout.LEFT));

        flowPane2.add(cheminLabel);
        flowPanel.add(retourButton);
        jpanel.add(flowPanel, BorderLayout.EAST);
        jpanel.add(flowPane2, BorderLayout.WEST);

        add(jpanel, BorderLayout.SOUTH);
    }
}

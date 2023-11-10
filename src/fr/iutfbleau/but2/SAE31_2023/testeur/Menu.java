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

        Arbre arbre = new Arbre();

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

        arbre.setCellRenderer(renderer);

        // Ajoutez le JTree à un JScrollPane pour la gestion des défilements
        scrollPane = new JScrollPane(arbre);

        // Créer le bouton "Retour"
        JButton retourButton = new JButton("Retour");
        retourButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ManipulationEcran(ecran, "protocole");
            }
        });

         JButton valideButton = new JButton("Valider");
        valideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ManipulationEcran(ecran, "fin");
            }
        });


        // Créer le label pour afficher le chemin parcouru
        cheminLabel = new JLabel("Chemin : ");

        // Ajouter un écouteur de sélection pour mettre à jour le cheminLabel
        arbre.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                // Récupérer le chemin sélectionné
                Object[] path = e.getPath().getPath();
               // resultat.setCheminActuel(path);
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

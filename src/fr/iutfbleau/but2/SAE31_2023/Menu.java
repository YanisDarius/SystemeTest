import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

public class Menu extends JPanel {

    private JScrollPane scrollPane;
    private JLabel cheminLabel;
    private Resultat resultat;  

    public Menu(Ecran ecran, Noeud racine) {
        resultat = new Resultat();  // Initialiser l'instance de Resultat

        Arbre arbre = new Arbre();  // Utiliser le constructeur d'Arbre avec la racine
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

        // Ajouter un écouteur de sélection pour mettre à jour le cheminLabel et enregistrer la sélection
        arbre.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                // Récupérer le chemin sélectionné
                Object[] path = e.getPath().getPath();
                resultat.ajouterSelection(path);  // Enregistrer la sélection dans l'historique
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
        add(jpanel2, BorderLayout.EAST);

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

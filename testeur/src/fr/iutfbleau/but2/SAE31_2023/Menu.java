import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeWillExpandListener;
import javax.swing.tree.ExpandVetoException;

/**
 * La classe Menu représente un panneau Swing affichant un arbre (JTree) avec des options de navigation,
 * un bouton de retour, un bouton de validation, et des informations sur le protocole en cours.
 */
public class Menu extends JPanel {

    /** Le JScrollPane contenant l'arbre (JTree) */
    private JScrollPane scrollPane;

    /** Le JLabel affichant le chemin parcouru */
    private JLabel cheminLabel;

    /** Le panneau d'affichage des résultats du test */
    private Resultat resultat;

    /** L'identifiant du nœud sélectionné dans l'arbre */
    private int id;

    /**
     * Constructeur de la classe Menu.
     *
     * @param ecran L'instance de la classe Ecran utilisée pour la gestion des écrans.
     * @param racine La racine de l'arbre (Noeud).
     * @param bdd L'instance de la classe BD pour la gestion de la base de données.
     * @param protocole L'instance de la classe Protocole pour la gestion du protocole en cours.
     */
    public Menu(Ecran ecran, Noeud racine, BD bdd, Protocole protocole) {
        
        Arbre arbre = new Arbre(racine);
        String nomtext = protocole.getProtocolNom();
        String descriptiontext = protocole.getProtocolDescription();
        resultat = new Resultat();

        scrollPane = new JScrollPane(arbre);

        // Créer le bouton "Retour"
        JButton retourButton = new JButton("Retour");
        retourButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ecran.ecranSuivant("protocole");
            }
        });

        // Créer le bouton de validation
        JButton valideButton = new JButton("Valider");
        valideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultat.finTest(bdd, protocole);
                ecran.ecranSuivant("fin");
            }
        });

        JLabel nom = new JLabel(nomtext);
        nom.setFont(new Font("Arial", Font.BOLD, 12)); // Taille de police augmentée

        JTextArea description = new JTextArea(descriptiontext);
        description.setLineWrap(true);
        description.setWrapStyleWord(true);
        description.setEditable(false);

        // Créer le label pour afficher le chemin parcouru
        cheminLabel = new JLabel("Chemin : ");

        arbre.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                updateCheminLabel(e);
            }
        });

        arbre.addTreeWillExpandListener(new TreeWillExpandListener() {
            @Override
            public void treeWillExpand(TreeExpansionEvent event) throws ExpandVetoException {
                updateCheminLabel(event);
            }

            @Override
            public void treeWillCollapse(TreeExpansionEvent event) throws ExpandVetoException {
                // Ne rien faire lors de la fermeture de l'arbre
            }
        });

        setLayout(new BorderLayout());
        JPanel jpanel2 = new JPanel();
        jpanel2.setLayout(new BorderLayout());
        jpanel2.setPreferredSize(new Dimension(200, 0)); // Largeur fixe, hauteur par défaut

        add(scrollPane, BorderLayout.CENTER);
        jpanel2.add(valideButton, BorderLayout.SOUTH);
        jpanel2.add(nom, BorderLayout.NORTH);
        jpanel2.add(new JScrollPane(description), BorderLayout.CENTER);
        add(jpanel2, BorderLayout.EAST);

        // Utiliser BorderLayout pour le panneau principal
        JPanel jpanel = new JPanel();
        jpanel.setLayout(new BorderLayout());
        // Utiliser FlowLayout avec alignement à droite pour le panneau contenant le
        // bouton et le label
        JPanel flowPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPanel flowPane2 = new JPanel(new FlowLayout(FlowLayout.LEFT));

        flowPane2.add(cheminLabel);
        flowPanel.add(retourButton);
        jpanel.add(flowPanel, BorderLayout.EAST);
        jpanel.add(flowPane2, BorderLayout.WEST);

        add(jpanel, BorderLayout.SOUTH);
    }

    /**
     * Met à jour le label du chemin parcouru en fonction de la sélection ou de l'expansion
     * d'un nœud dans l'arbre.
     *
     * @param event L'événement TreeSelectionEvent ou TreeExpansionEvent.
     */
    private void updateCheminLabel(Object event) {

        Object[] path;
        if (event instanceof TreeSelectionEvent) {
            path = ((TreeSelectionEvent) event).getPath().getPath();
        } else if (event instanceof TreeExpansionEvent) {
            path = ((TreeExpansionEvent) event).getPath().getPath();
        } else {
            return;
        }

        Object dernierNoeud = path[path.length - 1];

        // Vérifier si le nœud est une instance de ConstruireArbre
        if (dernierNoeud instanceof ConstruireArbre) {
            ConstruireArbre construireArbre = (ConstruireArbre) dernierNoeud;
            id = construireArbre.getID();
            resultat.setIDDernierChoisi(id);
            resultat.ajouterSelection(id);

            StringBuilder chemin = new StringBuilder("Chemin : ");
            for (Object noeud : path) {
                chemin.append(noeud.toString()).append(" > ");
            }
            cheminLabel.setText(chemin.toString());
        }
    }
}

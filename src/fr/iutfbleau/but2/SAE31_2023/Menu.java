import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeWillExpandListener;

import javax.swing.tree.ExpandVetoException;

public class Menu extends JPanel {

    private JScrollPane scrollPane;
    private JLabel cheminLabel;
    private Resultat resultat;
    private int id;

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

                Object[] path = e.getPath().getPath();
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
        });

        arbre.addTreeWillExpandListener(new TreeWillExpandListener() {
            @Override
            public void treeWillExpand(TreeExpansionEvent event) throws ExpandVetoException {
                Object[] path = event.getPath().getPath();
                Object dernierNoeud = path[path.length - 1];

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

            @Override
            public void treeWillCollapse(TreeExpansionEvent event) throws ExpandVetoException {

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
}

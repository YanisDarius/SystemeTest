import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeWillExpandListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.ExpandVetoException;

public class Menu extends JPanel {

    private JScrollPane scrollPane;
    private JLabel cheminLabel;
    private Resultat resultat;
    private int id;

    public Menu(Ecran ecran, Noeud racine, BD bdd, Protocole protocole) {
        Arbre arbre = new Arbre(racine);

        resultat = new Resultat(); // Initialiser l'instance de Resultat

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
                bdd.setTest(protocole.getIDProtocolChoisi(), resultat.getIDDernierChoisi());
                
                ecran.ecranSuivant("fin");
              
            }
        });

        // Créer le label pour afficher le chemin parcouru
        cheminLabel = new JLabel("Chemin : ");

        // Ajouter un écouteur de sélection pour mettre à jour le cheminLabel et
        // enregistrer la sélection
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
                    System.out.println("ID du nœud sélectionné : " + id);
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

                resultat.ajouterSelection(id); // Enregistrer la sélection dans l'historique
                StringBuilder chemin = new StringBuilder("Chemin : ");
                for (Object noeud : path) {
                    chemin.append(noeud.toString()).append(" > ");
                }
                cheminLabel.setText(chemin.toString());
            }

            @Override
            public void treeWillCollapse(TreeExpansionEvent event) throws ExpandVetoException {
                // Code à exécuter avant la réduction du nœud
            }
        });

        setLayout(new BorderLayout());
        JPanel jpanel2 = new JPanel();
        jpanel2.setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        jpanel2.add(valideButton, BorderLayout.SOUTH);
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

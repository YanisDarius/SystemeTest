import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Le panneau (JPanel) PiedDePage est utilisé comme pied de page pour la navigation entre les écrans.
 * Il contient des boutons pour accéder aux écrans "Réussite" et "Historique", ainsi qu'un bouton "Quitter" pour terminer l'application.
 *
 * @param ecran L'instance de la classe Ecran utilisée pour la gestion des écrans.
 */
public class PiedDePage extends JPanel {

    /**
     * Constructeur de la classe PiedDePage.
     *
     * @param ecran L'instance de la classe Ecran utilisée pour la gestion des écrans.
     */
    public PiedDePage(Ecran ecran) {

        JButton reussite = new JButton("réussite") ;
        JButton historique = new JButton("historique");
        
        setLayout(new BorderLayout());
        JPanel flowPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPanel flowPane2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        reussite.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Bouton Réussite cliqué");
                    ecran.ecranSuivant("réussite");
            }
        });
        
        historique.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Bouton Historique cliqué");
                ecran.ecranSuivant("historique");
            }
        });

        JButton quitter = new JButton("Quitter");
        quitter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                ecran.ecranSuivant("TERMINER");
            }
        });
        
        flowPanel.add(quitter);
        flowPane2.add(reussite);
        flowPane2.add(historique);

        add(flowPanel, BorderLayout.EAST);
        add(flowPane2, BorderLayout.WEST);

    }
}

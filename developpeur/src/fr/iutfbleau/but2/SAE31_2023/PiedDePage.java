import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PiedDePage extends JPanel {

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

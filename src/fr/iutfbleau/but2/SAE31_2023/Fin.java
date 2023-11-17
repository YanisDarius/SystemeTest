import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fin extends JPanel {

    public Fin(Ecran ecran,BD bdd) {
        setLayout(new GridBagLayout());

        // Ajoutez une étiquette de remerciement
        JLabel remerciementsLabel = new JLabel("Merci d'avoir participé au test !");
        remerciementsLabel.setFont(new Font("Arial", Font.PLAIN, 18));

        GridBagConstraints labelConstraints = new GridBagConstraints();
        labelConstraints.gridx = 0;
        labelConstraints.gridy = 0;
        labelConstraints.insets = new java.awt.Insets(10, 10, 10, 10);

        JButton quitter = new JButton("Quitter");
        quitter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bdd.fermerRessource();
                ecran.ecranSuivant("TERMINER");
            }
        });

        GridBagConstraints buttonConstraints = new GridBagConstraints();
        buttonConstraints.gridx = 0;
        buttonConstraints.gridy = 1;
        buttonConstraints.insets = new java.awt.Insets(10, 10, 10, 10);

        add(remerciementsLabel, labelConstraints);
        add(quitter, buttonConstraints);
    }
}

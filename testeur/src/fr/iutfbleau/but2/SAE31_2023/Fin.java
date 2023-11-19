import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * La classe Fin représente un panneau Swing affichant un message de remerciement
 * et un bouton "Quitter" pour terminer l'application.
 */
public class Fin extends JPanel {

    /**
     * Constructeur de la classe Fin.
     *
     * @param ecran L'instance de la classe Ecran utilisée pour la gestion des écrans.
     */
    public Fin(Ecran ecran) {
        
        setLayout(new GridBagLayout());

        // Ajoutez une étiquette de remerciement
        JLabel remerciementsLabel = new JLabel("Merci d'avoir participé au test !");
        remerciementsLabel.setFont(new Font("Arial", Font.PLAIN, 18));

        GridBagConstraints labelConstraints = new GridBagConstraints();
        labelConstraints.gridx = 0;
        labelConstraints.gridy = 0;
        labelConstraints.insets = new java.awt.Insets(10, 10, 10, 10);

        // Ajoutez un bouton "Quitter" avec un gestionnaire d'événements
        JButton quitter = new JButton("Quitter");
        quitter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ferme la connexion à la base de données et passe à l'écran de fin
                ecran.ecranSuivant("TERMINER");
            }
        });

        GridBagConstraints buttonConstraints = new GridBagConstraints();
        buttonConstraints.gridx = 0;
        buttonConstraints.gridy = 1;
        buttonConstraints.insets = new java.awt.Insets(10, 10, 10, 10);

        // Ajoutez les composants au panneau
        add(remerciementsLabel, labelConstraints);
        add(quitter, buttonConstraints);
    }
}
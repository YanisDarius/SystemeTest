import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Protocole extends JPanel {

    private boolean protocolSelection = false;
    private String protocolChoisi ;

    public Protocole(Ecran ecran) {
        
        setLayout(new GridBagLayout()); // Utilisation de GridBagLayout pour la mise en page
        
        // Titre
        JLabel titleLabel = new JLabel("Sélectionnez un protocole :");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20)); // Augmentez la taille de la police
        GridBagConstraints titleConstraints = new GridBagConstraints();
        titleConstraints.gridx = 0;
        titleConstraints.gridy = 0;
        titleConstraints.gridwidth = 1;
        titleConstraints.insets = new Insets(10, 10, 20, 10); // Espacement en bas
        add(titleLabel, titleConstraints);

        // ComboBox pour la sélection du protocole
        String[] protocols = {"Protocole 1", "Protocole 2", "Protocole 3"};
        JComboBox<String> protocolComboBox = new JComboBox<>(protocols);
        protocolComboBox.setPreferredSize(new Dimension(200, 30)); // Taille personnalisée
        GridBagConstraints comboBoxConstraints = new GridBagConstraints();
        comboBoxConstraints.gridx = 0;
        comboBoxConstraints.gridy = 1;
        comboBoxConstraints.gridwidth = 1;
        comboBoxConstraints.insets = new Insets(0, 10, 10, 10); // Espacement en bas
        add(protocolComboBox, comboBoxConstraints);

        JTextField description =new  JTextField("description");
        description.setPreferredSize(new Dimension(200,30));
        description.setEditable(false);
        description.setHorizontalAlignment(JTextField.CENTER);
        description.setBorder(BorderFactory.createEmptyBorder());
        GridBagConstraints textFieldContraints = new GridBagConstraints();
        textFieldContraints.gridx = 0;
        textFieldContraints.gridy = 2;
        textFieldContraints.gridwidth = 1;
        textFieldContraints.insets = new Insets(0, 10, 10, 10);
        add(description,textFieldContraints);



        

        // Bouton de démarrage
        JButton startTestButton = new JButton("Démarrer le Test");
        startTestButton.setPreferredSize(new Dimension(150, 40)); // Taille personnalisée
        GridBagConstraints buttonConstraints = new GridBagConstraints();
        buttonConstraints.gridx = 0;
        buttonConstraints.gridy = 3;
        buttonConstraints.gridwidth = 1;
        buttonConstraints.insets = new Insets(0, 10, 10, 10); // Espacement en bas
        add(startTestButton, buttonConstraints);

        // Gérer l'événement lorsque le bouton est cliqué
        startTestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                protocolChoisi = (String) protocolComboBox.getSelectedItem();

                new ManipulationEcran(ecran,"menu");
                
                // Ici, vous pouvez récupérer le protocole sélectionné et continuer le processus de test.
                // Vous pouvez interagir avec la base de données pour obtenir les détails du protocole.
                // Puis lancez la suite du test.
                // N'oubliez pas de gérer les erreurs potentielles liées à la base de données.
                
            }
        });
    }
    public String getProtocolChoisi() {
        return protocolChoisi;
    }
    public boolean isProtocolSelected() {
        return protocolSelection;
    }
}

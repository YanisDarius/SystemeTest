import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Protocole extends JPanel {

    private String protocolChoisi;
    private String descriptionText;
    private int ID;

    public Protocole(Ecran ecran, ArrayList<Object> données) {

        setLayout(new GridBagLayout()); // Utilisation de GridBagLayout pour la mise en page
        RessourcesProtocol ressources = new RessourcesProtocol(données);
        descriptionText = ressources.getFirstDescription();

        // Titre
        JLabel titleLabel = new JLabel("Sélectionnez un protocole :");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20)); // Augmentez la taille de la police
        GridBagConstraints titleConstraints = new GridBagConstraints();
        titleConstraints.gridx = 0;
        titleConstraints.gridy = 0;
        titleConstraints.gridwidth = 1;
        titleConstraints.insets = new Insets(10, 10, 20, 10); // Espacement en bas
        add(titleLabel, titleConstraints);

        JTextField recherche = new JTextField();
        recherche.setPreferredSize(new Dimension(200, 30));
        GridBagConstraints rechercheContraints = new GridBagConstraints();
        rechercheContraints.gridx = 0;
        rechercheContraints.gridy = 1;
        rechercheContraints.gridwidth = 1;
        rechercheContraints.insets = new Insets(0, 10, 10, 10);
        add(recherche, rechercheContraints);

        // ComboBox pour la sélection du protocole
        String[] protocols = ressources.getProtocolNom();
        JComboBox<String> protocolComboBox = new JComboBox<>(protocols);
        protocolComboBox.setPreferredSize(new Dimension(200, 30)); // Taille personnalisée
        GridBagConstraints comboBoxConstraints = new GridBagConstraints();
        comboBoxConstraints.gridx = 0;
        comboBoxConstraints.gridy = 2;
        comboBoxConstraints.gridwidth = 1;
        comboBoxConstraints.insets = new Insets(0, 10, 10, 10); // Espacement en bas
        add(protocolComboBox, comboBoxConstraints);

        JTextArea description = new JTextArea(descriptionText);
        description.setPreferredSize(new Dimension(300, 50));
        description.setEditable(false);
        description.setLineWrap(true);
        description.setWrapStyleWord(true);
        description.setOpaque(false);
        description.setAlignmentX(Component.CENTER_ALIGNMENT);
        description.setAlignmentY(Component.CENTER_ALIGNMENT);
        description.setBorder(BorderFactory.createEmptyBorder());
        description.setLineWrap(true);

        description.setAlignmentX(JTextArea.CENTER_ALIGNMENT);
        description.setAlignmentY(JTextArea.CENTER_ALIGNMENT);

        GridBagConstraints textFieldContraints = new GridBagConstraints();
        textFieldContraints.gridx = 0;
        textFieldContraints.gridy = 3;
        textFieldContraints.gridwidth = 1;
        textFieldContraints.fill = GridBagConstraints.HORIZONTAL;
        //textFieldContraints.anchor = GridBagConstraints.CENTER;
        textFieldContraints.insets = new Insets(0, 10, 10, 10);
        add(description, textFieldContraints);

        // Bouton de démarrage
        JButton startTestButton = new JButton("Démarrer le Test");
        startTestButton.setPreferredSize(new Dimension(150, 40)); // Taille personnalisée
        GridBagConstraints buttonConstraints = new GridBagConstraints();
        buttonConstraints.gridx = 0;
        buttonConstraints.gridy = 4;
        buttonConstraints.gridwidth = 1;
        buttonConstraints.insets = new Insets(0, 10, 10, 10); // Espacement en bas
        add(startTestButton, buttonConstraints);

        // Gérer l'événement lorsque le bouton est cliqué
        startTestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                protocolChoisi = (String) protocolComboBox.getSelectedItem();
                ID = ressources.getProtocolID(protocolChoisi);
                System.out.println(ID);
                new ManipulationEcran(ecran, "menu");

            }
        });

        protocolComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                protocolChoisi = (String) protocolComboBox.getSelectedItem();
                descriptionText = ressources.getProtocolDescription(protocolChoisi);
                description.setText(descriptionText);
                System.out.println(descriptionText);
            }
        });
    }

    public String getProtocolChoisi() {
        return protocolChoisi;
    }

    public int protocolID() {
        return ID;
    }

}

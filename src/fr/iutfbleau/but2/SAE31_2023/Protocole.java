import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Protocole extends JPanel {

    private String protocolChoisi;
    private String descriptionText;
    private int ID;
    private String resultatRecherche; // Variable pour stocker le résultat de la recherche
    private RessourcesProtocol ressources;
    private JTextField recherche;
    private JComboBox<String> protocolComboBox;


    public Protocole(Ecran ecran, ArrayList<Object> données) {

        setLayout(new GridBagLayout()); // Utilisation de GridBagLayout pour la mise en page
        ressources = new RessourcesProtocol(données);
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

        recherche = new JTextField();
        recherche.setPreferredSize(new Dimension(200, 30));
        GridBagConstraints rechercheContraints = new GridBagConstraints();
        rechercheContraints.gridx = 0;
        rechercheContraints.gridy = 1;
        rechercheContraints.gridwidth = 1;
        rechercheContraints.insets = new Insets(0, 10, 10, 10);
        add(recherche, rechercheContraints);

        // Ajout d'un écouteur de document au champ de recherche
        recherche.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {

                updateRecherche(ressources.getProtocolNom());

            }

            @Override
            public void removeUpdate(DocumentEvent e) {

                updateRecherche(ressources.getProtocolNom());

            }

            @Override
            public void changedUpdate(DocumentEvent e) {

                updateRecherche(ressources.getProtocolNom());

               
            }
        });

        // ComboBox pour la sélection du protocole
        String[] protocols = ressources.getProtocolNom();
        protocolComboBox = new JComboBox<>(protocols);
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
             
                System.out.println("ID: " + ID);
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


   
    private void updateRecherche(String[] votreListeOriginale) {
        resultatRecherche = recherche.getText();
        ArrayList<String>  listeFiltree;
         listeFiltree = Recherche.filtrerListe(votreListeOriginale, resultatRecherche);
        for (String element : listeFiltree) {
            System.out.println(element);
        }
        updateComboBoxModel(listeFiltree);
    }
    private void updateComboBoxModel(ArrayList<String> filteredList) {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(filteredList.toArray(new String[0]));
        protocolComboBox.setModel(model);
    }
    // Méthode pour mettre à jour la variable resultatRecherche

    public String getProtocolChoisi() {
        return protocolChoisi;
    }

    public int protocolID() {
        return ID;
    }

    public String getResultatRecherche() {
        return resultatRecherche;
    }

    public int getIDProtocolChoisi() {
        return ressources.getProtocolID(protocolChoisi);
    }
  
}

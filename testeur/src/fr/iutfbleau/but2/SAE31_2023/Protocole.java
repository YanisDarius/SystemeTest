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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * La classe Protocole représente un panneau Swing permettant la sélection et l'affichage de protocoles.
 * Elle inclut une fonction de recherche, une liste déroulante pour la sélection des protocoles et une zone de description.
 * La classe fournit également des méthodes pour récupérer des informations sur le protocole sélectionné.
 */
public class Protocole extends JPanel {

    /** Le nom du protocole actuellement sélectionné */
    private String protocolChoisi;

    /** La description du protocole actuellement sélectionné */
    private String descriptionText;

    /** Le résultat de la recherche */
    private String resultatRecherche;

    /** Les ressources de protocoles utilisées pour la construction du panneau */
    private RessourcesProtocol ressources;

    /** Le champ de recherche */
    private JTextField recherche;

    /** La liste déroulante pour la sélection des protocoles */
    private JComboBox<String> protocolComboBox;

    /** L'identifiant du protocole actuellement sélectionné */
    private int id ;

    /** L'identifiant du protocole choisi */
    private int idchoise;

    /** L'écran associé à ce panneau */
    private Ecran ecran;

    /** La base de données associée à ce panneau */
    private BD bdd;

    /**
     * Construit un panneau Protocole avec l'écran et la base de données spécifiés.
     *
     * @param ecran L'écran associé à ce panneau.
     * @param bdd La base de données associée à ce panneau.
     */
    public Protocole(Ecran ecran, BD bdd) {

        this.ecran = ecran;
        this.bdd = bdd;

        id=1;
        ArrayList<Object> donnees = bdd.getProtocole();
        
        setLayout(new GridBagLayout()); // Utilisation de GridBagLayout pour la mise en page
        ressources = new RessourcesProtocol(donnees);
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

        description.setPreferredSize(new Dimension(200, 30));
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
        // textFieldContraints.anchor = GridBagConstraints.CENTER;
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
                idchoise = id;
                System.out.println("protocol ID: " + getIDProtocolchoisie() +"\n"+ "Menu ID:"+ getIDMenuChoisi());
                afficheMenu();
            }
        });

        protocolComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                protocolChoisi = (String) protocolComboBox.getSelectedItem();
                descriptionText = ressources.getProtocolDescription(protocolChoisi);
                description.setText(descriptionText);
                id = ressources.getMenuID(protocolChoisi);
                System.out.println(descriptionText+"\n"+getIDProtocolchoisie());
            }
        });
    }

    /**
     * Met à jour les résultats de la recherche en fonction de la liste originale spécifiée.
     *
     * @param votreListeOriginale La liste originale des noms de protocoles.
     */
    private void updateRecherche(String[] votreListeOriginale) {

        resultatRecherche = recherche.getText();
        ArrayList<String> listeFiltree;
        listeFiltree = Recherche.filtrerListe(votreListeOriginale, resultatRecherche);
        for (String element : listeFiltree) {
            System.out.println(element);
        }
        updateComboBoxModel(listeFiltree);
    }

    /**
     * Met à jour le modèle de la liste déroulante avec la liste filtrée des noms de protocoles.
     *
     * @param filteredList La liste filtrée des noms de protocoles.
     */
    private void updateComboBoxModel(ArrayList<String> filteredList) {

        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(filteredList.toArray(new String[0]));
        protocolComboBox.setModel(model);
    }

    /**
     * Obtient le nom du protocole sélectionné.
     *
     * @return Le nom du protocole sélectionné.
     */
    public String getProtocolChoisi() {
        return protocolChoisi;
    }

    /**
     * Obtient le résultat de la recherche.
     *
     * @return Le résultat de la recherche.
     */
    public String getResultatRecherche() {
        return resultatRecherche;
    }

    /**
     * Obtient l'ID du protocole sélectionné.
     *
     * @return L'ID du protocole sélectionné.
     */
    public int getIDMenuChoisi() {
        return idchoise;
    }

    /**
     * Obtient le nom du protocole sélectionné.
     *
     * @return Le nom du protocole sélectionné.
     */
    public String getProtocolNom() {
        return ressources.getProtoclIDNom(protocolChoisi);
    }

    /**
     * Obtient la description du protocole sélectionné.
     *
     * @return La description du protocole sélectionné.
     */
    public String getProtocolDescription(){
       return ressources.getProtocolDescription(protocolChoisi);
    }

    /**
     * Obtient l'ID du protocole sélectionné.
     *
     * @return L'ID du protocole sélectionné.
     */
    public int getIDProtocolchoisie(){
        return ressources.getProtocolID(protocolChoisi);
    }
    
    /**
     * Affiche le menu pour le protocole sélectionné.
     */
    private void afficheMenu() {

        Menu menu = new Menu(ecran,bdd.getFils(this.getIDMenuChoisi()),bdd,this);
        ecran.ajouterEcran(menu,"menu");
        ecran.ecranSuivant("menu");
    }
}
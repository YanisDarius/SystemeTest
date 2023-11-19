import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

/**
 * La classe Reussite représente le panneau affichant les graphiques de réussite
 * du protocole.
 * Elle hérite de JPanel et utilise un gestionnaire de disposition
 * GridBagLayout.
 */
public class Reussite extends JPanel {

    /**
     * Constructeur de la classe Reussite.
     * Crée et initialise le panneau de réussite avec un titre indiquant le
     * protocole, son identifiant,
     * et un camembert représentant les données de réussite.
     *
     * @param ecran  L'écran associé à ce panneau.
     * @param donnee Les données associées au protocole pour afficher la réussite.
     */
    public Reussite(Ecran ecran, Donnee donnee) {

        setLayout(new BorderLayout());

        JPanel jpanel = new JPanel();
        jpanel.setLayout(new GridBagLayout());

        // Construction du titre avec le nom du protocole et son ID
        StringBuilder titretext = new StringBuilder("Voici le graphique des reusssite du protocole  ");
        titretext.append(donnee.getTitreprotocole()).append("    | ID :").append(donnee.getIdprotocole());
        Titre titre = new Titre(titretext.toString());
        jpanel.add(titre, titre.getContraint());

        // Créer le camembert
        Camembert camembert = new Camembert(donnee.getReussite());
        jpanel.add(camembert, camembert.getConstraints());

        // ajout du pied de page
        PiedDePage pieddepage = new PiedDePage(ecran);

        add(jpanel, BorderLayout.CENTER);
        add(pieddepage, BorderLayout.SOUTH);
    }
}
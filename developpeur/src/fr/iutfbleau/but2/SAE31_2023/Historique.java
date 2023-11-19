import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;

/**
 * Le panneau (JPanel) Historique affiche le graphique des historiques d'un protocole.
 * Il contient un titre avec le nom et l'ID du protocole, ainsi qu'un graphique camembert représentant les données historiques.
 * En bas du panneau, un pied de page est ajouté pour la navigation.
 */
public class Historique extends JPanel {
    
    /**
     * Constructeur de la classe Historique.
     *
     * @param ecran L'instance de la classe Ecran utilisée pour la gestion des écrans.
     * @param donnee L'instance de la classe Donnee contenant les informations du protocole.
     */
    public Historique(Ecran ecran, Donnee donnee) {

        setLayout(new BorderLayout());

        JPanel jpanel = new  JPanel();
        jpanel.setLayout(new GridBagLayout());
        
        // Construction du titre avec le nom du protocole et son ID
        StringBuilder titretext = new StringBuilder("Voici le graphique des historique du protocole  ");
        titretext.append(donnee.getTitreprotocole()).append("    | ID :").append(donnee.getIdprotocole());
        Titre titre = new Titre(titretext.toString());
        jpanel.add(titre,titre.getContraint());

        // Créer le camembert
        Camembert camembert = new Camembert(donnee.getHistorique());
        jpanel.add(camembert, camembert.getConstraints());

        // Ajout du pied de page
        PiedDePage pieddepage = new PiedDePage(ecran);
        
        add(jpanel,BorderLayout.CENTER);
        add(pieddepage,BorderLayout.SOUTH);
    }
}
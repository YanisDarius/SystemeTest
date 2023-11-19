import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import java.util.Map;

import javax.swing.JPanel;

/**
 * La classe Camembert représente un panneau permettant de créer un diagramme camembert (ou pie chart)
 * avec une légende associée. Elle utilise la classe ConstructionCamembert pour générer le camembert
 * et la classe Legend pour afficher la légende.
 */
public class Camembert extends JPanel {

    /** Les contraintes pour le positionnement du diagramme camembert */
    private GridBagConstraints camenbertConstraints;

    /**
     * Construit un objet Camembert avec les données spécifiées pour créer le diagramme.
     *
     * @param donnee Les données pour créer le diagramme camembert.
     */
    public Camembert(Map<String, Object[]> donnee) {

        setLayout(new GridBagLayout());
              
        // Ajoute le diagramme camembert
        ConstructionCamembert constructionCamembert = new ConstructionCamembert(donnee);
        GridBagConstraints constructionCamembertContraints = new GridBagConstraints();
        constructionCamembertContraints.gridx = 0;
        constructionCamembertContraints.gridy = 0;
        add(constructionCamembert, constructionCamembertContraints);

        // Ajoute la légende
        Legend legend = new Legend(donnee);
        GridBagConstraints legencConstraints = new GridBagConstraints();
        legencConstraints.gridx = 1;
        legencConstraints.gridy = 0;

        // Ajuste la position de la légende
        add(legend, camenbertConstraints);

        // Initialise les contraintes pour l'affichage dans l'objet Camembert
        camenbertConstraints = new GridBagConstraints();
        camenbertConstraints.gridx = 0;
        camenbertConstraints.gridy = 2;
        camenbertConstraints.gridwidth = 1;
        camenbertConstraints.insets = new Insets(10, 10, 20, 10);

    }
    
    /**
     * Retourne les contraintes de positionnement du diagramme camembert.
     *
     * @return Les contraintes de positionnement du diagramme camembert.
     */
    public GridBagConstraints getConstraints() {
        return camenbertConstraints;
    }
    
}
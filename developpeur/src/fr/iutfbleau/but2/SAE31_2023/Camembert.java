import java.awt.Color;
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
     * @param donnees Les données pour créer le diagramme camembert.
     */
    public Camembert(Map<String, Integer> donnee,Color[] couleurs) {
        setLayout(new GridBagLayout());
        
        couleurs = generateRandomColors(donnee.size());
        

        

        // Ajoute le diagramme camembert
        ConstructionCamembert constructionCamembert = new ConstructionCamembert(donnee, couleurs);
        GridBagConstraints constructionCamembertContraints = new GridBagConstraints();
        constructionCamembertContraints.gridx = 0;
        constructionCamembertContraints.gridy = 0;
        add(constructionCamembert, constructionCamembertContraints);

        // Ajoute la légende
        Legend legend = new Legend(donnee, couleurs);
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

    /**
     * Génère un tableau de couleurs aléatoires en fonction du nombre spécifié.
     *
     * @param count Le nombre de couleurs à générer.
     * @return Un tableau de couleurs aléatoires.
     */
    private Color[] generateRandomColors(int count) {
        Color[] colors = new Color[count];
        colors[0] = Color.GREEN;
        for (int i = 1; i < count; i++) {
            colors[i] = generateRandomColor();
        }
        return colors;
    }

    /**
     * Génère une couleur aléatoire.
     *
     * @return Une couleur aléatoire.
     */
    private Color generateRandomColor() {
        return new Color((int) (Math.random() * 256), (int) (Math.random() * 50), (int) (Math.random() * 256));
    }
}
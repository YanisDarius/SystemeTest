import java.awt.Color;
import java.awt.GridLayout;
import java.util.Map;

import javax.swing.JPanel;

/**
 * La classe Legend représente un panneau affichant une légende pour les différentes parties d'un graphique.
 * Chaque entrée de la légende est composée d'un libellé, d'une valeur et d'une couleur associée.
 */
public class Legend extends JPanel {

    /** Les données à afficher dans la légende */
    private Map<String, Integer> donnee;

    /** Les couleurs associées à chaque entrée de la légende */
    private Color[] couleurs;

    /**
     * Construit un objet Legend avec les données et les couleurs spécifiées.
     *
     * @param donnee Les données à afficher dans la légende.
     * @param couleurs Les couleurs associées à chaque entrée de la légende.
     */
    public Legend(Map<String, Integer> donnee, Color[] couleurs) {
        this.donnee = donnee;
        this.couleurs = couleurs; 
        setLayout(new GridLayout(donnee.size(), 1));

        int i = 0;
        for (Map.Entry<String, Integer> entree : donnee.entrySet()) {
            String label = entree.getKey();
            int value = entree.getValue();

            LegendLabel legendLabel = new LegendLabel(label, value, couleurs[i]);
            add(legendLabel);
            i++;
        }
    }
}
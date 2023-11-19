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
    private Map<String, Object[]> donnee;

    /**
     * Construit un objet Legend avec les données et les couleurs spécifiées.
     *
     * @param donnee Les données à afficher dans la légende.
     * @param couleurs Les couleurs associées à chaque entrée de la légende.
     */
    public Legend(Map<String, Object[]> donnee) {
        
        this.donnee = donnee;
        setLayout(new GridLayout(donnee.size(), 1));

        for (Map.Entry<String, Object[]> entree : donnee.entrySet()) {
            String label = entree.getKey();
            int value = (int) entree.getValue()[0];

            LegendLabel legendLabel = new LegendLabel(label, value, (Color) entree.getValue()[1]);
            add(legendLabel);
        }
    }
}
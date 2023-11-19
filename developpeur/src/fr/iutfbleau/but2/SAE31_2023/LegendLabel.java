import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * La classe LegendLabel représente une étiquette utilisée dans une légende.
 * Elle affiche un libellé, une valeur et une couleur associée.
 */
public class LegendLabel extends JLabel {

    /**
     * Construit un objet LegendLabel avec le libellé, la valeur et la couleur spécifiés.
     *
     * @param label Le libellé à afficher.
     * @param value La valeur à afficher.
     * @param color La couleur associée à l'étiquette.
     */
    public LegendLabel(String label, int value, Color color) {
        
        setText(label + ": " + value);
        setHorizontalAlignment(SwingConstants.CENTER);
        setForeground(color); // Définissez la couleur du texte
    }
}
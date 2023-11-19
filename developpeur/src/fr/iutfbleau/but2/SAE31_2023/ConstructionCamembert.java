import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import java.util.Map;

import javax.swing.JPanel;

/**
 * La classe ConstructionCamembert représente un panneau permettant de dessiner un diagramme camembert (ou pie chart)
 * en utilisant les données fournies et les couleurs spécifiées.
 */
public class ConstructionCamembert extends JPanel {

    /** Les données pour créer le diagramme camembert */
    private Map<String, Object[]> donnee;

    /**
     * Construit un objet ConstructionCamembert avec les données et les couleurs spécifiées.
     *
     * @param donnee Les données pour créer le diagramme camembert.
     */
    public ConstructionCamembert(Map<String, Object[]> donnee) {
        
        this.donnee = donnee;
        setPreferredSize(new Dimension(400, 400));
    }

    /**
     * Dessine le diagramme camembert en utilisant les données fournies et les couleurs spécifiées.
     *
     * @param g L'objet Graphics utilisé pour dessiner.
     */
    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        System.out.println("Painting CamembertPanel");
        drawCamembert(g);
    }

    /**
     * Dessine un diagramme camembert basé sur les données spécifiées.
     *
     * @param g L'objet Graphics utilisé pour dessiner.
     */
    private void drawCamembert(Graphics g) {

        int width = getWidth();
        int height = getHeight();
        System.out.println("Width: " + width + ", Height: " + height);
        int diameter = Math.min(width, height) - 50;
        int x = (width - diameter) / 2;
        int y = (height - diameter) / 2;

        int total = this.total();
        int startAngle = 0;

        for (Object[] entry : this.donnee.values()) {

            int value = (Integer) entry[0];
            int arcAngle = (int) Math.round((double) value / total * 360);

            g.setColor((Color) entry[1]); // Utilisation de la couleur spécifiée
            g.fillArc(x, y, diameter, diameter, startAngle, arcAngle);

            startAngle += arcAngle;
        }
    }

    /**
     * Calcule et retourne la somme des valeurs dans les données du camembert.
     *
     * @return La somme totale des valeurs dans les données du camembert.
     */
    private int total() {

        int total = 0;
        for (Object[] tab: this.donnee.values())
        {
            if (tab[0] instanceof Integer) {
                total += (Integer) tab[0];
            }
        }
        return total;
    }
}

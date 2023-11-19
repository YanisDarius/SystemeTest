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
    private Map<String, Integer> donnee;

    /** Les couleurs des segments du camembert */
    private Color[] couleurs; // Ajout d'un tableau de couleurs

    /**
     * Construit un objet ConstructionCamembert avec les données et les couleurs spécifiées.
     *
     * @param donnees Les données pour créer le diagramme camembert.
     * @param couleurs Les couleurs des segments du camembert.
     */
    public ConstructionCamembert(Map<String, Integer> donnee, Color[] couleurs) {
        this.donnee = donnee;
        this.couleurs = couleurs;
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

    private void drawCamembert(Graphics g) {
        int width = getWidth();
        int height = getHeight();
        System.out.println("Width: " + width + ", Height: " + height);
        int diameter = Math.min(width, height) - 50;
        int x = (width - diameter) / 2;
        int y = (height - diameter) / 2;

        int total = donnee.values().stream().mapToInt(Integer::intValue).sum();
        int startAngle = 0;

        int colorIndex = 0; // Indice pour parcourir le tableau de couleurs

        for (Map.Entry<String, Integer> entry : donnee.entrySet()) {
            
            int value = entry.getValue();
            int arcAngle = (int) Math.round((double) value / total * 360);

            g.setColor(couleurs[colorIndex]); // Utilisation de la couleur spécifiée
            g.fillArc(x, y, diameter, diameter, startAngle, arcAngle);

            startAngle += arcAngle;
            colorIndex = (colorIndex + 1) % couleurs.length; // Passage à la couleur suivante
        }
    }
}

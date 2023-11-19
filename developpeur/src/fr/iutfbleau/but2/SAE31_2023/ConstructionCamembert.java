import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class ConstructionCamembert extends JPanel {

    private Map<String, Integer> donnee;
    private Color[] couleurs; // Ajout d'un tableau de couleurs

    public ConstructionCamembert(Map<String, Integer> donnee, Color[] couleurs) {
        this.donnee = donnee;
        this.couleurs = couleurs;
        setPreferredSize(new Dimension(400, 400));
    }

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

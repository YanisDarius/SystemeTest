import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class Legend extends JPanel {

    private Map<String, Integer> donnee;
    private Color[] couleurs; 

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

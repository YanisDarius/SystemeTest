
    import javax.swing.*;
import java.awt.*;

import java.util.Map;

public class Camembert extends JPanel {

    private GridBagConstraints camenbertConstraints;

    /**
     * @param donnee les donnee pour creer le camenbert
     */
    public Camembert(Map<String, Integer> donnee) {
        setLayout(new GridBagLayout());
        
        Color[] couleurs = generateRandomColors(donnee.size());

        ConstructionCamembert constructionCamembert = new ConstructionCamembert(donnee,couleurs);
        GridBagConstraints  constructionCamembertContraints = new GridBagConstraints();
        constructionCamembertContraints.gridx = 0;
        constructionCamembertContraints.gridy = 0;  
        add(constructionCamembert,constructionCamembertContraints); 

        Legend legend = new Legend(donnee,couleurs);
        GridBagConstraints legencConstraints = new GridBagConstraints();
        legencConstraints.gridx = 1;
        legencConstraints. gridy = 0;

         // Ajustez la position de la légende
        add(legend, camenbertConstraints);


        // creer les contrainte pour l affichage dans reussite
        camenbertConstraints = new GridBagConstraints();
        camenbertConstraints.gridx = 0;
        camenbertConstraints.gridy = 2;
        camenbertConstraints.gridwidth = 1;
        camenbertConstraints.insets = new Insets(10, 10, 20, 10); 

    }
    /**
     * @return les contraint de camenbert
     */
    public GridBagConstraints getConstraints(){
        return camenbertConstraints;
    }

    private Color[] generateRandomColors(int count) {
        Color[] colors = new Color[count];
        for (int i = 0; i < count; i++) {
            colors[i] = generateRandomColor();
        }
        return colors;
    }

    private Color generateRandomColor() {
        return new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));
    }
}
    

    




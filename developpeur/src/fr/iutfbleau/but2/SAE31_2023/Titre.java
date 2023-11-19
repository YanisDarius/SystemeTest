import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class Titre extends JLabel {

    private GridBagConstraints titreConstraints;

    public Titre(String titreText) {
        super(titreText); 
        setFont(new Font("Arial", Font.BOLD, 20)); 
        titreConstraints = new GridBagConstraints();
        titreConstraints.gridx = 0;
        titreConstraints.gridy = -1;
        titreConstraints.gridwidth = 1;
        titreConstraints.insets = new Insets(10, 10, 20, 10); 
    }

    public GridBagConstraints getContraint() {
        return titreConstraints;
    }
}

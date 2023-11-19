import javax.swing.*;
import java.awt.*;

public class LegendLabel extends JLabel {

    public LegendLabel(String label, int value, Color color) {
        setText(label + ": " + value);
        setHorizontalAlignment(SwingConstants.CENTER);
        setForeground(color); // Définissez la couleur du texte
    }
}

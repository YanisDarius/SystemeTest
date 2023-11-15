import java.awt.Dimension;
import java.awt.Toolkit;

public class EcranOption {
    private int screenWidth;
    private int screenHeight;
    private int reduireEcran = 10;

    public int getWidth() {
        return screenWidth;
    }

    public int getHeight() {
        return screenHeight;
    }

    public EcranOption() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        screenWidth = (int) screenSize.getWidth() ;
        screenHeight = (int) screenSize.getHeight() - reduireEcran;

    }
}

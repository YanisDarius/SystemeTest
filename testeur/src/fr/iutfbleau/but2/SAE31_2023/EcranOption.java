import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

/**
 * La classe EcranOption permet de définir les options d'affichage de l'écran, telles que la largeur,
 * la hauteur et la possibilité de passer en mode plein écran.
 */
public class EcranOption {

    /** La largeur de l'écran */
    private int screenWidth;

    /** La hauteur de l'écran */
    private int screenHeight;

    /**
     * Obtient la largeur de l'écran.
     *
     * @return La largeur de l'écran.
     */
    public int getWidth() {
        return screenWidth;
    }

    /**
     * Obtient la hauteur de l'écran après réduction.
     *
     * @return La hauteur de l'écran après réduction.
     */
    public int getHeight() {
        return screenHeight;
    }

    /**
     * Constructeur de la classe EcranOption.
     * Initialise la largeur et la hauteur de l'écran en utilisant les dimensions de l'écran par défaut.
     */
    public EcranOption() {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        screenWidth = (int) screenSize.getWidth() / 2;
        screenHeight = (int) screenSize.getHeight() / 2;
    }

    /**
     * Définit le mode plein écran pour le cadre spécifié.
     *
     * @param frame Le cadre pour lequel le mode plein écran doit être activé.
     */
    public void setFullScreen(JFrame frame) {
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
}
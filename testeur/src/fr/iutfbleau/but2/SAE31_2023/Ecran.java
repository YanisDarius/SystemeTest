import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * La classe Ecran gère la création d'une interface graphique Swing avec la
 * possibilité de basculer entre différents écrans (panneaux) à l'aide d'un
 * CardLayout.
 */
public class Ecran {

    /** Le cadre (JFrame) de l'interface graphique */
    private JFrame frame = new JFrame("test");

    /** Le panneau (JPanel) utilisant le CardLayout pour gérer les écrans */
    private JPanel cardPanel;

    /** Le gestionnaire de mise en page pour le cardPanel */
    private CardLayout cardLayout;

    private BD bdd;

    /**
     * Constructeur de la classe Ecran.
     *
     * @param bdd Une instance de la classe BD pour la gestion de la base de
     *            données.
     */
    public Ecran(BD bdd) {
        
        cardPanel = new JPanel();
        cardLayout = new CardLayout();
        cardPanel.setLayout(cardLayout);
        this.bdd = bdd;

        // Définition de l'écran grâce à l'option écran
        EcranOption ecran = new EcranOption();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                bdd.fermerRessource();
            }
        });
        frame.setSize(ecran.getWidth(), ecran.getHeight());
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setBackground(new Color(220, 220, 220));
    }

    /**
     * Obtient le cadre (JFrame) de l'interface graphique.
     *
     * @return Le cadre de l'interface graphique.
     */
    public JFrame Frame() {
        return frame;
    }

    /**
     * Obtient le gestionnaire de mise en page (CardLayout) du panneau cardPanel.
     *
     * @return Le gestionnaire de mise en page CardLayout.
     */
    public CardLayout getCardLayout() {
        return cardLayout;
    }

    /**
     * Obtient le panneau (JPanel) utilisé pour afficher les écrans.
     *
     * @return Le panneau utilisé pour afficher les écrans.
     */
    public JPanel getCardJPanel() {
        return cardPanel;
    }

    /**
     * Ajoute un écran (panneau) au cardPanel avec un nom spécifié.
     *
     * @param ajoutDesComponent Le composant à ajouter (écran/panneau).
     * @param nomComponent      Le nom associé à l'écran.
     */
    public void ajouterEcran(Component ajoutDesComponent, String nomComponent) {
        cardPanel.add(ajoutDesComponent, nomComponent);
    }

    /**
     * Affiche le cadre et rend le cardPanel visible.
     */
    public void revelationEcran() {

        this.Frame().add(cardPanel);
        this.Frame().setVisible(true);
    }

    /**
     * Change l'écran affiché sur le cardPanel en utilisant le nom spécifié.
     *
     * @param nomEcran Le nom de l'écran à afficher.
     */
    public void ecranSuivant(String nomEcran) {

        this.getCardLayout().show(this.getCardJPanel(), nomEcran);

        if ("TERMINER".equals(nomEcran)) {
            bdd.fermerRessource();
            this.Frame().dispose();
        }
    }

    /**
     * Rafraîchit le cadre en validant et redessinant tous ses composants.
     */
    public void rafraichirEcran() {

        frame.revalidate();
        frame.repaint();
    }

    public String obtenirEcranActuel() {

        Component[] composants = cardPanel.getComponents();
        for (Component composant : composants) {
            if (composant.isVisible() && cardPanel.getComponentZOrder(composant) != -1) {
                return cardLayout.toString();
            } else {
                return null;
            }
        }
        return null;
    }
}
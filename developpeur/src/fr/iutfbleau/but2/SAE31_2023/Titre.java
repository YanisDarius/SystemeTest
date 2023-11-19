import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JLabel;

/**
 * La classe Titre représente un composant JLabel utilisé comme titre.
 * Elle définit le texte du titre avec une police de caractères spécifiée.
 * La classe utilise également GridBagConstraints pour définir les contraintes de disposition du titre.
 */
public class Titre extends JLabel {

    /** Les contraintes de disposition du titre */
    private GridBagConstraints titreConstraints;

    /**
     * Constructeur de la classe Titre.
     * Initialise le composant JLabel en définissant le texte du titre avec une police de caractères en gras.
     * Initialise également les contraintes de disposition avec des valeurs par défaut.
     *
     * @param titreText Le texte du titre.
     */
    public Titre(String titreText) {
        
        super(titreText);
        setFont(new Font("Arial", Font.BOLD, 20));
        titreConstraints = new GridBagConstraints();
        titreConstraints.gridx = 0;
        titreConstraints.gridy = -1;
        titreConstraints.gridwidth = 1;
        titreConstraints.insets = new Insets(10, 10, 20, 10);
    }

    /**
     * Obtient les contraintes de disposition du titre.
     *
     * @return Les contraintes de disposition du titre.
     */
    public GridBagConstraints getContraint() {
        return titreConstraints;
    }
}
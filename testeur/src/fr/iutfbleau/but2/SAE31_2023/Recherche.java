import java.util.ArrayList;

import javax.swing.JTextField;

/**
 * La classe Recherche étend JTextField et offre des fonctionnalités de filtrage de liste.
 * Elle permet de filtrer une liste d'éléments en fonction d'un texte de recherche.
 */
public class Recherche extends JTextField {

    /**
     * Filtrer une liste d'éléments en fonction d'un texte de recherche, en ignorant la casse.
     *
     * @param listeOriginale La liste d'éléments à filtrer.
     * @param texteRecherche Le texte à utiliser pour filtrer la liste.
     * @return Une liste filtrée contenant les éléments qui contiennent le texte de recherche (ignorant la casse).
     */
    public static ArrayList<String> filtrerListe(String[] listeOriginale, String texteRecherche) {
        ArrayList<String> listeFiltree = new ArrayList<>();

        for (String element : listeOriginale) {
            if (element.toLowerCase().contains(texteRecherche.toLowerCase())) {
                listeFiltree.add(element);
            }
        }

        return listeFiltree;
    }
}


import java.util.ArrayList;

import javax.swing.JTextField;


public class Recherche extends JTextField {

    

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


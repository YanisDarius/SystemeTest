import java.util.ArrayList;

public class Resultat {
    private ArrayList<Object[]> historique;
    private Object[] dernierChoisi;

    public Resultat() {
        historique = new ArrayList<>();
        dernierChoisi = null;
    }

    // Méthode pour enregistrer une nouvelle sélection dans l'historique
    public void ajouterSelection(Object[] chemin) {
        for(Object element : chemin) {
        System.out.println(element);
        }
        System.out.println("\n");
        historique.add(chemin.clone());  // Cloner le tableau pour éviter les modifications ultérieures
        dernierChoisi = chemin;
    }

    public ArrayList<Object[]> getHistorique() {
        return historique;
    }

    public Object[] getDernierChoisi() {
        return dernierChoisi;
    }
}

import java.util.ArrayList;

public class Resultat {
    private ArrayList<Integer> historique;
    private int dernierChoisi;
    private int dernierID;

    public Resultat() {
        historique = new ArrayList<>();
        dernierChoisi = 0;
        
    }

    // Méthode pour enregistrer une nouvelle sélection dans l'historique
    public void ajouterSelection(int chemin) {
        
          System.out.println(chemin);
        

        System.out.println("\n");
        historique.add(chemin);  // Cloner le tableau pour éviter les modifications ultérieures
        dernierChoisi = chemin;
    }

    public ArrayList<Integer> getHistorique() {
        return historique;
    }

    public int getDernierChoisi() {
        return dernierChoisi;
    }
    public void setIDDernierChoisi(int id) {
     dernierID = id;
    }

    public int getIDDernierChoisi() {
     return dernierID;
    }

    
}

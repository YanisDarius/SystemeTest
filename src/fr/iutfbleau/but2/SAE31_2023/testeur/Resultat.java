import java.util.ArrayList;

public class Resultat {
    private ArrayList<Object> historique;
    private Object[] cheminActuel;

    public Resultat(){

    }

    public void setCheminActuel(Object[]  chemin){
        cheminActuel = chemin;
        historique.add(cheminActuel);
    }

    public ArrayList<Object> getHistorique() {
        return historique;
    }


}


import java.util.ArrayList;
import java.util.List;

public class Noeud {
    int ID;
    String name;
    int rang;
    ArrayList<Noeud> enfants;

    public Noeud(String nom,int rang) {
        this.ID = 0;
        this.name = nom;
        this.rang = rang;
        this.enfants= new ArrayList<Noeud>();
    }

    public Noeud(int ID,String nom,int rang) {
        this.ID = ID;
        this.name = nom;
        this.rang = rang;
        this.enfants= new ArrayList<>();
    }

    public void setAll(int ID,String nom,int rang) {
        this.ID = ID;
        this.name = nom;
        this.rang = rang;
    }


    public void ajouterEnfant(Noeud enfant) {
        this.enfants.add(enfant);
    }

    public int getRang() {
        return rang;
    }

    public ArrayList<Noeud> getEnfant() {
        return enfants;
    }

    public int getID() {
        return ID;
    }

    @Override
    public String toString() {
        return name;
    }

}

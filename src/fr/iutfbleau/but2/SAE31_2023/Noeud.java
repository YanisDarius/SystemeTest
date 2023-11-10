
import java.util.ArrayList;
import java.util.List;

public class Noeud {
    int ID;
    String name;
    int rang;
    List<Noeud> enfants;

    public Noeud(String nom,int rang) {
        this.ID = 0;
        this.name = nom;
        this.rang = rang;
        this.enfants= new ArrayList<>();
    }

    public Noeud(int ID,String nom,int rang) {
        this.ID = ID;
        this.name = nom;
        this.rang = rang;
        this.enfants= new ArrayList<>();
    }


    public void ajouterEnfant(Noeud enfant) {
        this.enfants.add(enfant);
    }

    public int getRang() {
        return rang;
    }

    public int getID() {
        return ID;
    }

    @Override
    public String toString() {
        return name;
    }

}

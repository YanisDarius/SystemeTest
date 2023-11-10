import java.util.ArrayList;
import java.util.List;

public class Noeud {
    String name;
    int rang;
    List<Noeud> enfants;

    public Noeud(String nom,int rang) {
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

    @Override
    public String toString() {
        return name;
    }
}

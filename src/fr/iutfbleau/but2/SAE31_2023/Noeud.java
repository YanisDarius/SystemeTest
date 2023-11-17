
import java.util.ArrayList;


public class Noeud {
    int ID;
    String name;
    int rang;
    ArrayList<Noeud> enfants;

  

    public Noeud(int ID,String nom,int rang) {
        this.ID = ID;
        this.name = nom;
        this.rang = rang;
        this.enfants= new ArrayList<>();
    }

  

    public void ajouterEnfant(Noeud enfant) {
        this.enfants.add(enfant);
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

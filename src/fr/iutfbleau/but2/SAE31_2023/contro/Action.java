public class Action extends Menu {
    
    int id;
    String nom;
    int rank; 
    
    public Action(int identifiantAction, String nomAction, int rankAction)
    {
        this.id = identifiantAction;
        this.nom = nomAction;
        this.rank = rankAction; 
    }

    public int getId()
    {
        return id;
    }

    public String getNom()
    {
        return nom;
    }


    public int getRank()
    {
        return rank;
    }   
}

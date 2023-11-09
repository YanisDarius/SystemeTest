import java.util.ArrayList;

public class SousMenu extends Menu
{
    int id;
    String nom;
    int rank; 
    ArrayList<Action> contenu;   
     

    public ArrayList<Action> getActions()
    {
        return contenu;
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

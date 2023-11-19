import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Donnee {
    private int idprotocole;
    private String titreprotocole;
    private String descriptionprotocole;
    private int reponse;
    private ArrayList<Integer> reponsetest;

    public Donnee(BD bdd,int id) {
        ArrayList<Object> bdddonnee = new ArrayList<>();
        bdddonnee = bdd.getProtocole(id);

        this.idprotocole = id;
        this.titreprotocole = (String) bdddonnee.get(0); 
        this.descriptionprotocole = (String) bdddonnee.get(1);
        this.reponse = (int) bdddonnee.get(2);
        this.reponsetest=bdd.getTest(id);
    }

    private Map<String,Integer> reussite(ArrayList<Integer> reponsetest) {
        Map<String, Integer> data = new HashMap<>();
        int reussie = 0;
        int echoue = 0;
        for (Integer element : reponsetest ) {
            if( element == reponse ) {
                data.put("réussie",reussie++);
            }else{
                data.put("échoue", echoue++);
            }
        }
        return data;
    }

    public Map<String,Integer> getReussite(){
        return reussite(reponsetest);
    }

    public String getDescriptionprotocole() {
        return descriptionprotocole;
    }
    public int getIdprotocole() {
        return idprotocole;
    }
    public int getReponse() {
        return reponse;
    }
    public ArrayList<Integer> getReponsetest() {
        return reponsetest;
    }
    public String getTitreprotocole() {
        return titreprotocole;
    }
}

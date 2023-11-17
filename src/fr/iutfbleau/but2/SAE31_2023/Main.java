
public class Main {

    public static void main(String[] args) {
       
        BD bdd = new BD();
        Ecran ecran = new Ecran(bdd);
        Protocole protocole = new Protocole(ecran, bdd);
        
        
        Fin fin = new Fin(ecran,bdd);
        ecran.ajouterEcran(protocole, "protocole");
       
        ecran.ajouterEcran(fin, "fin");
        ecran.revelationEcran();
       

    }
}

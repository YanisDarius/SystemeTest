import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Object> protocole1 = new ArrayList<>();
        protocole1.add(1); // ID
        protocole1.add("Protocole A"); // Nom
        protocole1.add("Description du Protocole A"); // Description

        ArrayList<Object> protocole2 = new ArrayList<>();
        protocole2.add(2); // ID
        protocole2.add("Protocole B"); // Nom
        protocole2.add("Description du Protocole B"); // Description

        ArrayList<Object> protocole3 = new ArrayList<>();
        protocole3.add(3); // ID
        protocole3.add("Protocole C"); // Nom
        protocole3.add("Description du Protocole C"); // Description

        ArrayList<Object> listeProtocoles = new ArrayList<>();
        listeProtocoles.add(protocole1);
        listeProtocoles.add(protocole2);
        listeProtocoles.add(protocole3);

        Contr bdd = new Contr();
        Ecran ecran = new Ecran();
        Protocole protocole = new Protocole(ecran,bdd.getProtocole());
        Menu menu = new Menu(ecran,bdd.getFils(1));
        Fin fin = new Fin(ecran);
        ecran.ajouterEcran(protocole, "protocole");
        ecran.ajouterEcran(menu, "menu");
        ecran.ajouterEcran(fin, "fin");
        ecran.revelationEcran();
        bdd.fermerRessource();

    }
}

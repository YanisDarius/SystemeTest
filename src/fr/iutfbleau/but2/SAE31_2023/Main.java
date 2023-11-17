
public class Main {

    public static void main(String[] args) {

        BD bdd = new BD();
        Ecran ecran = new Ecran();
        Protocole protocole = new Protocole(ecran, bdd.getProtocole());
        Menu menu = new Menu(ecran, bdd.getFils(protocole.getIDProtocolChoisi()));
        Fin fin = new Fin(ecran);
        ecran.ajouterEcran(protocole, "protocole");
        ecran.ajouterEcran(menu, "menu");
        ecran.ajouterEcran(fin, "fin");
        ecran.revelationEcran();
        bdd.fermerRessource();

    }
}

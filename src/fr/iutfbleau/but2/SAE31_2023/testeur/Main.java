public class Main {
    public static void main(String[] args) {
        Contr bdd = new Contr();
        Ecran ecran = new Ecran();
        Protocole protocole = new Protocole(ecran,bdd.getProtocole());
        Menu menu = new Menu();
        ecran.ajouterEcran(protocole, "protocole");
        ecran.ajouterEcran(menu.getTree(), "menu");
        ecran.revelationEcran();

    }
}

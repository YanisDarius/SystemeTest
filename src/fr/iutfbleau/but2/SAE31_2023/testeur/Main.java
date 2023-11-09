public class Main {
    public static void main(String[] args) {

        Ecran ecran = new Ecran();
        Protocole protocole = new Protocole(ecran);
        Menu menu = new Menu();
        ecran.ajouterEcran(protocole, "protocole");
        ecran.ajouterEcran(menu.getTree(), "menu");
        ecran.revelationEcran();

    }
}

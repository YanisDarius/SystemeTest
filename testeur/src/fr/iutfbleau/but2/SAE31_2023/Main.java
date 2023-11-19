/**
 * La classe Main est la classe principale du programme. Elle contient le point d'entrée
 * main() qui initialise les composants nécessaires, tels que la base de données (BD),
 * l'écran principal (Ecran), le protocole et l'écran de fin, puis affiche l'écran principal.
 */
public class Main {

    /**
     * Le point d'entrée principal du programme.
     *
     * @param args Les arguments de la ligne de commande (non utilisés dans cet exemple).
     */
    public static void main(String[] args) {

        // Initialise la base de données (BD) et l'écran principal (Ecran)
        BD bdd = new BD();
        Ecran ecran = new Ecran(bdd);

        // Initialise le protocole et l'écran de fin
        Protocole protocole = new Protocole(ecran, bdd);
        Fin fin = new Fin(ecran);

        // Ajoute le protocole et l'écran de fin à l'écran principal
        ecran.ajouterEcran(protocole, "protocole");
        ecran.ajouterEcran(fin, "fin");

        // Affiche l'écran principal
        ecran.revelationEcran();
    }
}

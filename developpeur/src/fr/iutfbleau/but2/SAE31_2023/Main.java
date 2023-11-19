/**
 * La classe Main est la classe principale du programme.
 * Elle contient la méthode main qui est le point d'entrée du programme.
 */
public class Main {

    /**
     * Méthode principale du programme.
     * Si un argument entier est fourni en ligne de commande, elle crée une instance de la base de données (BD),
     * récupère les données associées à l'identifiant du protocole, crée une instance de l'écran (Ecran),
     * crée une instance de réussite (Reussite), ajoute la réussite à l'écran, et révèle l'écran.
     * En cas d'erreur, elle affiche un message approprié.
     *
     * @param args Les arguments de la ligne de commande. L'identifiant du protocole doit être fourni en tant qu'argument.
     */
    public static void main(String[] args) {
        
        if (args.length > 0) {
            
            try {
                
                int valeur = Integer.parseInt(args[0]);
                System.out.println("Entier récupéré : " + valeur);
                
                // Création de la base de données
                BD bdd = new BD();

                // Récupération des données du protocole
                Donnee donnee = new Donnee(bdd, valeur);

                // Création de l'écran
                Ecran ecran = new Ecran(bdd);

                // Création de l'instance de réussite
                Reussite reussite = new Reussite(ecran, donnee);
                Historique historique = new Historique(ecran, donnee);

                // Ajout de la réussite à l'écran
                ecran.ajouterEcran(reussite, "réussite");
                ecran.ajouterEcran(historique, "historique");

                // Révélation de l'écran
                ecran.revelationEcran();
                
            } catch (NumberFormatException e) {
                System.err.println("Erreur : L'argument n'est pas un entier valide.");
            }
        } else {
            System.err.println("Erreur : Aucun argument fourni.");
        }
    }
}
public class Main {
    public static void main(String[] args) {
        if (args.length > 0) {
            
            try {
                
                int valeur = Integer.parseInt(args[0]);
                System.out.println("Entier récupéré : " + valeur);
                
                
                BD bdd = new BD();
                Donnee donnee = new Donnee(bdd,valeur);
                Ecran ecran = new Ecran(bdd);
                Reussite reussite = new Reussite(ecran, donnee);
                ecran.ajouterEcran(reussite, "reussite");
                ecran.revelationEcran();
                
            } catch (NumberFormatException e) {
                System.err.println("Erreur : L'argument n'est pas un entier valide.");
            }
        } else {
            System.err.println("Erreur : Aucun argument fourni.");
        }
    }
}


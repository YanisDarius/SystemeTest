import java.util.ArrayList;

/**
 * La classe RessourcesProtocol représente une collection de ressources associées à des protocoles.
 * Elle stocke des informations telles que les noms, les descriptions et les identifiants des protocoles.
 */
public class RessourcesProtocol {

    /** Les noms des protocoles */
    private String[] protocolNom;

    /** Les descriptions des protocoles */
    private String[] protocolDescription;

    /** Les identifiants des menu */
    private int[] menuID;

    /** La taille de la collection de ressources */
    private int taille;

    /** id de protocole  **/
    private int[] protocolID;

    /**
     * Constructeur de la classe RessourcesProtocol.
     *
     * @param donnees Une liste d'objets représentant les données des protocoles.
     */
    public RessourcesProtocol(ArrayList<Object> donnees) {
        taille = donnees.size();
        protocolNom = new String[taille];
        protocolDescription = new String[taille];
        menuID = new int[taille];
        protocolID = new int[taille];

        int i = 0;
        for (Object elements : donnees) {
            if (elements instanceof ArrayList) {
                ArrayList<Object> element = (ArrayList<Object>) elements;
                if (element.get(1) instanceof String && element.get(2) instanceof String && element.get(0) instanceof Integer) {
                    protocolNom[i] = (String) element.get(1);
                    protocolDescription[i] = (String) element.get(2);
                    menuID[i] = (int) element.get(0);
                    protocolID[i] = (int) element.get(3);
                } else {
                    // Gérer le cas où l'élément n'est pas une chaîne
                    protocolNom[i] = "Non défini";
                    protocolDescription[i] = "Non défini";
                }
            } else {
                protocolNom[i] = "Non défini";
                protocolDescription[i] = "Non défini";
            }
            i++;
        }
    }

    /**
     * Obtient les noms des protocoles.
     *
     * @return Un tableau contenant les noms des protocoles.
     */
    public String[] getProtocolNom() {
        return protocolNom;
    }

    /**
     * Obtient la description d'un protocole à partir de son nom.
     *
     * @param nomprotocol Le nom du protocole.
     * @return La description du protocole ou un message indiquant l'absence de description.
     */
    public String getProtocolDescription(String nomprotocol) {

        for (int i = 0; i < taille; i++) {
            if (protocolNom[i] == nomprotocol) {

                return protocolDescription[i];
            }
        }
        return "il n'y a pas de description";
    }
    
    /**
     * Obtient le nom d'un protocole à partir de son identifiant.
     *
     * @param id L'identifiant du protocole.
     * @return Le nom du protocole ou un message indiquant l'absence d'identifiant.
     */
    public String getProtoclIDNom(String id) {
        for (int i = 0; i < taille; i++) {
            if (protocolNom[i] == id) {

                return protocolNom[i];
            }
        }
        return "il n'y a pas d id ";
    }

    /**
     * Obtient l'identifiant d'un protocole à partir de son nom.
     *
     * @param nomprotocol Le nom du protocole.
     * @return L'identifiant du protocole ou 0 si l'identifiant n'est pas trouvé.
     */
    public int getMenuID(String nomprotocol) {
        int id = 0;
        for (int i = 0; i < taille; i++) {
            if (protocolNom[i] == nomprotocol) {
                id = menuID[i];
            }
        }
        return id;
    }

    public int getProtocolID(String nomprotocol) {
        int id = 0;
        for (int i = 0; i < taille; i++) {
            if (protocolNom[i] == nomprotocol) {
                id = protocolID[i];
            }
        }
        return id;
    }


    /**
     * Obtient la première description de la collection de protocoles.
     *
     * @return La première description ou un message indiquant l'absence de description.
     */
    public String getFirstDescription() {
        if (taille > 0) {
            return protocolDescription[0];
        } else {
            return "Aucune description disponible il y a surement une erreur dans la base de donnée";
        }
    }
    
}

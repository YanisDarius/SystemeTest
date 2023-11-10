import java.util.ArrayList;

public class RessourcesProtocol {

    private String[] protocolNom;
    private String[] protocolDescription;
    private int[] protocolID;
    private int taille;

    public RessourcesProtocol(ArrayList<Object> donnees) {
        taille = donnees.size();
        protocolNom = new String[taille];
        protocolDescription = new String[taille];
        protocolID = new int[taille];

        if (donnees == null) {
            protocolNom[0] = "pas de protocol";
            protocolDescription[0] = "pas de description  êtes vous bien connectez à la base de donnée";
            protocolID[0] = 0;
        } else {

            int i = 0;
            for (Object elements : donnees) {
                if (elements instanceof ArrayList) {
                    ArrayList<Object> element = (ArrayList<Object>) elements;
                    if (element.get(1) instanceof String && element.get(2) instanceof String
                            && element.get(0) instanceof Integer) {
                        protocolNom[i] = (String) element.get(1);
                        protocolDescription[i] = (String) element.get(2);
                        protocolID[i] = (int) element.get(0);
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
    }

    public String[] getProtocolNom() {
        return protocolNom;
    }

    public String getProtocolDescription(String nomprotocol) {

        for (int i = 0; i < taille; i++) {
            if (protocolNom[i] == nomprotocol) {

                return protocolDescription[i];
            }
        }
        return "il n'y a pas de description";
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

    public String getFirstDescription() {
        if (taille > 0) {
            return protocolDescription[0];
        } else {
            return "Aucune description disponible";
        }
    }
    
}

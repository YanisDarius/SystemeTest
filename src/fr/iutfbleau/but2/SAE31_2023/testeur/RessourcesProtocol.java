import java.util.ArrayList;

public class RessourcesProtocol {
    private Object[] protocol ;
    private String[] protocolNom;

    public RessourcesProtocol(ArrayList<Object> données) {
        protocol = new Object[données.size()];
        protocolNom = new String[données.size()];

        int i = 0;
        for (Object element : données) {
            protocol[i] = element ;
            if (element instanceof String) {
                protocolNom[i] = (String) element;
            } else {
                // Gérer le cas où l'élément n'est pas une chaîne
                protocolNom[i] = "Non défini";
            }
            i++;
        }
    }

    public Object[] getProtocol() {
        return protocol;
    }

    public String[] getProtocolNom() {
        return protocolNom ;
    
    }
}




import java.awt.GridBagLayout;

import javax.swing.JPanel;

public class Reussite extends JPanel{
    
    public Reussite(Ecran ecran,Donnee donnee) {
        setLayout(new GridBagLayout());
        StringBuilder titretext = new StringBuilder("Voici le graphique des reusssite du protocole  ");
        titretext.append(donnee.getTitreprotocole()).append("    | ID :").append(donnee.getIdprotocole());
        Titre titre = new Titre(titretext.toString());
        add(titre,titre.getContraint());


       

        // Créer le  camembert
        Camembert camembert = new Camembert(donnee.getReussite());

        
        add(camembert, camembert.getConstraints());

    }

}

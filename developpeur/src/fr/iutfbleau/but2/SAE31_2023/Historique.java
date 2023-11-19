import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;


public  class Historique extends JPanel {
    
    public Historique(Ecran ecran, Donnee donnee) {

        setLayout(new BorderLayout());

        JPanel jpanel = new  JPanel();
        jpanel.setLayout(new GridBagLayout());
        
        // Construction du titre avec le nom du protocole et son ID
        StringBuilder titretext = new StringBuilder("Voici le graphique des historique du protocole  ");
        titretext.append(donnee.getTitreprotocole()).append("    | ID :").append(donnee.getIdprotocole());
        Titre titre = new Titre(titretext.toString());
        jpanel.add(titre,titre.getContraint());


       

        // Créer le  camembert
        
        Camembert camembert = new Camembert(donnee.getHistorique());
        jpanel.add(camembert, camembert.getConstraints());

        //ajout du pied de page
        PiedDePage pieddepage = new PiedDePage(ecran);
        
        add(jpanel,BorderLayout.CENTER);
        add(pieddepage,BorderLayout.SOUTH);

        


    }
}

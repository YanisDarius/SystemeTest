import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        Ecran ecranProtocol = new Ecran();
        Protocole protocole = new Protocole();
        ecranProtocol.ajouterEcran(protocole,"protocole");
        
        
           
        
   
    Menu menu = new Menu();
    Ecran ecranMenu = new Ecran();
    ecranMenu.revelationEcran(menu.getTree());
    
       
    }
}

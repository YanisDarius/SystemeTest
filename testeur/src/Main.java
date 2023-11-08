import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        EcranOption ecran = new EcranOption();
        JFrame frame = new JFrame("Outil de Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(ecran.getWidth(), ecran.getHeight());

        Protocole protocole = new Protocole();
        frame.add(protocole); // Ajoute l'instance de Protocole à la JFrame
        
        frame.setVisible(true);
        
        
            if (protocole.isProtocolSelected()) {
                // Le protocole a été sélectionné, passez à l'étape suivante ici
                frame.remove(protocole);
                frame.revalidate();
                frame.repaint();
                String protocolChoisiString = protocole.getProtocolChoisi();
                System.out.println("Protocole sélectionné : " + protocolChoisiString);
                 
            }
        
   
    Menu menu = new Menu();
    frame.add(menu.getTree());
        // Pour fermer la fenêtre lorsque c'est nécessaire
        // Vous pouvez appeler frame.dispose() où vous le souhaitez.
        // Par exemple, lorsque le test est terminé.
        // frame.dispose();
    }
}

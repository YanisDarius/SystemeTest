import java.awt.Component;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.CardLayout;

public class Ecran {

    private JFrame frame = new JFrame("test");
    private JPanel cardPanel ;
    private CardLayout cardLayout ;

    public Ecran(){
        cardPanel = new JPanel();
        cardLayout = new CardLayout();
        cardPanel.setLayout(cardLayout);
        
        //definition de l ecran grace a option ecran
        EcranOption ecran = new EcranOption();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(ecran.getWidth(), ecran.getHeight());

    }

    public JFrame Frame() {
        return frame;
    }
    public CardLayout getCardLayout(){
        return cardLayout;
    }
    
    public JPanel getCardJPanel(){
        return cardPanel;
    } 

    public void ajouterEcran(Component ajoutDesComponent,String nomComponent) {
        cardPanel.add(ajoutDesComponent,nomComponent);
    }

    public void revelationEcran() {
        
        this.Frame().add(cardPanel);
        this.Frame().setVisible(true);
    }

    



}

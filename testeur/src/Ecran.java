import java.awt.Component;

import javax.swing.JFrame;

public class Ecran {

    private JFrame frame = new JFrame("test");

    public Ecran(){
        EcranOption ecran = new EcranOption();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(ecran.getWidth(), ecran.getHeight());

    }

    public JFrame Frame() {
        return frame;
    }
    public void ajouterEcran(Component component) {
        this.Frame().add(component);
        this.Frame().setVisible(true);
    }
}

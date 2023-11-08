import java.awt.CardLayout;


public class ManipulationEcran {
    public ManipulationEcran(Ecran ecran,String nomEcran){
        ecran.getCardLayout().show(ecran.getCardJPanel(),nomEcran);

    }
}

import java.awt.Frame;

public class ManipulationEcran {
    public ManipulationEcran(Ecran ecran, String nomEcran) {
        ecran.getCardLayout().show(ecran.getCardJPanel(), nomEcran);
    
    
        if (nomEcran == "TERMINER"){
               ecran.Frame().dispose();
        }
    }
    public ManipulationEcran(boolean bloqueur){
        while (bloqueur == false) {
            
        }
    }
}

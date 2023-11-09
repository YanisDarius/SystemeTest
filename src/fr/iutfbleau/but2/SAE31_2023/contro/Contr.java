import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class Contr {

    Connection cnx;

    public Contr() {
        
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            cnx = DriverManager.getConnection("jdbc:mariadb://dwarves.iut-fbleau.fr/sayebabu",
            "sayebabu", "kjrzB5S4kqKAwdT");
            } 
        catch (Exception e) {
          System.out.printf("erreur 2");  
        }
    }

    public ArrayList<Object> getProtocole(){

        ArrayList<Object> protocoleListe = new ArrayList<Object>();

            try {

                //protocole
                
                PreparedStatement pst = cnx.prepareStatement("SELECT * FROM `protocole`;");
                ResultSet rs = pst.executeQuery();

                while(rs.next()) {

                    ArrayList<Object> protocole = new ArrayList<Object>();

                    protocole.add(rs.getInt(1));        // id du protocole
                    protocole.add(rs.getString(3));     // titre du protocole
                    protocole.add(rs.getString(4));     // description du protocole

                    protocoleListe.add(protocole);
                }                

            } 
            catch (Exception e) {
                System.out.printf("erreur 1 :" + e);
                
            }
        
        
        return protocoleListe;

    }

    public void main(String[] args) {
        try 
        {
            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public ArrayList<Menu> getFils(int id)
    {
        ArrayList<Menu> fils = new ArrayList<Menu>();

        try {
            PreparedStatement pst = this.cnx.prepareStatement("SELECT * FROM `menu` WHERE idpere = ?;");
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) 
            {
                PreparedStatement pst2 = cnx.prepareStatement("SELECT COUNT(*) FROM `menu` WHERE idpere = ?;");
                pst2.setInt(1, rs.getInt(1));
                ResultSet rs2 = pst2.executeQuery();
                rs2.next();
                if (rs2.getInt(1) != 0 ) 
                {
                                    //TODO
                }
                else
                {
                    Action output; //TODO
                }

            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        
        return fils;
    }

}
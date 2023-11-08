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

                    protocole.add(rs.getInt(1));
                    protocole.add(rs.getString(3));
                    protocole.add(rs.getString(4));

                    protocoleListe.add(protocole);
                }                

            } 
            catch (Exception e) {
                System.out.printf("erreur 1 :" + e);
                
            }
        
        
        return protocoleListe;

    }
}
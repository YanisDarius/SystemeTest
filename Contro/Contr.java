import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class Contr {

    public static ArrayList<Object> getProtocole(){

        ArrayList<Object> protocoleListe = new ArrayList<Object>();

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            Connection cnx = DriverManager.getConnection("jdbc:mariadb://dwarves.iut-fbleau.fr/sayebabu",
            "sayebabu", "kjrzB5S4kqKAwdT");
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
                cnx.close();
                System.out.printf("erreur 1 :" + e);
                
            }
        } 
        catch (Exception e) {
          System.out.printf("erreur 2");  
        }
        
        return protocoleListe;

    }
}
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Contr {
    public static void main(String[] args) {
        Connection cnx;
        try {
            cnx = DriverManager.getConnection("jdbc:mariadb://dwarves.iut-fbleau.fr/sayebabu", "sayebabu", "kjrzB5S4kqKAwdT");
        } catch (SQLException ex) {
            System.err.println("Unable to access Database.");
            return ;
        }
    }
}
package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String urlBD = "jdbc:mysql://localhost:3306/POO2ICA2?useSSL=true";
    private static final String userBD = "";
    private static final String passBD = "";

    public static Connection getConnection() {
        Connection con;

        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            con = DriverManager.getConnection(urlBD, userBD, passBD);
            con.setAutoCommit(false);
            return con;
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }
}

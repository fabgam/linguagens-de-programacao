package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String URLBD = "jdbc:mysql://localhost:3306/POO2ICA2?useSSL=true";
    private static final String USERBD = "";
    private static final String PASSBD = "";

    public static Connection getConnection() {
        Connection con;

        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            con = DriverManager.getConnection(URLBD, USERBD, PASSBD);
            con.setAutoCommit(false);
            return con;
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }
}

package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String URLBD = "jdbc:mysql://localhost:3306/cad?useSSL=true";
    private static final String USERBD = ""; // Colocar entre as aspas o nome do usuário do banco de dados
    private static final String PASSBD = ""; // Colocar entre as aspas a senha do banco de dados

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

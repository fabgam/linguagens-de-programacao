package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String URLBD = "jdbc:mysql://localhost:3306/cad?useSSL=true";
    private static final String USERBD = ""; // Colocar entre as aspas o nome do usuário do banco de dados
    private static final String PASSBD = ""; // Colocar entre as aspas a senha do banco de dados

    public static Connection getConnection() {

        Connection con = null;

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection(URLBD, USERBD, PASSBD);
            con.setAutoCommit(false);
            return con;
        } catch (ClassNotFoundException classNotFoundException) {
            throw new RuntimeException(classNotFoundException);
        } catch (IllegalAccessException accessException) {
            throw new RuntimeException(accessException);
        } catch (InstantiationException instantiationException) {
            throw new RuntimeException(instantiationException);
        } catch (SQLException sQLException) {
            throw new RuntimeException(sQLException);
        }
    }
}

package br.com.java.terminal.cad.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    // Para utilizar o MySQL basta alterar a url para: "jdbc:mysql://localhost:3306/cad"
    private String URLBD = "jdbc:mariadb://localhost:3306/cad";
    // Colocar entre as aspas o nome do usuário do banco de dados
    private String USERBD = "";
    // Colocar entre as aspas a senha do banco de dados
    private String PASSBD = "";

    public Connection getConnection() throws SQLException {
        Connection con = null;

        try {
            // Para utilizar o MySQL basta alterar o Class.forName para "Class.forName("com.mysql.jdbc.Driver");"
            Class.forName("org.mariadb.jdbc.Driver");
            con = DriverManager.getConnection(URLBD, USERBD, PASSBD);
            con.setAutoCommit(false);
            return con;
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }
}

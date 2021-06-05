package com.web.cadastrodepessoas.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionFactory {

    private static final String URLBD = "jdbc:mysql://localhost:3306/cad?useSSL=true";
    private static final String USERBD = "root"; // Colocar entre as aspas o nome do usuário do banco de dados
    private static final String PASSBD = "mydatabaseis@4Work"; // Colocar entre as aspas a senha do banco de dados

    public static Connection getConnection() {

        Connection con = null;

        try {
            Object newInstance = Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URLBD, USERBD, PASSBD);
            con.setAutoCommit(false);
            return con;
        } catch (SQLException classNotFoundException) {
            throw new RuntimeException(classNotFoundException);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

package br.com.java.terminal.cad.factory;

import br.com.java.terminal.cad.util.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Database {

    private ConnectionFactory conFactory = new ConnectionFactory();
    private DBUtil util = new DBUtil();
    private Connection con = null;
    private PreparedStatement ps = null;

    public void create() {

        try {
            con = conFactory.getConnection();
            ps = con.prepareStatement("DROP DATABASE IF EXISTS cad;");
            ps.executeUpdate();
            con.commit();

            ps = con.prepareStatement("CREATE DATABASE IF NOT EXISTS cad;");
            ps.executeUpdate();
            con.commit();

            ps = con.prepareStatement("CREATE TABLE IF NOT EXISTS cad.pessoa (\n"
                    + "id_pessoa INT NOT NULL AUTO_INCREMENT,"
                    + "nome VARCHAR(60) NOT NULL,"
                    + "cpf VARCHAR(14) NOT NULL,"
                    + "rg VARCHAR(10) NOT NULL,"
                    + "PRIMARY KEY (id_pessoa))"
                    + "engine InnoDB;");
            ps.executeUpdate();
            con.commit();
        } catch (SQLException exception) {
            try {
                con.rollback();
            } catch (SQLException exception1) {
                throw new RuntimeException(exception1);
            }
            throw new RuntimeException(exception);
        } finally {
            util.closeConnections(con, ps);
        }
    }
}

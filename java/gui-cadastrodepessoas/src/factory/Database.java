package factory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import util.DBUtil;

public class Database {

    private static final Connection CON = ConnectionFactory.getConnection();
    private static PreparedStatement ps = null;

    public static void create() {

        try {
            ps = CON.prepareStatement("DROP DATABASE IF EXISTS POO2ICA2;");
            ps.executeUpdate();
            CON.commit();

            ps = CON.prepareStatement("CREATE DATABASE IF NOT EXISTS POO2ICA2;");
            ps.executeUpdate();
            CON.commit();

            ps = CON.prepareStatement("USE POO2ICA2;");
            ps.execute();

            ps = CON.prepareStatement(
                    "CREATE TABLE IF NOT EXISTS pessoa (\n"
                    + "id_pessoa INT NOT NULL AUTO_INCREMENT,"
                    + "nome VARCHAR(60) NOT NULL,"
                    + "cpf VARCHAR(14) NOT NULL,"
                    + "rg VARCHAR(10) NOT NULL,"
                    + "PRIMARY KEY (id_pessoa))"
                    + "engine InnoDB;");
            ps.executeUpdate();
            CON.commit();

            ps = CON.prepareStatement("USE POO2ICA2;");
            ps.execute();

            ps = CON.prepareStatement(
                    "CREATE TABLE IF NOT EXISTS contato(\n"
                    + "id_contato INT NOT NULL AUTO_INCREMENT,"
                    + "telresidencial VARCHAR(15) NOT NULL,"
                    + "telcelular VARCHAR(15) NOT NULL,"
                    + "email VARCHAR(40) NOT NULL,"
                    + "whatsapp VARCHAR(15) NOT NULL,"
                    + "pessoa_id INT NOT NULL,"
                    + "PRIMARY KEY (id_contato),"
                    + "FOREIGN KEY (pessoa_id) REFERENCES pessoa(id_pessoa))"
                    + "engine InnoDB;");
            ps.executeUpdate();
            CON.commit();

        } catch (SQLException exception) {
            try {
                CON.rollback();
            } catch (SQLException exception1) {

            }
            throw new RuntimeException(exception);
        } finally {
            DBUtil.closeConnections(ps, CON);
        }
    }
}

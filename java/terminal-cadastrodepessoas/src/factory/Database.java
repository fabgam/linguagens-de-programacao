package factory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import util.DBUtil;

public class Database {

    private static final Connection con = ConnectionFactory.getConnection();
    private static PreparedStatement ps = null;

    public static void create() {

        try {
            ps = con.prepareStatement("DROP DATABASE IF EXISTS POO2ICA2;");
            ps.executeUpdate();
            con.commit();

            ps = con.prepareStatement("CREATE DATABASE IF NOT EXISTS POO2ICA2;");
            ps.executeUpdate();
            con.commit();

            ps = con.prepareStatement("USE POO2ICA2;");
            ps.execute();

            ps = con.prepareStatement("CREATE TABLE IF NOT EXISTS pessoa (\n"
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

            }
            throw new RuntimeException(exception);
        } finally {
            DBUtil.closeConnections(ps, con);
        }
    }
}

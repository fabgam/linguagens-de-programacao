package factory;

import dao.PessoaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.Pessoa;
import util.DBUtil;

public class Database {

    private static final Connection CON = ConnectionFactory.getConnection();
    private static PreparedStatement ps = null;

    public static void create() {

        try {

            ps = CON.prepareStatement("DROP DATABASE IF EXISTS cad;");
            ps.executeUpdate();
            CON.commit();

            ps = CON.prepareStatement("CREATE DATABASE IF NOT EXISTS cad;");
            ps.executeUpdate();
            CON.commit();

            ps = CON.prepareStatement("CREATE TABLE IF NOT EXISTS cad.pessoa (\n"
                    + "id_pessoa INT NOT NULL AUTO_INCREMENT,"
                    + "nome VARCHAR(60) NOT NULL,"
                    + "cpf VARCHAR(14) NOT NULL,"
                    + "rg VARCHAR(10) NOT NULL,"
                    + "PRIMARY KEY (id_pessoa))"
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

    public static void populate() {

        PessoaDAO dao = new PessoaDAO();

        for (int i = 0; i < 100; i++) {
            Pessoa p = new Pessoa();
            p.setId_pessoa(dao.maiorIDInserida());
            p.setNome("Nome" + (i + 1));
            p.setCpf("CPF" + (i + 1));
            p.setRg("RG" + (i + 1));
            dao.insert(p);
        }
    }
}

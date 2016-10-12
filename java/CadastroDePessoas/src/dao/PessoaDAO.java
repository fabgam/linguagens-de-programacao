package dao;

import com.mysql.jdbc.Connection;
import factory.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Pessoa;
import util.DBUtil;

public class PessoaDAO implements IDAO {

    private static Connection con;
    private static PreparedStatement ps;
    private static ResultSet rs;

    public static void insert(Pessoa p) {

        con = (Connection) ConnectionFactory.getConnection();

        try {
            ps = con.prepareStatement("USE POO2ICA2;");
            ps.execute();

            ps = con.prepareStatement("INSERT INTO pessoa (id_pessoa, nome, cpf, rg) VALUES (?, ?, ?, ?);");
            ps.setInt(1, p.getId_pessoa());
            ps.setString(2, p.getNome());
            ps.setString(3, p.getCpf());
            ps.setString(4, p.getRg());
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

    public static int maiorIDInserida() {

        con = (Connection) ConnectionFactory.getConnection();
        int maiorID = 0;

        try {
            ps = con.prepareStatement("USE POO2ICA2;");
            ps.execute();
            ps = con.prepareStatement("SELECT MAX(id_pessoa) FROM pessoa;");
            rs = ps.executeQuery();

            while (rs.next()) {
                maiorID = rs.getInt(1);
            }
        } catch (SQLException exception) {
            try {
                con.rollback();
            } catch (SQLException exception1) {

            }
        } finally {
            DBUtil.closeConnections(ps, con);
            DBUtil.closeConnections(rs);
        }
        return maiorID + 1;
    }

    @Override
    public void persist(Pessoa p) {
    }

    @Override
    public void delete(int id_pessoa) {

        con = (Connection) ConnectionFactory.getConnection();

        try {
            ps = con.prepareStatement("USE POO2ICA2;");
            ps.execute();

            ps = con.prepareStatement("DELETE FROM pessoa WHERE id_pessoa = (?);");
            ps.setInt(1, id_pessoa);
            ps.executeUpdate();
            con.commit();

        } catch (SQLException exception) {
            try {
                con.rollback();
            } catch (SQLException exception1) {

            }
            throw new RuntimeException();
        } finally {
            DBUtil.closeConnections(ps, con);
        }
    }

    @Override
    public void update(Pessoa p) {

        con = (Connection) ConnectionFactory.getConnection();

        try {
            ps = con.prepareStatement("USE POO2ICA2;");
            ps.execute();

            ps = con.prepareStatement("UPDATE pessoa SET nome = ?, cpf = ?, rg = ? WHERE id_pessoa = ?;");
            ps.setString(1, p.getNome());
            ps.setString(2, p.getCpf());
            ps.setString(3, p.getRg());
            ps.setInt(4, p.getId_pessoa());
            ps.executeUpdate();
            con.commit();

        } catch (SQLException exception) {
            try {
                con.rollback();
            } catch (SQLException exception1) {

            }
            throw new RuntimeException();
        } finally {
            DBUtil.closeConnections(ps, con);
        }
    }

    @Override
    public Pessoa get(int id_pessoa) {

        con = (Connection) ConnectionFactory.getConnection();

        try {
            ps = con.prepareStatement("USE POO2ICA2;");
            ps.execute();

            ps = con.prepareStatement("SELECT * FROM pessoa WHERE id_pessoa = (?);");
            ps.setInt(1, id_pessoa);
            rs = ps.executeQuery();

            if (rs.next()) {
                return new Pessoa(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
            }

        } catch (SQLException exception) {
            try {
                con.rollback();
            } catch (SQLException exception1) {

            }
            throw new RuntimeException();
        } finally {
            DBUtil.closeConnections(ps, con);
            DBUtil.closeConnections(rs);
        }
        return null;
    }

    @Override
    public List getAll() {

        con = (Connection) ConnectionFactory.getConnection();
        List<Pessoa> pessoas = new ArrayList<>();

        try {
            ps = con.prepareStatement("SELECT * FROM pessoa;");
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id_pessoa");
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String rg = rs.getString("rg");

                Pessoa p = new Pessoa(id, nome, cpf, rg);
                pessoas.add(p);
            }
            return pessoas;
        } catch (SQLException exception) {
            try {
                con.rollback();
            } catch (SQLException exception1) {

            }
        } finally {
            DBUtil.closeConnections(ps, con);
            DBUtil.closeConnections(rs);
        }
        return null;
    }
}

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

    public void insert(Object p) {

        con = (Connection) ConnectionFactory.getConnection();
        Pessoa pessoa = (Pessoa) p;

        try {
       
            ps = con.prepareStatement("INSERT INTO cad.pessoa (id_pessoa, nome, cpf, rg) VALUES (?, ?, ?, ?);");
            ps.setInt(1, pessoa.getId_pessoa());
            ps.setString(2, pessoa.getNome());
            ps.setString(3, pessoa.getCpf());
            ps.setString(4, pessoa.getRg());
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

    public int maiorIDInserida() {

        con = (Connection) ConnectionFactory.getConnection();
        int maiorID = 0;

        try {
            ps = con.prepareStatement("SELECT MAX(id_pessoa) FROM cad.pessoa;");
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
    public boolean persist(Object id_pessoa) {

        con = (Connection) ConnectionFactory.getConnection();
        int count = 0;

        try {
            ps = con.prepareStatement("SELECT count(*) FROM cad.pessoa WHERE id_pessoa = ?;");
            ps.setInt(1, (int) id_pessoa);
            rs = ps.executeQuery();

            if (rs.next()) {
                count = rs.getInt(1);
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
        return count == 1;
    }

    @Override
    public void delete(Object id_pessoa) {

        con = (Connection) ConnectionFactory.getConnection();

        try {            

            ps = con.prepareStatement("DELETE FROM cad.pessoa WHERE id_pessoa = (?);");
            ps.setInt(1, (int) id_pessoa);
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
    public void update(Object p) {

        con = (Connection) ConnectionFactory.getConnection();
        Pessoa pessoa = (Pessoa) p;

        try {

            ps = con.prepareStatement("UPDATE cad.pessoa SET nome = ?, cpf = ?, rg = ? WHERE id_pessoa = ?;");
            ps.setString(1, pessoa.getNome());
            ps.setString(2, pessoa.getCpf());
            ps.setString(3, pessoa.getRg());
            ps.setInt(4, pessoa.getId_pessoa());
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
    public Pessoa get(Object id_pessoa) {

        con = (Connection) ConnectionFactory.getConnection();

        try {            

            ps = con.prepareStatement("SELECT * FROM cad.pessoa WHERE id_pessoa = (?);");
            ps.setInt(1, (int) id_pessoa);
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
            ps = con.prepareStatement("SELECT * FROM cad.pessoa;");
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

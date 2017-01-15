package br.com.java.terminal.cad.dao;

import br.com.java.terminal.cad.factory.ConnectionFactory;
import br.com.java.terminal.cad.model.Pessoa;
import br.com.java.terminal.cad.util.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PessoaDAO implements IDAO {

    private ConnectionFactory conFactory = new ConnectionFactory();
    private DBUtil util = new DBUtil();
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public boolean isIDExistente(int id) {
        try {
            con = conFactory.getConnection();
            ps = con.prepareStatement("SELECT id_pessoa FROM cad.pessoa WHERE id_pessoa = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        } finally {
            util.closeConnections(con);
        }
    }

    public int maiorIDInserida() {

        int maiorID = 0;

        try {
            con = conFactory.getConnection();
            ps = con.prepareStatement("SELECT MAX(id_pessoa) FROM cad.pessoa;");
            rs = ps.executeQuery();

            while (rs.next()) {
                maiorID = rs.getInt(1);
            }
        } catch (SQLException exception) {
            try {
                con.rollback();
            } catch (SQLException exception1) {
                throw new RuntimeException(exception1);
            }
            throw new RuntimeException(exception);
        } finally {
            util.closeConnections(con, ps, rs);
        }
        return maiorID;
    }

    @Override
    public boolean persist(Object p) {

        Pessoa pessoa = (Pessoa) p;

        try {
            con = conFactory.getConnection();
            ps = con.prepareStatement("INSERT INTO cad.pessoa (id_pessoa, nome, cpf, rg) VALUES (?, ?, ?, ?);");
            ps.setInt(1, pessoa.getId_pessoa());
            ps.setString(2, pessoa.getNome());
            ps.setString(3, pessoa.getCpf());
            ps.setString(4, pessoa.getRg());
            ps.executeUpdate();
            con.commit();
            return true;
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

    @Override
    public void delete(Object id_pessoa) {
        try {
            con = conFactory.getConnection();
            ps = con.prepareStatement("DELETE FROM cad.pessoa WHERE id_pessoa = (?);");
            ps.setInt(1, (int) id_pessoa);
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

    @Override
    public void update(Object p) {

        Pessoa pessoa = (Pessoa) p;

        try {
            con = conFactory.getConnection();
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
                throw new RuntimeException(exception1);
            }
            throw new RuntimeException(exception);
        } finally {
            util.closeConnections(con, ps);
        }
    }

    @Override
    public Pessoa get(Object id_pessoa) {
        try {
            con = conFactory.getConnection();
            ps = con.prepareStatement("SELECT * FROM cad.pessoa WHERE id_pessoa = (?);");
            ps.setInt(1, (int) id_pessoa);
            rs = ps.executeQuery();

            if (rs.next()) {
                Pessoa p = new Pessoa();
                p.setId_pessoa(rs.getInt("id_pessoa"));
                p.setNome(rs.getString("nome"));
                p.setCpf(rs.getString("cpf"));
                p.setRg(rs.getString("rg"));
                return p;
            }
        } catch (SQLException exception) {
            try {
                con.rollback();
            } catch (SQLException exception1) {
                throw new RuntimeException(exception1);
            }
            throw new RuntimeException(exception);
        } finally {
            util.closeConnections(con, ps, rs);
        }
        return null;
    }

    @Override
    public List<Pessoa> getAll() {

        List<Pessoa> pessoas = new ArrayList<>();

        try {
            con = conFactory.getConnection();
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
                throw new RuntimeException(exception1);
            }
            throw new RuntimeException(exception);
        } finally {
            util.closeConnections(con, ps, rs);
        }
    }
}

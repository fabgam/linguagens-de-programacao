package br.com.java.terminal.cad.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {

    public void closeConnections(PreparedStatement ps) {
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    public void closeConnections(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    public void closeConnections(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    public void closeConnections(Connection con, PreparedStatement ps) {
        try {
            if (con != null) {
                con.close();
            }
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    public void closeConnections(Connection con, PreparedStatement ps, ResultSet rs) {
        try {
            if (con != null) {
                con.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }
}

package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {

    public static void closeConnections(PreparedStatement ps, Connection con) {
        try {
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException exception) {

        }
    }

    public static void closeConnections(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException exception) {

        }
    }
}

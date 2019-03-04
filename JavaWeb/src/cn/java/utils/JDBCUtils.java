package cn.java.utils;

import java.sql.*;

public class JDBCUtils {
    private static final String USER = "root";
    private static final String PWD = "root";
    private static final String URL = "jdbc:mysql:///db2";
    private static final String DRIVER = "com.mysql.jdbc.Driver";

    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL,USER,PWD);
    }

    public static void close(Connection conn, Statement stmt){
        if (stmt!=null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(Connection conn, Statement stmt, ResultSet rs){
        if (rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        close(conn,stmt);

    }

}

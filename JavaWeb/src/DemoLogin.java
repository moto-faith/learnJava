import cn.java.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DemoLogin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("user:");
        String name = scanner.nextLine();
        System.out.println("password:");
        String password = scanner.nextLine();
        login(name,password);
    }

    private static void login(String name, String password) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "select * from user where name = '"+name+"' and" +
                    " password = '"+password+"'";
            System.out.println(sql);
            rs = stmt.executeQuery(sql);
            if (rs.next()){
                System.out.println("登录成功");
            }else {
                System.out.println("登录失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(conn,stmt,rs);
        }
    }
}

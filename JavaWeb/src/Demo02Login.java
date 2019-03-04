import cn.java.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Demo02Login {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("user:");
        String name = scanner.nextLine();
        System.out.println("password:");
        String password = scanner.nextLine();
        login(name,password);
    }

    private static void login(String name, String password) throws SQLException {
        Connection conn = JDBCUtils.getConnection();
        String sql = "select * from user where name = ? and password = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,name);
        ps.setString(2,password);
        ResultSet resultSet = ps.executeQuery();
        if (resultSet.next()){
            System.out.println("登录成功"+name);
        }else {
            System.out.println("登录失败");
        }
        JDBCUtils.close(conn,ps,resultSet);
    }
}

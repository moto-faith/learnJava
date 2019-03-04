import cn.java.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DemoTransaction {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps =null;
        try {
            conn = JDBCUtils.getConnection();
            //开启事务
            conn.setAutoCommit(false);
            ps = conn.prepareStatement("update account set balance=balance-? where name=?");
            ps.setInt(1,500);
            ps.setString(2,"aaa");
            ps.executeUpdate();
            //出现异常
//            int i = 3/0;
            ps = conn.prepareStatement("update account set balance=balance+? where name=?");
            ps.setInt(1,500);
            ps.setString(2,"bbb");
            ps.executeUpdate();
            //提交事务
            conn.commit();
            System.out.println("转账成功");

        } catch (Exception e) {
            e.printStackTrace();
            //在异常中回滚事务
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            System.out.println("转账失败");
        }finally {
            JDBCUtils.close(conn,ps);
        }

    }
}

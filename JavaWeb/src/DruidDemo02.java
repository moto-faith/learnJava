import cn.java.utils.JDBCDruidUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DruidDemo02 {
    public static void main(String[] args) {
        Connection conn =null;
        PreparedStatement ps = null;
        try {
            conn = JDBCDruidUtils.getConnection();
            ps = conn.prepareStatement("insert into account values(null,?,?)");
            ps.setString(1,"王五");
            ps.setDouble(2,3000);
            int i = ps.executeUpdate();
            System.out.println(i);

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCDruidUtils.close(conn,ps);
        }
    }
}

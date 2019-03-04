import cn.java.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Demo01DML {
    public static void main(String[] args) throws SQLException {
//        insert();
//        update();
        delete();
    }

    private static void insert() throws SQLException {
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement ps = conn.prepareStatement("insert into student values(null,?,?,?)");
        ps.setString(1,"aaa");
        ps.setBoolean(2,true);
        ps.setDate(3,Date.valueOf("2019-1-1"));
        int i = ps.executeUpdate();
        System.out.println(i+" have done");
        JDBCUtils.close(conn,ps);
    }

    private static void update() throws SQLException {
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement ps = conn.prepareStatement("update student set name=?,birthday=? " +
                "where id=?");
        ps.setString(1,"bbb");
        ps.setDate(2,Date.valueOf("2000-1-1"));
        ps.setInt(3,5);
        int i = ps.executeUpdate();
        System.out.println(i+" have done");
        JDBCUtils.close(conn,ps);
    }

    public static void delete() throws SQLException {
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement ps = conn.prepareStatement("delete from student where id = ?");
        ps.setInt(1,5);
        int i = ps.executeUpdate();
        System.out.println(i+" have done");
        JDBCUtils.close(conn,ps);

    }


}

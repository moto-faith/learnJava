import cn.java.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DemoStudent {
    public static void main(String[] args) throws SQLException {
        Student student = new Student();
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement ps = conn.prepareStatement("select * from student where id = ?");
        ps.setInt(1,2);
        ResultSet rs = ps.executeQuery();
        if (rs.next()){
            student.setId(rs.getInt("id"));
            student.setName(rs.getString("name"));
            student.setGender(rs.getBoolean("gender"));
            student.setBirthday(rs.getDate("birthday"));
        }
        JDBCUtils.close(conn,ps,rs);
        System.out.println(student);
    }
}

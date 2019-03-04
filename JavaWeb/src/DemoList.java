import cn.java.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DemoList {
    public static void main(String[] args) throws SQLException {
        ArrayList<Student> students = new ArrayList<>();
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement ps = conn.prepareStatement("select * from student");
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            Student student = new Student();
            student.setId(rs.getInt("id"));
            student.setName(rs.getString("name"));
            student.setGender(rs.getBoolean("gender"));
            student.setBirthday(rs.getDate("birthday"));
            students.add(student);
        }
        for (Student stu : students) {
            System.out.println(stu);
        }
    }
}

import java.sql.*;

public class Demo01 {
    public static void main(String[] args){
        Connection connection =null;
        Statement statement =null;
        try {
            //注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //创建连接
            connection = DriverManager.getConnection("jdbc:mysql:///db2", "root", "root");
            statement = connection.createStatement();
            String sql = "INSERT INTO emp VALUES(7,\"ggg\",\"女\",5555,\"2019-01-04\",2);";
            String sql2 = "select * from emp";
//            int i = statement.executeUpdate(sql);
//            System.out.println(i);
            ResultSet resultSet = statement.executeQuery(sql2);
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String gender = resultSet.getString("gender");
                double salary = resultSet.getDouble("salary");
                Date join_date = resultSet.getDate("join_date");
                int dept_id = resultSet.getInt("dept_id");
                System.out.println(id+name+gender+salary+join_date+dept_id);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (statement!=null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class C3P0Demo1 {
    public static void main(String[] args) throws SQLException {
        ComboPooledDataSource ds = new ComboPooledDataSource();
        for (int i = 1; i <= 11; i++) {
            Connection conn = ds.getConnection();
            System.out.println(i+" : "+conn);
            conn.close();
        }
    }
}

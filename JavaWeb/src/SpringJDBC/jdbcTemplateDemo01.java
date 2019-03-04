package SpringJDBC;

import cn.java.utils.JDBCDruidUtils;
import org.springframework.jdbc.core.JdbcTemplate;

public class jdbcTemplateDemo01 {
    public static void main(String[] args) {
        JdbcTemplate template = new JdbcTemplate(JDBCDruidUtils.getDataSource());
        String sql = "update account set balance = 5000 where id = ?";
        int count = template.update(sql, 1);
        System.out.println(count);
    }
}

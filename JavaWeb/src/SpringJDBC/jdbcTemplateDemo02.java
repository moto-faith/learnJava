package SpringJDBC;

import cn.java.utils.JDBCDruidUtils;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class jdbcTemplateDemo02 {
    private JdbcTemplate template = new JdbcTemplate(JDBCDruidUtils.getDataSource());

    @Test
    public void update(){
        String sql="update emp set salary =10000 where id=1";
        int update = template.update(sql);
        System.out.println(update);
    }
    @Test
    public void insert(){
        String sql = "insert into emp(id,name,dept_id) values(?,?,?)";
        int insert = template.update(sql,8,"zzz",1);
        System.out.println(insert);
    }
    @Test
    public void delete(){
        String sql = "delete from emp where id=?";
        int delete = template.update(sql, 8);
        System.out.println(delete);
    }
    @Test
    public void queryMap(){
        String sql = "select * from emp where id = ?";
        Map<String, Object> map = template.queryForMap(sql, 1);
        System.out.println(map);
    }
    @Test
    public void queryList(){
        String sql = "select * from emp";
        List<Map<String, Object>> list = template.queryForList(sql);
        for (Map<String, Object> stringObjectMap : list) {
            System.out.println(stringObjectMap);
        }
    }
    @Test
    public void queryObject(){//以对象形式返回
        String sql = "select * from emp";
        List<Emp> list = template.query(sql, new BeanPropertyRowMapper<Emp>(Emp.class));
        for (Emp emp : list) {
            System.out.println(emp);
        }
    }
    @Test
    public void count(){
        String sql = "select count(id) from emp";
        Long total = template.queryForObject(sql, Long.class);
        System.out.println(total);
    }
}

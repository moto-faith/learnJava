package cn.itcast.dao;

import cn.itcast.domain.User;
import cn.itcast.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {
    private JdbcTemplate tem = new JdbcTemplate(JDBCUtils.getDataSource());

    public User login(User loginUser){
        try {
            String sql = "select * from user where name = ? and password = ?";
            User user = tem.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getUsername(), loginUser.getPassword());
            return user;
        }catch (DataAccessException e){
            return null;
        }
    }

}

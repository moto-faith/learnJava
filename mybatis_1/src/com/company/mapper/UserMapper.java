package com.company.mapper;

import com.company.model.User;
import com.company.vo.UserQueryVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 10640
 * Date: 2019-04-17
 * Time: 11:33
 */
public interface UserMapper {

//    @Insert("INSERT INTO user (username,sex,birthday,address) VALUE (#{username},#{sex},#{birthday},#{address})")
    public int save(User user);

//    @Select("SELECT * FROM user WHERE id = #{id}")
    public User findUserById(int id);

    public List<User> findUserByUserQueryVo(UserQueryVO vo);


    public List<User> findUserByMap(Map<String,Object> map);
}

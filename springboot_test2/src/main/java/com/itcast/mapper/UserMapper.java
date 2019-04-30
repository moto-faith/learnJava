package com.itcast.mapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 10640
 * Date: 2019-04-29
 * Time: 11:00
 */

public interface UserMapper {

    @Insert("insert into user(username,password) values(#{username},#{password})")
    public void save(@Param("username") String username, @Param("password") String password);
//
//    @Select("select * from t_user where username = #{username}")
//    public User find(@Param("username") String username);



}

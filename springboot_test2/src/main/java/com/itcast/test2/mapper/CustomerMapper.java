package com.itcast.test2.mapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 10640
 * Date: 2019-04-29
 * Time: 11:00
 */

public interface CustomerMapper {

    @Insert("insert customer (name,tel) values (#{name},#{tel})")
    public int save(@Param("name") String name, @Param("tel") String tel);
//
//    @Select("select * from t_user where username = #{username}")
//    public User find(@Param("username") String username);



}

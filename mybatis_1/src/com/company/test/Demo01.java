package com.company.test;

import com.company.dao.UserDaoImpl;
import com.company.mapper.UserMapper;
import com.company.model.Order;
import com.company.model.User;
import com.company.vo.UserQueryVO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 10640
 * Date: 2019-04-17
 * Time: 9:48
 */
public class Demo01 {
    SqlSession session;
    SqlSessionFactory sessionFactory;
    @Before
    public void before() throws IOException {
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        sessionFactory = new SqlSessionFactoryBuilder().build(is);
        session = sessionFactory.openSession();

    }
    @After
    public void after(){
//        session.commit();
    }

    @Test
    public void test1() throws IOException {
        User user = session.selectOne("findUserById",10);
        System.out.println(user);
        List<User> users = session.selectList("findUserByName", "张");
        System.out.println(users);

    }
    @Test
    public void test2() {
        User user = new User("xp", "1", new Date(), "bj");
        int insertUser = session.insert("insertUser", user);
        System.out.println(insertUser);
    }
    @Test
    public void test3() {
        int deleteUser = session.delete("deleteUser", 27);
        System.out.println(deleteUser);
    }
    @Test
    public void test4() {
        User user = new User();
        user.setId(26);
        user.setAddress("男");
        user.setSex("2");
        int updateUser = session.update("updateUser", user);
        System.out.println(updateUser);
    }
    @Test
    public void test5() {
        User user = new User("xp","2",new Date(),"gz");
        int insertUser2 = session.insert("insertUser2", user);
        System.out.println(user.getId());

    }
    @Test
    public void test6() {
        UserDaoImpl userDao = new UserDaoImpl(sessionFactory);
        User user = userDao.findUserById(1);
        System.out.println(user);
//        User user1 = new User("xx", "x", new Date(), "bj");
//        userDao.save(user1);

    }
    @Test
    public void test7() {
        UserMapper mapper = session.getMapper(UserMapper.class);
        System.out.println(mapper.findUserById(1));

    }
    @Test
    public void test8() {
        UserMapper mapper = session.getMapper(UserMapper.class);
        UserQueryVO query = new UserQueryVO();
        User user = new User();
        user.setId(1);
        query.setUser(user);

        Order order = new Order();
        order.setNumber("100111");
        query.setOrder(order);

        List<User> list = mapper.findUserByUserQueryVo(query);
        System.out.println(list);


    }
    @Test
    public void test9() {
        UserMapper mapper = session.getMapper(UserMapper.class);
        HashMap<String, Object> map = new HashMap<>();
        map.put("username","张");
        map.put("sex","1");
        List<User> list = mapper.findUserByMap(map);
        System.out.println(list);
    }


}

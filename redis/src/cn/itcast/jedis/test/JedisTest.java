package cn.itcast.jedis.test;

import cn.itcast.jedis.util.JedisPoolUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 10640
 * Date: 2019-03-28
 * Time: 16:28
 */
public class JedisTest {

    @Test
    public void test1(){
        Jedis jedis = new Jedis("localhost", 6379);
        jedis.set("username","zhangSan");

        jedis.close();
    }

    @Test
    public void test2(){
        Jedis jedis = new Jedis();
//        jedis.set("username","zhangSan");
        String username = jedis.get("username");
        System.out.println(username);
        jedis.setex("activecode",10,"hehe");


        jedis.close();
    }

    @Test
    public void test3(){
        Jedis jedis = new Jedis();
        jedis.hset("myhash","name","lisi");
        jedis.hset("myhash","age","23");
        jedis.hset("myhash","gender","male");
        String name = jedis.hget("myhash", "name");
        Map<String, String> user = jedis.hgetAll("myhash");
        Set<String> keySets = user.keySet();
        for (String keySet : keySets) {
            System.out.println(keySet+"  "+user.get(keySet));
        }

        jedis.close();
    }

    @Test
    public void test4(){
        Jedis jedis = new Jedis();
        jedis.lpush("myList","a","b","c");
        jedis.rpush("myList","a","b","c");
        List<String> myList = jedis.lrange("myList", 0, -1);
        System.out.println(myList);
        String myList1 = jedis.lpop("myList");
        System.out.println(myList1);
        String myList2 = jedis.rpop("myList");
        System.out.println(myList2);
        System.out.println(jedis.lrange("myList", 0, -1));
        jedis.close();
    }

    @Test
    public void test5(){
        Jedis jedis = new Jedis();
        jedis.sadd("mySet","java","php","c++");
        Set<String> mySet = jedis.smembers("mySet");
        System.out.println(mySet);
        jedis.close();
    }

    @Test
    public void test6(){
        Jedis jedis = new Jedis();
        jedis.zadd("mySortSet",3,"用深色");
        jedis.zadd("mySortSet",60,"色");
        jedis.zadd("mySortSet",24,"深色");
        Set<String> mySet = jedis.zrange("mySortSet",0,-1);
        System.out.println(mySet);
        jedis.close();
    }

    @Test
    public void test7(){
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(50);
        config.setMaxIdle(10);
        JedisPool jedisPool = new JedisPool();
        Jedis jedis = jedisPool.getResource();
        jedis.set("hehe","haha");
        jedis.close();




    }

    @Test
    public void test8(){
        Jedis jedis = JedisPoolUtils.getJedis();
        jedis.set("hello","world");


    }

}

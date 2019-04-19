import com.itcast.mapper.UserMapper;
import com.itcast.model.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 10640
 * Date: 2019-04-19
 * Time: 16:26
 */
public class Demo01 {

    @Test
    public void test2(){
        //1.加载spring的配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //2.获取userMapper
        UserMapper userMapper = (UserMapper) context.getBean("userMapper");

        //3.调用dao方法
        User user = userMapper.findUserById(1);

        System.out.println(user);

    }

}

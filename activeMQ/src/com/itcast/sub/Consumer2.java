package com.itcast.sub;

import com.itcast.p2p.MyMessageListener;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 10640
 * Date: 2019-05-01
 * Time: 17:48
 */
public class Consumer2 {
    private static final String USERNAME= ActiveMQConnection.DEFAULT_USER; // 默认的连接用户名
    private static final String PASSWORD=ActiveMQConnection.DEFAULT_PASSWORD; // 默认的连接密码
    private static final String BROKEURL=ActiveMQConnection.DEFAULT_BROKER_URL; // 默认的连接地址

    public static void main(String[] args) {
        ConnectionFactory connectionFactory;//连接工厂
        Connection connection = null;//连接
        Session session = null;//会话
        Destination destination  = null;//消息目的地，就是一个消息队列
        MessageConsumer messageConsumer  = null;//消息生产者

        try {
            //1.连接MQ
            System.out.println("username:"+USERNAME);
            System.out.println("password:"+PASSWORD);
            System.out.println("url:"+BROKEURL);
            connectionFactory = new ActiveMQConnectionFactory(USERNAME,PASSWORD,BROKEURL);
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(true,Session.AUTO_ACKNOWLEDGE);
            destination = session.createTopic("短信发送T");
            messageConsumer = session.createConsumer(destination);


            //接受消息
/*            while(true){
                TextMessage message = (TextMessage) messageConsumer.receive(10000);
                if(message != null){
                    System.out.println(message.getText());//获取消息
                }
            }*/
/*            for (int i=0;i<5;i++){
                TextMessage textMessage = (TextMessage) messageConsumer.receive();
                System.out.println(textMessage.getText());
            }
            session.commit();*/
            messageConsumer.setMessageListener(new MyMessageListener());
            session.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

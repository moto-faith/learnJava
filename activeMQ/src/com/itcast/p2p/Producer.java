package com.itcast.p2p;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 10640
 * Date: 2019-05-01
 * Time: 17:00
 */
public class Producer {
    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER; // 默认的连接用户名
    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD; // 默认的连接密码
    private static final String BROKEURL = ActiveMQConnection.DEFAULT_BROKER_URL; // 默认的连接地址

    public static void main(String[] args) {
        ConnectionFactory connectionFactory;//连接工厂
        Connection connection = null;//连接
        Session session = null;//会话
        Destination destination = null;//消息目的地，就是一个消息队列
        MessageProducer messageProducer = null;//消息生产者

        try {
            //1.连接MQ
            System.out.println("username:" + USERNAME);
            System.out.println("password:" + PASSWORD);
            System.out.println("url:" + BROKEURL);
            connectionFactory = new ActiveMQConnectionFactory(USERNAME, PASSWORD, BROKEURL);
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
            destination = session.createTopic("短信发送T");
            messageProducer = session.createProducer(destination);

            //2.发送消息
            for (int i = 0; i < 10; i++) {
                String txt = "123423:1380000111" + i;
                TextMessage txtMsg = session.createTextMessage(txt);
                messageProducer.send(destination, txtMsg);
                System.out.println("发送到MQ:" + i);
            }
//            String txt = "1234:13800001110";
//            TextMessage txtMsg = session.createTextMessage(txt);
//            messageProducer.send(destination,txtMsg);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("关闭");
            //3.断开
            try {
                messageProducer.close();
                session.close();
                connection.close();
            } catch (Exception e) {

            }

        }
    }
}
package com.itcast.p2p;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 10640
 * Date: 2019-05-01
 * Time: 17:58
 */
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class MyMessageListener implements MessageListener{

    @Override
    public void onMessage(Message message) {
        try {
            TextMessage textMessage = (TextMessage)message;
            System.out.println("从MQ获取的消息:" + textMessage.getText());
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}

package com.learn.java;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientTCP {
    public static void main(String[] args) throws Exception {
        System.out.println("客户端 发送数据");
        Socket client = new Socket("localhost",6666);
        OutputStream os = client.getOutputStream();
        os.write("你好吗？服务器".getBytes());
        InputStream is = client.getInputStream();
        byte[] b = new byte[1024];
        int len = is.read(b);
        System.out.println(new String(b,0,len));
        is.close();
        os.close();
        client.close();
    }
}

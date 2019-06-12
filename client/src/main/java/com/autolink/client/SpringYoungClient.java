package com.autolink.client;

import com.autolink.server.UserService;
import com.autolink.server.bean.UserVo;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

/**
 * Created by dell on 2019/6/12.
 */
public class SpringYoungClient {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-consumer.xml");
        context.start();
        UserService userService = context.getBean(UserService.class);
        String cmd;

        while (!"exist".equals(cmd = read())) {
//            System.out.println(services.get(count++ % services.size()).getUser(11));
            UserVo user = userService.getUser(111);
            System.out.println(user);
        }
    }

    private static String read() throws IOException {
        byte[] b = new byte[1024];
        LineNumberReader lineNumber = new LineNumberReader(
                new InputStreamReader(System.in));
        return lineNumber.readLine();
    }

}

package com.autolink.server;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created by dell on 2019/6/12.
 */
public class SpringSimpleServer {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("spring-provide.xml");
        context.start();
        System.in.read();
    }
}


package com.autolink.server;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import com.autolink.server.impl.UserServiceImpl;

import java.io.IOException;
import java.util.List;

/**
 * 　　　┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　┻　　　┃
 * 　　┗━┓　　　┏━┛
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　永无BUG 　┣┓
 * 　　　　┃　　如来保佑　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 *
 * @author slc
 * @date 2019/6/6
 */
public class SimpleServer {
    public void openService(int port) {
        //服务配置
        ServiceConfig<UserService> serviceConfig = new ServiceConfig();
        //设置服务接口
        serviceConfig.setInterface(UserService.class);
        //设置开放的协议
        serviceConfig.setProtocol(new ProtocolConfig("dubbo", port));
        //设置一个空的注册中心
//        serviceConfig.setRegistry(new RegistryConfig(RegistryConfig.NO_AVAILABLE));
        serviceConfig.setRegistry(new RegistryConfig("multicast://224.1.2.3:11111"));//逐网广播
        //设置服务当前所在应用
        serviceConfig.setApplication(new ApplicationConfig("simple-app"));
        //设置服务实现对象
        UserServiceImpl impl = new UserServiceImpl();
        serviceConfig.setRef(impl);
        //暴露服务
        serviceConfig.export();
        List<URL> list = serviceConfig.getExportedUrls();
        impl.setPort(list.get(0).getPort());
        System.out.println("服务已开启 :" + list.get(0).getPort());

    }

    public static void main(String[] args) throws IOException {
        new SimpleServer().openService(-1);//默认从20880开始
        System.in.read();
    }
}

package com.autolink.client;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.autolink.server.UserService;
import com.autolink.server.bean.UserVo;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
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
public class YoungClient {
    //基于url构建远程服务
    public UserService buildRemoteService(String remoteUrl) {
        ReferenceConfig<UserService> referenceConfig = new ReferenceConfig();
        referenceConfig.setInterface(UserService.class);
//        referenceConfig.setRegistry(new RegistryConfig(RegistryConfig.NO_AVAILABLE));
        referenceConfig.setRegistry(new RegistryConfig("multicast://224.1.2.3:11111"));
//        referenceConfig.setUrl(remoteUrl);
        referenceConfig.setApplication(new ApplicationConfig("young-app"));
//        referenceConfig.setLoadbalance("");
        return referenceConfig.get();
    }

    public static void main(String[] args) throws IOException {
        YoungClient youngClient = new YoungClient();
        UserService userService = youngClient.buildRemoteService(null);


     /*   List<UserService> services = new ArrayList<>();
        services.add(youngClient.buildRemoteService("dubbo://127.0.0.1:20880/com.autolink.server.UserService"));
        services.add(youngClient.buildRemoteService("dubbo://127.0.0.1:20881/com.autolink.server.UserService"));
        services.add(youngClient.buildRemoteService("dubbo://127.0.0.1:20882/com.autolink.server.UserService"));*/

        String cmd;
        int count = 0;
        while (!"exist".equals(cmd = read())) {
//            System.out.println(services.get(count++ % services.size()).getUser(11));
            UserVo user = userService.getUser(111);
            System.out.println(user);
        }


//        UserService userService = youngClient.buildRemoteService("dubbo://127.0.0.1:20880/com.autolink.server.UserService");
//        System.out.println(userService.getUser(11));

    }

    private static String read() throws IOException {
        byte[] b = new byte[1024];
        LineNumberReader lineNumberReader = new LineNumberReader(new InputStreamReader(System.in));
        return lineNumberReader.readLine();
    }

}

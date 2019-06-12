package com.autolink.server.impl;

import com.autolink.server.UserService;
import com.autolink.server.bean.UserVo;

import java.lang.management.ManagementFactory;
import java.util.Date;

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
public class UserServiceImpl implements UserService {
    int port;

    public UserVo getUser(Integer id) {
        UserVo u = new UserVo();
        u.setBirthDay(new Date());
        u.setId(id);
        u.setPort(port);
        u.setName(ManagementFactory.getRuntimeMXBean().getName());
        return u;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}

package com.alibaba.webx3.messageboard.biz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.webx3.messageboard.biz.service.UserService;
import com.alibaba.webx3.messageboard.dao.UserDAO;
import com.alibaba.webx3.messageboard.dao.object.UserDO;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    public boolean addUser(UserDO userDO) {
        return userDAO.addUser(userDO);
    }

    public boolean deleteUser(UserDO userDO) {
        return userDAO.deleteUser(userDO);
    }

    public UserDO getByUsername(String username) {
        return userDAO.getByUsername(username);
    }

    public boolean updateUser(UserDO userDO) {
        return userDAO.updateUser(userDO);
    }

}

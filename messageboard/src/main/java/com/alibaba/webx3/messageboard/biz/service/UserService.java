package com.alibaba.webx3.messageboard.biz.service;

import com.alibaba.webx3.messageboard.dao.object.UserDO;

public interface UserService {

    public boolean addUser(UserDO userDO);

    public boolean deleteUser(UserDO userDO);

    public UserDO getByUsername(String username);

    public boolean updateUser(UserDO userDO);

}

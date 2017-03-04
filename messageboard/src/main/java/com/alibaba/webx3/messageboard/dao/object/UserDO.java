package com.alibaba.webx3.messageboard.dao.object;

import java.util.Date;

public class UserDO {

    private String username;
    
    private String password;
    
    private int id;
    
    private Date gmtModify;
    
    private Date gmtCreate;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public Date getGmtModify() {
        return gmtModify;
    }
    
    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }
    
    public Date getGmtCreate() {
        return gmtCreate;
    }
   
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }
      
}

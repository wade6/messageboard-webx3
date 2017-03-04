package com.alibaba.webx3.messageboard.dao.object;

import java.util.Date;

public class MessageDO {
    
    private int id;
    
    private String title;
    
    private String author;
    
    private String content;
    
    private Date gmtModify;
    
    private Date gmtCreate;
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }        
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
    
    public String getContent() {
        return content;
    }
    
    public void setContent(String content) {
        this.content = content;
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

package com.alibaba.webx3.messageboard.module.screen.message;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.dataresolver.Param;
import com.alibaba.webx3.messageboard.biz.service.MessageService;
import com.alibaba.webx3.messageboard.dao.object.MessageDO;

public class ModifyMessage {
    
    @Autowired
    private MessageService messageService;
    
    public void execute(@Param(name="messageId")int messageId,Context context,HttpSession session){
    	String userName = (String) session.getAttribute("login_user");  
    	context.put("username", userName);
    	
        MessageDO messageDO;
        
        messageDO = messageService.getMessageById(messageId);
        
        if(messageDO==null){
            context.put("message", "获取数据失败！");
        }
        else{
            context.put("messageDO", messageDO);
        }
    }
}

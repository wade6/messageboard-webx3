package com.alibaba.webx3.messageboard.module.screen.message;



import javax.servlet.http.HttpSession;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.dataresolver.Param;

public class AddMessage {
    
    public void execute(@Param(name="message") String message,Context context,HttpSession session){
        context.put("message", message);
        String userName = (String) session.getAttribute("login_user");  
    	context.put("username", userName);
    }
}

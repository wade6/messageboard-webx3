package com.alibaba.webx3.messageboard.module.action;  
  
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.Navigator;
import com.alibaba.citrus.turbine.dataresolver.FormGroup;
import com.alibaba.webx3.messageboard.biz.service.UserService;
import com.alibaba.webx3.messageboard.dao.object.UserDO;
import com.alibaba.webx3.messageboard.module.vo.UserVO;  
  
public class UserAction {  
  
    @Autowired  
    private UserService         userService;  
  
    // 登陆  
    public void doLogin(@FormGroup("login")  
    UserVO user, Context context, Navigator nav, HttpSession session) {  
  
        String username = user.getUsername();  
        String password = user.getPassword();  
  
        UserDO userdo = null;  
        boolean success;  
  
        // 根据用户名获得用户记录  
        userdo = userService.getByUsername(username);  
        if (userdo == null) {  
            context.put("message", "用户名不存在!");  
            nav.forwardTo("index");  
            return;  
        }  
  
        // 校验密码是否正确  
        if (password.equals(userdo.getPassword())) {  
            success = true;  
        } else {  
            success = false;  
        }  
  
        // 判断执行转向和重定向  
        if (success) {  
            session.setAttribute("login_user", user.getUsername());  
            context.put("username", user.getUsername());  
            nav.redirectTo("messageBoardLink").withTarget("/message/messageList");  
        } else {  
            context.put("message", "密码错误!");  
            nav.forwardTo("index");  
        }  
    }  
  
    // 退出  
    public void doLogout(Navigator nav, HttpSession session) {  
        session.invalidate();  
        // 转到首页  
        nav.redirectTo("messageBoardLink").withTarget("index");  
    }  
}  
package com.alibaba.webx3.messageboard.module.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.citrus.turbine.Navigator;
import com.alibaba.citrus.turbine.dataresolver.Param;
import com.alibaba.citrus.turbine.dataresolver.Params;
import com.alibaba.citrus.util.StringUtil;
import com.alibaba.webx3.messageboard.biz.service.MessageService;
import com.alibaba.webx3.messageboard.dao.object.MessageDO;

public class MessageAction {

    @Autowired
    private MessageService messageService;

    //添加留言
    public void doAddMessage(@Params
    MessageDO messageDO, Navigator nav) {
        // 没有取到页面的数据
        if (messageDO == null) {
            nav.redirectTo("messageBoardLink").withTarget("message/addMessage").withParameter("message", "页面提交失败！");

        }

        boolean result = false;
        // 插入数据库
        result = messageService.addMessage(messageDO);

        // 校验结果及跳转
        if (result) {
            nav.redirectTo("messageBoardLink").withTarget("message/messageList");
        } else {
            nav.redirectTo("messageBoardLink").withTarget("message/addMessage").withParameter("message", "数据库操作失败！");
        }
    }

    //删除留言
    public void doDelete(@Param(name = "messageId")
    int messageId, Navigator nav) {
        // 没有取到页面的数据
        if (messageId <= 0) {
            nav.redirectTo("messageBoardLink").withTarget("message/messageList").withParameter("message", "页面提交失败！");

        }

        boolean result = false;
        // 删除数据
        result = messageService.deleteMessageById(messageId);

        // 校验结果及跳转
        if (result) {
            nav.redirectTo("messageBoardLink").withTarget("message/messageList");
        } else {
            nav.redirectTo("messageBoardLink").withTarget("message/messageList").withParameter("message", "数据库操作失败！");
        }
    }

     //修改留言
    public void doModifyMessage(@Params MessageDO messageDO, Navigator nav) {
        //生成修改时间
        SimpleDateFormat df=new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        //获取修改者
        String modifyauthor = messageDO.getAuthor();
        //去掉上次修改的作者信息
        String content = messageDO.getContent();
        if(!StringUtil.isBlank(content)){
            int index = content.indexOf("-");
            if(index>=0){
                content = content.substring(0, index);
            }
            //生成修改信息
            content=content+"------(此留言被用户 "+modifyauthor+" 修改过，时间： "+df.format(new Date())+")";
        }
        else{
        //生成修改信息
        content="------(此留言被用户 "+modifyauthor+" 修改过，时间： "+df.format(new Date())+")";
        }
        
        messageDO.setContent(content);
        messageDO.setAuthor(null);

        boolean result = false;
        // 插入数据库
        result = messageService.updateMessage(messageDO);

        // 校验结果及跳转
        if (result) {
            nav.redirectTo("messageBoardLink").withTarget("message/messageList");
        } else {
            nav.redirectTo("messageBoardLink").withTarget("message/messageList").withParameter("message", "修改操作失败！");
        }
    }
}

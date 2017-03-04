package com.alibaba.webx3.messageboard.biz.service.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.webx3.messageboard.biz.service.MessageService;
import com.alibaba.webx3.messageboard.dao.MessageDAO;
import com.alibaba.webx3.messageboard.dao.object.MessageDO;

public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageDAO messageDAO;

    public boolean addMessage(MessageDO messageDO) {
        return messageDAO.addMessage(messageDO);
    }

    public MessageDO getMessageById(int id) {
        return messageDAO.getMessageById(id);
    }

    public List<MessageDO> getMessageList(Map<String, Integer> map) {
        return messageDAO.getMessageList(map);
    }

    public boolean deleteMessageById(int id) {
        return messageDAO.deleteMessageById(id);
    }

    public boolean updateMessage(MessageDO messageDO) {
        return messageDAO.updateMessage(messageDO);
    }

}

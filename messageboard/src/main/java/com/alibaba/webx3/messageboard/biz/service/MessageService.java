package com.alibaba.webx3.messageboard.biz.service;

import java.util.List;
import java.util.Map;
import com.alibaba.webx3.messageboard.dao.object.MessageDO;

public interface MessageService {

    public boolean addMessage(MessageDO messageDO);

    public MessageDO getMessageById(int id);

    public List<MessageDO> getMessageList(Map<String, Integer> map);

    public boolean deleteMessageById(int id);

    public boolean updateMessage(MessageDO messageDO);
}

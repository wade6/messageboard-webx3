package com.alibaba.webx3.messageboard.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.alibaba.webx3.messageboard.dao.MessageDAO;
import com.alibaba.webx3.messageboard.dao.object.MessageDO;

public class MessageDAOImpl extends SqlMapClientDaoSupport implements MessageDAO {

	public boolean addMessage(MessageDO messageDO) {
		Object result = getSqlMapClientTemplate().insert("insertMessage", messageDO);
		return ((Integer) result > 0);
	}

	public MessageDO getMessageById(int id) {
		return (MessageDO) getSqlMapClientTemplate().queryForObject("selectById", id);
	}

	@SuppressWarnings("unchecked")
	public List<MessageDO> getMessageList(Map<String, Integer> map) {
		return getSqlMapClientTemplate().queryForList("selectBylist", map);
	}

	public boolean deleteMessageById(int id) {
		int result = getSqlMapClientTemplate().delete("deleteMessage", id);
		return (result > 0);
	}

	public boolean updateMessage(MessageDO messageDO) {
		int result = getSqlMapClientTemplate().update("updateMessage", messageDO);
		return (result > 0);
	}

}

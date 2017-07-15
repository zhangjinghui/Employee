package com.zjh.ssh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zjh.ssh.dao.MessageDao;
import com.zjh.ssh.entities.Message;

@Service
public class MessageService {
	@Autowired
	private MessageDao messageDao;
	
	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}
	public List sendMessageList(Message message){
		return messageDao.sendMessageList( message);
	}
	public List receiveMessageList(Message message){
		return messageDao.receiveMessageList( message);
	}
	public void sendMessage(Message message){
		 messageDao.sendMessage(message);
	}
	public List receiverList(){
		return messageDao.receiverList();
	}
	public Message get(Integer id) {
		return messageDao.get(id);
	}
	public void delete(Integer id) {
		messageDao.delete(id);
	}
}

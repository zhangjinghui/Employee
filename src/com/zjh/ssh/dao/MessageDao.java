package com.zjh.ssh.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;


import com.zjh.ssh.entities.Message;

@Repository
public class MessageDao extends BaseDao{
	public List sendMessageList(Message message){
		return getSession().createQuery("FROM Message m WHERE m.sender='"+message.getSender()+"'").list();
	}
	public List receiveMessageList(Message message){
		return getSession().createQuery("FROM Message m WHERE m.receiver='"+message.getReceiver()+"'").list();
	}
	public void sendMessage(Message message){
		getSession().save(message);
	}
	public Message get(Integer id) {
		return (Message) getSession().get(Message.class, id);
	}
	public List receiverList(){	
		
		Query q=getSession().createQuery("SELECT u.username FROM User u");
		List list= q.list();
        return list;
	}
	public void delete(Integer id) {
		Message message = (Message) getSession().get(Message.class, id);
		getSession().delete(message);
	}
}

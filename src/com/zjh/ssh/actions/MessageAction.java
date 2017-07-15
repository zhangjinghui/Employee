package com.zjh.ssh.actions;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.zjh.ssh.entities.Message;
import com.zjh.ssh.entities.User;
import com.zjh.ssh.service.MessageService;

@Controller
@Scope("prototype")
public class MessageAction extends ActionSupport implements RequestAware,
SessionAware, ModelDriven<Message>, Preparable{
	@Autowired
	private MessageService messageService;
	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}
	private User user;
	private Message message;
	private Integer id;
	private Message model;
	private InputStream inputStream;
	
	private List receiverList=new ArrayList();

	public List getReceiverList() {
		return receiverList;
	}
	public void setReceiverList(List receiverList) {
		this.receiverList = receiverList;
	}
	public void prepareGet() {
		model = messageService.get(id);
	}
	
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	public String get() {
		return "get-success";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}
	/**
	 * 
	 */
	List sendMessageList=new ArrayList();
	List receiveMessageList=new ArrayList();
	private static final long serialVersionUID = 1L;
//	public void prepareSendMessageList(){
//		message=new Message();
//	}
	public void prepareReceiverList(){		
		this.receiverList=messageService.receiverList();
	}
	public String receiverList(){	
//		HttpSession s = ServletActionContext.getRequest().getSession();	
//		s.setAttribute("receiverList", receiverList);
		return "receiverList";
	}
//	public void prepareSendMessage(){
//		this.message=messageService.sendMessage();
//	}
	public void prepareInput() {
		if (id != null) {
			model = messageService.get(id);
		}
	}

	public String input() {
		return INPUT;
	}
	public String delete() {
		try {
			messageService.delete(id);
			inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			try {
				inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return "ajax-success";
	}

	public String sendMessage(){
		HttpServletRequest request = ServletActionContext.getRequest();	
		HttpSession s = ServletActionContext.getRequest().getSession();
		User user=(User) s.getAttribute("user");
		message.setSender(user.getUsername());
		String receiver=request.getParameter("receiver");
		message.setReceiver(receiver);
		message.setCreatetime(new Date());
		messageService.sendMessage(message);

		return "sendMessage";
	}
	public String sendMessageList(){
		HttpSession s = ServletActionContext.getRequest().getSession();		
		Message message=new Message();
		//User user=(User) s.getAttribute("user");		
		message.setSender(((User) s.getAttribute("user")).getUsername());
		sendMessageList=messageService.sendMessageList(message);
		s.setAttribute("sendMessageList", sendMessageList);
		return "sendMessageList";
	}
	public String receiveMessageList(){
		HttpSession s = ServletActionContext.getRequest().getSession();		
		Message message=new Message();
		User user=(User) s.getAttribute("user");		
		message.setReceiver(user.getUsername());
		receiveMessageList=messageService.receiveMessageList(message);
		s.setAttribute("receiveMessageList", receiveMessageList);
		return "receiveMessageList";
	}
	

	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Message getModel() {
		// TODO Auto-generated method stub
		return model;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setRequest(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}

}

package com.zjh.ssh.actions;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.zjh.ssh.entities.User;
import com.zjh.ssh.service.UserService;

@Controller()
@Scope("prototype")
public class UserAction extends ActionSupport implements RequestAware,
		SessionAware, ModelDriven<User>, Preparable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private UserService userService;

	public void prepareLogin() {
		user = new User();
	}

	public String login() {
		User u = null;
		if ((u = userService.login(user)) != null) {
			session.put("user", u);
			return "success";
		}
		return "failed";
	}

	public String logout() {
		((SessionMap) session).invalidate();
		return "logout-success";
	}

	public void prepareGet() {
		this.user = userService.get(((User) session.get("user")).getId());
	}

	public String get() {
		return "personal-show";
	}

	public void prepareEdit() {
		this.user = userService.get(((User) session.get("user")).getId());
	}

	public String edit() {
		return "personal-input";
	}

	public void prepareUpdate() {
		this.user = userService.get(((User) session.get("user")).getId());
	}

	public String update() {
		userService.saveOrUpdate(user);
		return "update-success";
	}

	private Map<String, Object> session;

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}

	private Map<String, Object> request;

	@Override
	public void setRequest(Map<String, Object> arg0) {
		this.request = arg0;
	}

	private User user;

	@Override
	public User getModel() {
		return user;
	}

	@Override
	public void prepare() throws Exception {

	}

}

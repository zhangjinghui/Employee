package com.zjh.ssh.actions;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.zjh.ssh.entities.Customer;
import com.zjh.ssh.service.CustomerService;

@Controller
@Scope("prototype")
public class CustomerAction extends ActionSupport implements RequestAware,
		SessionAware, ModelDriven<Customer>, Preparable {
	@Autowired
	private CustomerService customerService;

	public void prepareGet() {
		model = customerService.get(id);
	}

	public String get() {
		return "get-success";
	}

	private InputStream inputStream;

	public InputStream getInputStream() {
		return inputStream;
	}

	public String delete() {
		try {
			customerService.delete(id);
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

	public void prepareSave() {
		if (id == null) {
			model = new Customer();
			model.setCreatetime(new Date());
		} else {
			model = customerService.get(id);
		}
	}

	public String save() {
		customerService.saveOrUpdate(model);
		return "success";
	}

	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void prepareInput() {
		if (id != null) {
			model = customerService.get(id);
		}
	}

	public String input() {
		return INPUT;
	}

	public String list() {
		request.put("customers", customerService.getAll(pageNum));
		request.put("maxPage", customerService.getMaxPage());
		return "list";
	}

	private Integer pageNum;

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	@Override
	public void prepare() throws Exception {

	}

	private Customer model;

	@Override
	public Customer getModel() {
		return model;
	}

	private Map<String, Object> session;

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	private Map<String, Object> request;

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

}

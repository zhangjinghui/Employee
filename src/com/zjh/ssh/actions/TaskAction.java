package com.zjh.ssh.actions;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.zjh.ssh.entities.Task;
import com.zjh.ssh.service.DepartmentService;
import com.zjh.ssh.service.TaskService;

@Controller
@Scope("prototype")
public class TaskAction extends ActionSupport implements RequestAware,
		ModelDriven, Preparable {

	@Autowired
	private TaskService taskService;
	@Autowired
	private DepartmentService departmentService;

	private Integer pageNum;

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	private InputStream inputStream;

	public InputStream getInputStream() {
		return inputStream;
	}

	public void prepareGet() {
		this.task = taskService.get(id);
	}

	public String get() {
		return "get-success";
	}

	public String list() {
		request.put("tasks", taskService.getAll(pageNum));
		request.put("maxPage", taskService.getMaxPage());
		return "list";
	}

	public void prepareInput() {
		if (id != null) {
			task = taskService.get(id);

		}
	}

	public String input() {
		request.put("departments", departmentService.getAll());
		return INPUT;
	}

	private Integer id;

	public void setId(Integer id) {
		this.id = id;
	}

	public void prepareSave() {
		if (id == null) {
			task = new Task();
		} else {
			task = taskService.get(id);
		}
		request.put("departments", departmentService.getAll());
	}

	public String save() {

		taskService.saveOrUpdate(task);

		return SUCCESS;
	}

	public String delete() {
		try {
			taskService.delete(id);
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

	private Map<String, Object> request;

	@Override
	public void setRequest(Map<String, Object> arg0) {
		request = arg0;
	}

	@Override
	public void prepare() throws Exception {

	}

	private Task task;

	@Override
	public Object getModel() {
		return task;
	}

}

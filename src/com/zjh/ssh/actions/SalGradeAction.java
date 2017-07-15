package com.zjh.ssh.actions;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.zjh.ssh.entities.SalGrade;
import com.zjh.ssh.service.SalGradeService;

@Controller
@Scope("prototype")
public class SalGradeAction extends ActionSupport implements RequestAware,
		ModelDriven, Preparable {
	@Autowired
	private SalGradeService salGradeService;

	public void prepareSave() {
		if (id == null) {
			model = new SalGrade();
			model.setCreatetime(new Date());
			model.setEdittime(new Date());
		} else {
			model = salGradeService.get(id);
			model.setEdittime(new Date());
		}
	}

	public String save() {
		salGradeService.saveOrUpdate(model);
		return "success";
	}

	public void prepareInput() {
		if (id != null) {
			model = salGradeService.get(id);
		}
	}

	public String input() {
		return "input";
	}

	public String list() {
		request.put("grades", salGradeService.getAll(pageNum));
		request.put("maxPage", salGradeService.getMaxPage());
		return "salgrade-list";
	}

	public String delete() {
		try {
			salGradeService.delete(id);
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

	private SalGrade model;

	@Override
	public Object getModel() {
		return model;
	}

	private InputStream inputStream;

	public InputStream getInputStream() {
		return inputStream;
	}

	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	private Integer pageNum;

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageNum() {
		return pageNum;
	}

}

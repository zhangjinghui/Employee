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
import com.zjh.ssh.entities.Employee;
import com.zjh.ssh.entities.User;
import com.zjh.ssh.service.DepartmentService;
import com.zjh.ssh.service.EmployeeService;
import com.zjh.ssh.service.SalGradeService;

@Controller
@Scope("prototype")
public class EmployeeAction extends ActionSupport implements RequestAware,
		ModelDriven, Preparable {
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private SalGradeService salGradeService;

	private Integer pageNum;

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public String list() {
		request.put("employees", employeeService.getAll(pageNum));
		request.put("maxPage", employeeService.getMaxPage());
		return "list";
	}

	private Integer empno;

	public void setEmpno(Integer empno) {
		this.empno = empno;
	}

	private InputStream inputStream;

	public InputStream getInputStream() {
		return inputStream;
	}

	public String delete() {
		try {
			employeeService.delete(empno);
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

	public void prepareInput() {
		if (empno != null) {
			model = employeeService.get(empno);
			user = model.getUser();
		}
	}

	public String input() {
		request.put("departments", departmentService.getAll());
		request.put("jobs", salGradeService.getJobs());
		return INPUT;
	}

	private User user;

	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	/**
	 * 可以根据 id 来判断为 save 方法准备的 model 是 new 的还是从数据库获取的!
	 */
	public void prepareSave() {
		if (empno == null) {
			model = new Employee();
			model.setCreatetime(new Date());
		} else {
			model = employeeService.get(empno);
			user = model.getUser();
		}
		request.put("departments", departmentService.getAll());
		request.put("jobs", salGradeService.getJobs());
	}

	public String save() {
		user.setEmp(model);
		user.setRealname(model.getEname());
		employeeService.saveOrUpdate(user, model);
		return SUCCESS;
	}

	private String lastName;

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String validateLastName() throws UnsupportedEncodingException {
		if (employeeService.lastNameIsValid(lastName)) {
			inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
		} else {
			inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
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

	private Employee model;

	@Override
	public Object getModel() {
		return model;
	}
}

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
import com.zjh.ssh.entities.Department;
import com.zjh.ssh.service.DepartmentService;
import com.zjh.ssh.service.EmployeeService;

@Controller
@Scope("prototype")
public class DepartmentAction extends ActionSupport implements RequestAware,
		ModelDriven, Preparable {
	@Autowired
	private DepartmentService departmentService;

	@Autowired
	private EmployeeService employeeService;

	public String delete() {
		try {
			departmentService.delete(deptno);
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
		if (deptno == null) {
			model = new Department();
		} else {
			model = departmentService.get(deptno);
		}
	}

	public String save() {
		departmentService.saveOrUpdate(model);
		return "success";
	}

	public void prepareInput() {
		if (deptno != null) {
			model = departmentService.get(deptno);
		}
	}

	public String input() {
		return INPUT;
	}

	public String list() {
		request.put("departments", departmentService.getAllByPage(pageNum));
		request.put("maxPage", departmentService.getMaxPage());
		return "dept-list";
	}

	private Integer deptno;

	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}

	public Integer getDeptno() {
		return deptno;
	}

	private Integer pageNum;

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public String getEmployee() {
		request.put("employees", employeeService.getEmpByDept(deptno, pageNum));
		request.put("maxPage", employeeService.getEmpByDeptMaxPage(deptno));
		return "dept-emp-list";
	}

	@Override
	public void prepare() throws Exception {

	}

	public Department model;

	@Override
	public Object getModel() {
		return model;
	}

	private Map<String, Object> request;

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	private InputStream inputStream;

	public InputStream getInputStream() {
		return inputStream;
	}

}

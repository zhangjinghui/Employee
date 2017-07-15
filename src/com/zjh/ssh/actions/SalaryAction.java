package com.zjh.ssh.actions;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.zjh.ssh.entities.Employee;
import com.zjh.ssh.entities.SalGrade;
import com.zjh.ssh.entities.Salary;
import com.zjh.ssh.service.EmployeeService;
import com.zjh.ssh.service.SalGradeService;
import com.zjh.ssh.service.SalaryService;

@Controller
@Scope("prototype")
public class SalaryAction extends ActionSupport implements RequestAware,
		ModelDriven, Preparable {
	@Autowired
	private SalaryService salaryService;

	@Autowired
	private SalGradeService salGradeService;
	@Autowired
	private EmployeeService employeeService;

	public void prepareSave() {
		model = new Salary();
		model.setSalgrade(salGradeService.get(job));
	}

	public String save() {
		Integer realsalary = model.getSalgrade().getBasicsalary()
				- model.getFine() + model.getBouns();
		if (realsalary >= 0) {
			model.setRealsalary(realsalary);
		} else {
			model.setRealsalary(0);
		}
		salaryService.saveOrUpdate(model);
		return "success";
	}

	public String input() {
		Employee employee = employeeService.get(empno);
		job = employee.getJob();
		ename = employee.getEname();
		return INPUT;
	}

	public String list() {
		request.put("sals", salaryService.getAll(pageNum));
		request.put("maxPage", salaryService.getMaxPage());
		return "sal-list";
	}

	private SalGrade salGrade;

	public SalGrade getSalGrade() {
		return salGrade;
	}

	public void setSalGrade(SalGrade salGrade) {
		this.salGrade = salGrade;
	}

	private Integer pageNum;

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	private Map<String, Object> request;

	@Override
	public void setRequest(Map<String, Object> arg0) {
		request = arg0;
	}

	@Override
	public void prepare() throws Exception {

	}

	private String job;

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	private Integer empno;

	public Integer getEmpno() {
		return empno;
	}

	public void setEmpno(Integer empno) {
		this.empno = empno;
	}

	private SalGrade salgrade;

	public SalGrade getSalgrade() {
		return salgrade;
	}

	public void setSalgrade(SalGrade salgrade) {
		this.salgrade = salgrade;
	}

	private Integer year;
	private Integer month;

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	private String ename;

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	private Salary model;

	@Override
	public Object getModel() {
		return model;
	}
}

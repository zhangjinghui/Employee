package com.zjh.ssh.entities;

import java.util.HashSet;
import java.util.Set;

public class Department {
	private Integer deptno;
	private String dname;

	private Set<Employee> employees = new HashSet<Employee>();

	public Integer getDeptno() {
		return deptno;
	}

	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

}

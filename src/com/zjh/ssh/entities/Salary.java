package com.zjh.ssh.entities;

public class Salary {
	private Integer id;
	private String ename;
	private Integer year;
	private Integer month;
	private Integer bouns;
	private Integer fine;
	private String sender;
	private Integer realsalary;

	private SalGrade salgrade;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

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

	public Integer getBouns() {
		return bouns;
	}

	public void setBouns(Integer bouns) {
		this.bouns = bouns;
	}

	public Integer getFine() {
		return fine;
	}

	public void setFine(Integer fine) {
		this.fine = fine;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public Integer getRealsalary() {
		return realsalary;
	}

	public void setRealsalary(Integer realsalary) {
		this.realsalary = realsalary;
	}

	public SalGrade getSalgrade() {
		return salgrade;
	}

	public void setSalgrade(SalGrade salgrade) {
		this.salgrade = salgrade;
	}

}

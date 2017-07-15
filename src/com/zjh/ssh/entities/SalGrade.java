package com.zjh.ssh.entities;

import java.util.Date;

public class SalGrade {
	private Integer id;
	private String job;
	private Integer basicsalary;
	private Date createtime;
	private Date edittime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Integer getBasicsalary() {
		return basicsalary;
	}

	public void setBasicsalary(Integer basicsalary) {
		this.basicsalary = basicsalary;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Date getEdittime() {
		return edittime;
	}

	public void setEdittime(Date edittime) {
		this.edittime = edittime;
	}

}

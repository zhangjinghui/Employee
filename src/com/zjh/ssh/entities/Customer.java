package com.zjh.ssh.entities;

import java.util.Date;

public class Customer {
	private Integer id;
	private String companyname;
	private String contact;
	private String phone;
	private String address;
	private String briefintroduction;
	private Date createtime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBriefintroduction() {
		return briefintroduction;
	}

	public void setBriefintroduction(String briefintroduction) {
		this.briefintroduction = briefintroduction;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

}

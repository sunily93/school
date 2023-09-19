package com.school.dto;

import java.util.Date;

public class FeeDto {

	private int id;
	private String month;
	private String givenBy;
	private Long amount;
	private String disc;
	private Date createdDate;
	private int studentId;
	
	public FeeDto() {
		// TODO Auto-generated constructor stub
	}

	public FeeDto(int id, String month, String givenBy, Long amount, String disc, Date createdDate, int userId) {
		super();
		this.id = id;
		this.month = month;
		this.givenBy = givenBy;
		this.amount = amount;
		this.disc = disc;
		this.createdDate = createdDate;
		this.studentId = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getGivenBy() {
		return givenBy;
	}

	public void setGivenBy(String givenBy) {
		this.givenBy = givenBy;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public String getDisc() {
		return disc;
	}

	public void setDisc(String disc) {
		this.disc = disc;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int userId) {
		this.studentId = userId;
	}
	
}

package com.miniproject.miniproject;

import javax.persistence.*;


@Entity
@Table(name = "request")
public class Request {

	@Id
	@Column(name = "request_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "Name", nullable = false)
	private String name;

	@Column(name = "Amount", nullable = false)
	private float amount;

	@Column(name = "Date", nullable = false)
	private String datetime;

	@Column(name = "Description", nullable = true)
	private String description;

	@Column(name = "Branch", nullable = false)
	private String branch;

	@Column(name = "Status", nullable = false)
	private String status;
	
	protected Request() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Request [id=" + id + 
		", name=" + name + 
		", amount=" + amount + 
		", datetime=" + datetime + 
		", description=" + description + 
		", branch=" + branch + 
		", status=" + status + "]";
	}
}

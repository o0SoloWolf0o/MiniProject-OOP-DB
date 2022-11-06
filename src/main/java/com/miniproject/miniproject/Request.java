package com.miniproject.miniproject;

import javax.persistence.*;


@Entity
@Table(name = "request")
public class Request {

	@Id
	@Column(name = "Request_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "Name", nullable = false)
	private String name;

	@Column(name = "Amount", nullable = false)
	private int amount;

	@Column(name = "Date", nullable = false)
	private String datetime;

	@Column(name = "Description", nullable = true)
	private String description;

	@Column(name = "Branch", nullable = false)
	private String branch;

	@Column(name = "Status", nullable = false)
	private String status;
	
	@Column(name = "Product_Id", nullable = false)
	private int product_id;

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

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
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

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	@Override
	public String toString() {
		return "Request [id=" + id + 
		", name=" + name + 
		", amount=" + amount + 
		", datetime=" + datetime + 
		", description=" + description + 
		", branch=" + branch + 
		", status=" + status + 
		", product_id=" + product_id + "]";
	}
}

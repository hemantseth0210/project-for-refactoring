package com.demo.customer.model;

public class Account {

	private String id;
	private Integer customerId;
	private String accountNumber;
	private String totalAmount;
	private String branchName;
	private String bankName;
	private String bankCity;
	private String zipCode;
	
	public Account(String id, Integer customerId, String accountNumber, String totalAmount, String branchName,
			String bankName, String bankCity, String zipCode) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.accountNumber = accountNumber;
		this.totalAmount = totalAmount;
		this.branchName = branchName;
		this.bankName = bankName;
		this.bankCity = bankCity;
		this.zipCode = zipCode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankCity() {
		return bankCity;
	}

	public void setBankCity(String bankCity) {
		this.bankCity = bankCity;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	
	
}

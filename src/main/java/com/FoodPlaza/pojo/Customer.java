package com.FoodPlaza.pojo;

public class Customer {

	private int custId;
	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	private String custname;
	private String emailId;
	private String custPassword;
	private String custAddress;
	private String custContactNo;
	private String custLocation;

	public Customer() {
	}

	public Customer(String custname, String emailId, String custPassword, String custAddress, String custContactNo,
			String custLocation) {
		super();
		this.custname = custname;
		this.emailId = emailId;
		this.custPassword = custPassword;
		this.custAddress = custAddress;
		this.custContactNo = custContactNo;
		this.custLocation = custLocation;
	}

	public String getCustname() {
		return custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getCustPassword() {
		return custPassword;
	}

	public void setCustPassword(String custPassword) {
		this.custPassword = custPassword;
	}

	public String getCustAddress() {
		return custAddress;
	}

	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}

	public String getCustContactNo() {
		return custContactNo;
	}

	public void setCustContactNo(String custContactNo) {
		this.custContactNo = custContactNo;
	}

	public String getCustLocation() {
		return custLocation;
	}

	public void setCustLocation(String custLocation) {
		this.custLocation = custLocation;
	}

	@Override
	public String toString() {
		return "Customer Name: " + custname + ", Email Id: " + emailId + ", Passward: " + custPassword + ", Address: "
				+ custAddress + ", Contact No:" + custContactNo + ", Location :" + custLocation;

	}

}

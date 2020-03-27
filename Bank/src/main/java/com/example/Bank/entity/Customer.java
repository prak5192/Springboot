package com.example.Bank.entity;

public class Customer {
	private String name;
	private int age;
	private String address;
	private String atmNo;
	private Long pinCode;
	private Long bal;
	private String dob;
	private String panNo;

	// Constructors
	
	public Customer() {
		
	}
	public Customer(String name, int age, String address, String atmNo, Long pinCode, Long bal, String dob,
			String panNo) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
		this.atmNo = atmNo;
		this.pinCode = pinCode;
		this.bal = bal;
		this.dob = dob;
		this.panNo = panNo;
	}

	// getters/setters

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAtmNo() {
		return atmNo;
	}

	public void setAtmNo(String atmNo) {
		this.atmNo = atmNo;
	}

	public Long getPinCode() {
		return pinCode;
	}

	public void setPinCode(Long pinCode) {
		this.pinCode = pinCode;
	}

	public Long getBal() {
		return bal;
	}

	public void setBal(Long bal) {
		this.bal = bal;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	// toString

	@Override
	public String toString() {
		return "Customer [name=" + name + ", age=" + age + ", address=" + address + ", atmNo=" + atmNo + ", pinCode="
				+ pinCode + ", bal=" + bal + ", dob=" + dob + ", panNo=" + panNo + "]";
	}

}

package com.example.Bank.dto;

public class UserDto {
	private String name;
	private String dob;
	private String phone;
	private String city;
	private String college;
	private String movie;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getMovie() {
		return movie;
	}
	public void setMovie(String movie) {
		this.movie = movie;
	}
	@Override
	public String toString() {
		return "UserDto [name=" + name + ", dob=" + dob + ", phone=" + phone + ", city=" + city + ", college=" + college
				+ ", movie=" + movie + "]";
	}
	
	
}

package com.example.Bank.dto;

public class ATMDto {
	private String panNo;
	private Long pinCode;
	private Long bal;
	public String getPanNo() {
		return panNo;
	}
	public void setPanNo(String panNo) {
		this.panNo = panNo;
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
	@Override
	public String toString() {
		return "ATMDto [panNo=" + panNo + ", pinCode=" + pinCode + ", bal=" + bal + "]";
	}
	
	
}

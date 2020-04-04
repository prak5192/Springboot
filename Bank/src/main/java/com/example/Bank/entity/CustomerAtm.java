package com.example.Bank.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CustomerAtm {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long custId;
	private String name;
	private int age;
	private String address;
	private String atmNo;
	private Long pinCode;
	private Long bal;
	private String dob;
	private String panNo;
	private Date creationDate;
	private Long  atmPinNo;
	
	
	public CustomerAtm() {
		
	}
	
	public CustomerAtm(String name, String panNo) {
		super();
		this.name = name;
		this.panNo = panNo;
	}
	public CustomerAtm(Long custId, String name, int age, String address, String atmNo, Long pinCode, Long bal,
			String dob, String panNo, Date creationDate, Long atmPinNo) {
		super();
		this.custId = custId;
		this.name = name;
		this.age = age;
		this.address = address;
		this.atmNo = atmNo;
		this.pinCode = pinCode;
		this.bal = bal;
		this.dob = dob;
		this.panNo = panNo;
		this.creationDate = creationDate;
		this.atmPinNo = atmPinNo;
	}

	public Long getCustId() {
		return custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

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

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Long getAtmPinNo() {
		return atmPinNo;
	}

	public void setAtmPinNo(Long atmPinNo) {
		this.atmPinNo = atmPinNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + age;
		result = prime * result + ((atmNo == null) ? 0 : atmNo.hashCode());
		result = prime * result + ((atmPinNo == null) ? 0 : atmPinNo.hashCode());
		result = prime * result + ((bal == null) ? 0 : bal.hashCode());
		result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result + ((custId == null) ? 0 : custId.hashCode());
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((panNo == null) ? 0 : panNo.hashCode());
		result = prime * result + ((pinCode == null) ? 0 : pinCode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerAtm other = (CustomerAtm) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (age != other.age)
			return false;
		if (atmNo == null) {
			if (other.atmNo != null)
				return false;
		} else if (!atmNo.equals(other.atmNo))
			return false;
		if (atmPinNo == null) {
			if (other.atmPinNo != null)
				return false;
		} else if (!atmPinNo.equals(other.atmPinNo))
			return false;
		if (bal == null) {
			if (other.bal != null)
				return false;
		} else if (!bal.equals(other.bal))
			return false;
		if (creationDate == null) {
			if (other.creationDate != null)
				return false;
		} else if (!creationDate.equals(other.creationDate))
			return false;
		if (custId == null) {
			if (other.custId != null)
				return false;
		} else if (!custId.equals(other.custId))
			return false;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (panNo == null) {
			if (other.panNo != null)
				return false;
		} else if (!panNo.equals(other.panNo))
			return false;
		if (pinCode == null) {
			if (other.pinCode != null)
				return false;
		} else if (!pinCode.equals(other.pinCode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CustomerAtm [custId=" + custId + ", name=" + name + ", age=" + age + ", address=" + address + ", atmNo="
				+ atmNo + ", pinCode=" + pinCode + ", bal=" + bal + ", dob=" + dob + ", panNo=" + panNo
				+ ", creationDate=" + creationDate + ", atmPinNo=" + atmPinNo + "]";
	}
	
	
	
	

	
	
	

}

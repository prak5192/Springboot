package com.example.Bank.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Resturant {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "resturant_id", unique = true, nullable = false)
	private Long resturantId;
	
	@Column(name = "rest_name", unique = true, nullable = false)
	private String resturantName;
	
	@ManyToOne
	//@Column(name = "user_id", nullable = false)
	private User user;
	
	public Long getResturantId() {
		return resturantId;
	}
	
	public void setResturantId(Long resturantId) {
		this.resturantId = resturantId;
	}
	
	public String getResturantName() {
		return resturantName;
	}

	public void setResturantName(String resturantName) {
		this.resturantName = resturantName;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((resturantId == null) ? 0 : resturantId.hashCode());
		result = prime * result + ((resturantName == null) ? 0 : resturantName.hashCode());
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
		Resturant other = (Resturant) obj;
		if (resturantId == null) {
			if (other.resturantId != null)
				return false;
		} else if (!resturantId.equals(other.resturantId))
			return false;
		if (resturantName == null) {
			if (other.resturantName != null)
				return false;
		} else if (!resturantName.equals(other.resturantName))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Resturant [resturantId=" + resturantId + ", resturantName=" + resturantName + "]";
	}
	

}

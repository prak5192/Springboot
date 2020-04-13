package com.example.Bank.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transaction {
	private static final long serialVersionUID = -6790693372846798580L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "trans_id", unique = true, nullable = false)
	private Long transId;
	@Column(name = "pan_no", unique = true, nullable = false)
	private String panNo;
	@Column(name = "trans_history", unique = true, nullable = false)
	private Long transHistory;
	@Column(name = "trans_date", unique = true, nullable = false)
	private Date transDate;
	
	public Transaction() {
		
	}
	
	
	public Transaction(String panNo, Long transHistory, Date transDate) {
		super();
		this.panNo = panNo;
		this.transHistory = transHistory;
		this.transDate = transDate;
	}
	public Long getTransId() {
		return transId;
	}
	public void setTransId(Long transId) {
		this.transId = transId;
	}
	public String getPanNo() {
		return panNo;
	}
	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}
	public Long getTransHistory() {
		return transHistory;
	}
	public void setTransHistory(Long transHistory) {
		this.transHistory = transHistory;
	}
	public Date getTransDate() {
		return transDate;
	}
	public void setTransDate(Date transDate) {
		this.transDate = transDate;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		long result = 1;
		result = prime * result + ((panNo == null) ? 0 : panNo.hashCode());
		result = prime * result + ((transDate == null) ? 0 : transDate.hashCode());
		result = prime * result + transHistory;
		result = prime * result + ((transId == null) ? 0 : transId.hashCode());
		return (int) result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		if (panNo == null) {
			if (other.panNo != null)
				return false;
		} else if (!panNo.equals(other.panNo))
			return false;
		if (transDate == null) {
			if (other.transDate != null)
				return false;
		} else if (!transDate.equals(other.transDate))
			return false;
		if (transHistory != other.transHistory)
			return false;
		if (transId == null) {
			if (other.transId != null)
				return false;
		} else if (!transId.equals(other.transId))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Transaction [transId=" + transId + ", panNo=" + panNo + ", transHistory=" + transHistory
				+ ", transDate=" + transDate + "]";
	}
	
	
 
}

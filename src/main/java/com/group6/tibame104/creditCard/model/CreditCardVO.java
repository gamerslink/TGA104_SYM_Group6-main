package com.group6.tibame104.creditCard.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "creditCard")
public class CreditCardVO implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "creditCardID")
	private Integer creditCardID;
	@Column(name = "memberID")
	private Integer memberID;
	@Column(name = "creditCardNumber")
	private String creditCardNumber;
	@Column(name = "securityCode")
	private String securityCode;
	@Column(name = "exDate", columnDefinition = "date")
	private Date exDate;

	public Integer getCreditCardID() {
		return creditCardID;
	}

	public void setCreditCardID(Integer creditCardID) {
		this.creditCardID = creditCardID;
	}

	public Integer getMemberID() {
		return memberID;
	}

	public void setMemberID(Integer memberID) {
		this.memberID = memberID;
	}

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public String getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}

	public Date getExDate() {
		return exDate;
	}

	public void setExDate(Date exDate) {
		this.exDate = exDate;
	}

}

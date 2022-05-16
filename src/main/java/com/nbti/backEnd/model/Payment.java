package com.nbti.backEnd.model;

import java.util.Date;

import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonFormat;

@MappedSuperclass
public abstract class Payment extends NbtiEntity {

	private Double amount;

	@JsonFormat(pattern="yyyy-MM-dd")
	private Date paymentDate;

	private enum Concept {
		MEDICAL, TRANSPORTATION, REPAIRS, WORK_RELATED
	}

	private Concept concept;

//	private NBTIFile receipt;

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date date) {
		this.paymentDate = date;
	}

	public Concept getConcept() {
		return concept;
	}

	public void setConcept(Concept concept) {
		this.concept = concept;
	}

//	public NBTIFile getReceipt() {
//		return receipt;
//	}
//
//	public void setReceipt(NBTIFile receipt) {
//		this.receipt = receipt;
//	}

}

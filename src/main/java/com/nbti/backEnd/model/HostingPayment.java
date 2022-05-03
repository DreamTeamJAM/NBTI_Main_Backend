package com.nbti.backEnd.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "HOSTING_PAYMENT")
public class HostingPayment extends Payment {

	@ManyToOne
	@JoinColumn(name = "hosting_id")
	private Hosting payedHosting;

	public Hosting getPayedHosting() {
		return payedHosting;
	}

	public void setPayedHosting(Hosting payedHosting) {
		this.payedHosting = payedHosting;
	}
}

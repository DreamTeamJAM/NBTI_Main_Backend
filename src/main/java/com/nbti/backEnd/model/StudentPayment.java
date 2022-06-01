package com.nbti.backEnd.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "STUDENT_PAYMENT")
public class StudentPayment extends Payment {

	@ManyToOne
	@JoinColumn(name = "student_id")
	@JsonBackReference(value="studentPayments")
	private Student payedStudent;

	public Student getPayedStudent() {
		return payedStudent;
	}

	public void setPayedStudent(Student payedStudent) {
		this.payedStudent = payedStudent;
	}
}

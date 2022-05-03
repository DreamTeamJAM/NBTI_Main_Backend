package com.nbti.backEnd.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nbti.backEnd.model.StudentPayment;

public interface StudentPaymentRepository extends JpaRepository<StudentPayment, Long> {

}

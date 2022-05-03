package com.nbti.backEnd.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nbti.backEnd.model.HostingPayment;

public interface HostingPaymentRepository extends JpaRepository<HostingPayment, Long> {

}

package com.Payments.examples.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Payments.examples.entity.Invoicee;

@Repository
public interface PaymentRepository extends JpaRepository<Invoicee,Long> {

}

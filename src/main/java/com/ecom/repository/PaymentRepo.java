package com.ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.model.Payment;

public interface PaymentRepo extends JpaRepository<Payment, Integer>  {

}

package com.microservices.payment.Repository;

import com.microservices.payment.model.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Long> {

Optional<Payment>findByTranId(String Id);
List<Payment> findByPatientId(Long id);



}

package com.microservices.patient.proxy;

import com.microservices.patient.model.dto.ResponsePaymentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@FeignClient(name = "PAYMENT-SERVICE" )
public interface PaymentProxy {

    @GetMapping("/payments/get-by-PatientId")
    public ResponseEntity<List<ResponsePaymentDTO>> getPaymentPatient(@RequestHeader Long id);




}

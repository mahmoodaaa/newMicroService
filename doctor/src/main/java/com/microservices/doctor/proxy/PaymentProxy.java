package com.microservices.doctor.proxy;

import com.microservices.doctor.model.dto.AddPaymentDTO;
import com.microservices.doctor.model.dto.ResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "PAYMENT-SERVICE" )
public interface PaymentProxy {

    @GetMapping("/payments/get-payment")
    public ResponseEntity<ResponseDTO> findById(@RequestParam String tranId);


        @PostMapping("/payments/add-payment")
    public ResponseEntity<ResponseDTO> savePayment(@RequestBody AddPaymentDTO paymentDTO) ;


}

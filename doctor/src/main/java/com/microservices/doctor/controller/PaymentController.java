package com.microservices.doctor.controller;

import com.microservices.doctor.model.dto.AddPaymentDTO;
import com.microservices.doctor.model.dto.ResponseDTO;
import com.microservices.doctor.service.PaymentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctor")
public class PaymentController {


    @Autowired
    private PaymentServiceImp paymentServiceImp;

      @GetMapping("/get-payment")
    public ResponseEntity<ResponseDTO> findById(@RequestParam String tranId){

        return this.paymentServiceImp.findById(tranId);

    }
    @PostMapping("/add-payment")
    public ResponseEntity<ResponseDTO> addPayment( AddPaymentDTO paymentDTO) {

        return this.paymentServiceImp.savePayment(paymentDTO);

    }

}

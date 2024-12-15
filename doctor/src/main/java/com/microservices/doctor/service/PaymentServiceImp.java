package com.microservices.doctor.service;

import com.microservices.doctor.model.dto.AddPaymentDTO;
import com.microservices.doctor.model.dto.ResponseDTO;
import com.microservices.doctor.proxy.PaymentProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class PaymentServiceImp {

    @Autowired
    private PaymentProxy paymentProxy;
    public ResponseEntity<ResponseDTO> findById( String tranId){

        return this.paymentProxy.findById(tranId);


    }
    public ResponseEntity<ResponseDTO> savePayment( AddPaymentDTO paymentDTO) {
        return this.paymentProxy.savePayment(paymentDTO);

    }



}

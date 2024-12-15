package com.microservices.patient.service;

import com.microservices.patient.model.dto.ResponsePaymentDTO;
import com.microservices.patient.proxy.PaymentProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@Service
public class PaymentServiceImp {
@Autowired
private PaymentProxy paymentProxy;

    public ResponseEntity<List<ResponsePaymentDTO>> getPaymentPatient(@RequestHeader Long id){

        return this.paymentProxy.getPaymentPatient(id);


    }





}

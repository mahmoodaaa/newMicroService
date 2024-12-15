package com.microservices.payment.controller;

import com.microservices.payment.model.dto.AddPaymentDTO;
import com.microservices.payment.model.dto.ResponseDTO;
import com.microservices.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @PostMapping("/add-payment")
    public ResponseEntity<ResponseDTO> savePayment(@RequestBody AddPaymentDTO paymentDTO) {

        return ResponseEntity.ok(paymentService.addPayment(paymentDTO));
    }


    @GetMapping("/get-payment")
    public ResponseEntity<ResponseDTO> findById(@RequestParam String tranId){

        return  ResponseEntity.ok(paymentService.findByTranId(tranId));
    }

    @GetMapping("/get-by-PatientId")
    public ResponseEntity<List<ResponseDTO>>getPaymentPatient(@RequestHeader Long id){

        return ResponseEntity.ok(paymentService.getPaymentPatient(id));

    }

    @GetMapping("/find-all")
    public ResponseEntity<List<ResponseDTO>> findAll(){

        return ResponseEntity.ok(paymentService.findAll());
    }

    @DeleteMapping("delete-payment")
    public void delete(@RequestParam Long id){
        this.paymentService.deleteById(id);
    }

}

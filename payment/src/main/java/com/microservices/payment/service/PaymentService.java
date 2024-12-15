package com.microservices.payment.service;

import com.microservices.payment.Repository.PaymentRepository;
import com.microservices.payment.exciption.OurExciption;
import com.microservices.payment.model.dto.AddPaymentDTO;
import com.microservices.payment.model.dto.PaymentDTO;
import com.microservices.payment.model.dto.ResponseDTO;
import com.microservices.payment.model.entity.Payment;
import com.microservices.payment.model.mapper.PaymentMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class PaymentService {
@Autowired
private PaymentMapper paymentMapper;
@Autowired
private PaymentRepository paymentRepository;
     public List<ResponseDTO> findAll(){
        try {
            log.info("Get All patients");
            List<Payment> patients = paymentRepository.findAll();
            log.info("get all from repo");
            return patients.stream().map(paymentMapper::toResponseDto).toList();
        }
        catch (Exception ex){
            throw new RuntimeException("no found with id was found in database");
        }
    }
    public ResponseDTO findById(Long id){

        return this.paymentRepository.findById(id)
                .map(paymentMapper::toResponseDto)
                .orElseThrow(()-> new OurExciption("no found with id was found in database"));
    }

    /*   another way 2
             Optional<Patient>patient = patientRepository.findById(id);
          if(patient.isPresent()){

              return patientMapper.toResponseDto(patient.get());
          }
          else{

             ....
          }

           */

    public ResponseDTO findByTranId(String tranId){
        return this.paymentRepository.findByTranId(tranId)
                .map(paymentMapper::toResponseDto)
                .orElseThrow(()-> new OurExciption("no found with Transaction id was found in database"));
    }

    public ResponseDTO addPayment(AddPaymentDTO addPaymentDTO){

        String tranId = UUID.randomUUID().toString();
        PaymentDTO paymentDTO = PaymentDTO.builder()
                .amount(addPaymentDTO.getAmount())
                .patientId(addPaymentDTO.getPatientId())
                .tranId(tranId)
                .build();
        Payment payment = paymentMapper.toEntity(paymentDTO);
        Payment save = paymentRepository.save(payment);
        return paymentMapper.toResponseDto(save);
    }
    public void deleteById(Long id){

        Payment exitingpatient = paymentRepository.findById(id)
                .orElseThrow(()-> new OurExciption("not found id"));
        paymentRepository.deleteById(id);
    }


    public List<ResponseDTO>getPaymentPatient(Long id){
        List<Payment>payments = paymentRepository.findByPatientId(id);
         return paymentMapper.toEntity(payments);

    }



}
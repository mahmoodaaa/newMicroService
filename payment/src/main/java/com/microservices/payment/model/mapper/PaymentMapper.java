package com.microservices.payment.model.mapper;

import com.microservices.payment.model.dto.AddPaymentDTO;
import com.microservices.payment.model.dto.PaymentDTO;
import com.microservices.payment.model.dto.ResponseDTO;
import com.microservices.payment.model.dto.UpdatePaymentDTO;
import com.microservices.payment.model.entity.Payment;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PaymentMapper {


    public Payment toEntity(AddPaymentDTO paymentDTO, String tranId){

        return Payment.builder()
                .amount(paymentDTO.getAmount())
                .patientId(paymentDTO.getPatientId())
                .build();
    }

    public ResponseDTO toResponseDto(Payment payment){
        return ResponseDTO.builder()
                .id(payment.getId())
                .tranId(payment.getTranId())
                .amount(payment.getAmount())
                .patientId(payment.getPatientId())
                .build();
    }
    public List<ResponseDTO> toEntity(List<Payment>payments) {
        return payments.stream()
                .map(payment -> ResponseDTO.builder()
                        .id(payment.getId())
                        .tranId(payment.getTranId())
                        .amount(payment.getAmount())
                        .patientId(payment.getPatientId())
                        .build())
                .collect(Collectors.toList());

    }


    public Payment toEntity(PaymentDTO paymentDTO) {

        return Payment.builder()
                .tranId(paymentDTO.getTranId())
                .amount(paymentDTO.getAmount())
                .patientId(paymentDTO.getPatientId())
                .build();

    }
}

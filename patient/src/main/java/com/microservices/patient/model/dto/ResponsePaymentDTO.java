package com.microservices.patient.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponsePaymentDTO {

    private Long id;
    private String tranId;
    private Double amount;
    private Long patientId;


}

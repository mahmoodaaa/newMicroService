package com.microservices.patient.model.mapper;

import com.microservices.patient.model.dto.AddPatientDTO;
import com.microservices.patient.model.dto.ResponsDTO;
import com.microservices.patient.model.dto.UpdatePatientDTO;
import com.microservices.patient.model.entity.Patient;
import org.springframework.stereotype.Component;

@Component
public class PatientMapper {


     public Patient toEntity(AddPatientDTO patientDTO){

        return Patient.builder()
                 .patientName(patientDTO.getPatientName())
                 .age(patientDTO.getAge())
                 .build();

     }

    public ResponsDTO toResponseDto(Patient patient){

         return ResponsDTO.builder()
                 .id(patient.getId())
                 .patientName(patient.getPatientName())
                 .age(patient.getAge())
                 .build();

    }

     public Patient toEntity(UpdatePatientDTO updatePatientDTO) {

           return Patient.builder()
            .patientName(updatePatientDTO.getPatientName())
            .age(updatePatientDTO.getAge())
            .build();
}




}
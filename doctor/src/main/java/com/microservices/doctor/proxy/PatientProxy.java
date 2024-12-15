package com.microservices.doctor.proxy;

import com.microservices.doctor.model.dto.AddPatientDTO;
import com.microservices.doctor.model.dto.ResponsDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@FeignClient(name = "PATIENT-SERVICE")
public interface PatientProxy {


    @GetMapping("/patients/get-patient")
    public ResponseEntity<ResponsDTO> findById(@RequestParam Long id);

    @PostMapping("/patients/add-patient")
    public ResponseEntity<ResponsDTO> savePatient(@RequestBody AddPatientDTO patientDTO) ;





}

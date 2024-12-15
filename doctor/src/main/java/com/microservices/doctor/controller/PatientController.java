package com.microservices.doctor.controller;

import com.microservices.doctor.model.dto.AddPatientDTO;
import com.microservices.doctor.model.dto.ResponsDTO;
import com.microservices.doctor.service.PatientServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctor")
public class PatientController {
    @Autowired
    private PatientServiceImp patientServiceImp;


    @GetMapping("/get-patient")
    public ResponseEntity<ResponsDTO> getPatientById(@RequestParam Long id){

        return this.patientServiceImp.getPatientById(id);

    }

    @PostMapping("/add-patient")
    public ResponseEntity<ResponsDTO> addPatient(@RequestBody AddPatientDTO patientDTO) {
    return this.patientServiceImp.addPatient(patientDTO);

    }




}

package com.microservices.patient.controller;

import com.microservices.patient.model.dto.AddPatientDTO;
import com.microservices.patient.model.dto.ResponsDTO;
import com.microservices.patient.model.dto.ResponsePaymentDTO;
import com.microservices.patient.model.dto.UpdatePatientDTO;
import com.microservices.patient.model.entity.Patient;
import com.microservices.patient.service.PatientServiceImp;
import com.microservices.patient.service.PaymentServiceImp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/patients")
@Slf4j
public class PatientController {

    @Autowired
    private PatientServiceImp patientService;

    @Autowired
    private PaymentServiceImp paymentServiceImp;

    @GetMapping("/search/{name}")
    public String getName(@PathVariable("name") String name) {
        log.info("new request : " + UUID.randomUUID());
        return this.patientService.getName(name);

    }

    @PostMapping("/add-patient")
    public ResponseEntity<ResponsDTO> savePatient(@RequestBody AddPatientDTO patientDTO) {

        return ResponseEntity.ok(patientService.AddPatient(patientDTO));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponsDTO> update(   @RequestBody UpdatePatientDTO entity,@PathVariable Long id) {

        return ResponseEntity.ok(patientService.UpdatePatient(entity,id));
    }

    @GetMapping("/get-patient")
    public ResponseEntity<ResponsDTO> findById(@RequestParam Long id){

        return  ResponseEntity.ok(patientService.findById(id));
    }

    @GetMapping("/find-all")
    public ResponseEntity<List<ResponsDTO>> findAll(){

        return ResponseEntity.ok(patientService.findAll());
    }

    @DeleteMapping("delete-patient")
    public void delete(@RequestParam Long id){

        this.patientService.deleteById(id);
    }
    @GetMapping("/get-patient-payment")
    public ResponseEntity<List<ResponsePaymentDTO>> getPaymentPatient(@RequestHeader Long id){
        return this.paymentServiceImp.getPaymentPatient(id);


    }
}
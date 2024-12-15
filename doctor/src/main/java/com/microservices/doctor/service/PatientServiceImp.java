package com.microservices.doctor.service;

import com.microservices.doctor.model.dto.AddPatientDTO;
import com.microservices.doctor.model.dto.ResponsDTO;
import com.microservices.doctor.proxy.PatientProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PatientServiceImp {


    @Autowired
    private PatientProxy patientProxy;

    public ResponseEntity<ResponsDTO> getPatientById(Long id){

        return this.patientProxy.findById(id);

    }

    public ResponseEntity<ResponsDTO> addPatient( AddPatientDTO patientDTO) {

             return this.patientProxy.savePatient(patientDTO);


    }


}

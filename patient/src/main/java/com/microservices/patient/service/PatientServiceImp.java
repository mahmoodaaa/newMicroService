package com.microservices.patient.service;

import com.microservices.patient.exciption.OurExciption;
import com.microservices.patient.model.dto.AddPatientDTO;
import com.microservices.patient.model.dto.ResponsDTO;
import com.microservices.patient.model.dto.UpdatePatientDTO;
import com.microservices.patient.model.entity.Patient;
import com.microservices.patient.model.mapper.PatientMapper;
import com.microservices.patient.repository.PatientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PatientServiceImp {


    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private PatientMapper patientMapper;

    private List<String> names = Arrays.asList("Ahmad", "Abd", "Khaled");

    public String getName(String name) {
        return names.stream().filter(n -> n.equals(name))
                .findAny().orElse("No patient found!");


    }



    public List<ResponsDTO>findAll(){
try {
    log.info("Get All patients");
    List<Patient> patients = patientRepository.findAll();
    log.info("get all from repo");
    return patients.stream().map(patientMapper::toResponseDto).toList();
}
catch (Exception ex){

    throw new RuntimeException("no found with id was found in database");
}

    }


    public ResponsDTO findById(Long id){

             return this.patientRepository.findById(id)
                .map(patientMapper::toResponseDto)
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
     public ResponsDTO AddPatient(AddPatientDTO addPatientDTO){

         Patient patient = patientMapper.toEntity(addPatientDTO);

         Patient save = patientRepository.save(patient);

         return patientMapper.toResponseDto(save);


     }


    public ResponsDTO UpdatePatient(UpdatePatientDTO updatePatientDTO ,Long id){

       Patient exitingpatient = patientRepository.findById(id)
               .orElseThrow(()-> new OurExciption("not found id"));

            exitingpatient.setPatientName(updatePatientDTO.getPatientName());
            exitingpatient.setAge(updatePatientDTO.getAge());

            Patient save = patientRepository.save(exitingpatient);
             return patientMapper.toResponseDto(save);

    }

    public void deleteById(Long id){

        Patient exitingpatient = patientRepository.findById(id)
                .orElseThrow(()-> new OurExciption("not found id"));
        patientRepository.deleteById(id);

    }





}
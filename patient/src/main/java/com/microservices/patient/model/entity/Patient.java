package com.microservices.patient.model.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "patients")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Patient {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "patient_id")
    private Long id;
    @Column(name = "patient_name")
    private String patientName;
    private Integer age;






}

package com.appointment.doctor_appointment.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "appointment")
public class Appointment extends BaseEntity {

    private LocalDate date;
    private LocalTime time;

    private String status;
    @ManyToOne
    private OurUser doctor;

    @ManyToOne
    private OurUser patient;


}

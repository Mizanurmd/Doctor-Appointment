package com.appointment.doctor_appointment.controller;

import com.appointment.doctor_appointment.model.Appointment;
import com.appointment.doctor_appointment.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class appointmentController {
    private final AppointmentService appointmentService;

    @Autowired
    public appointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping("/book")
    public ResponseEntity<Appointment>saveAppointment(@RequestBody Appointment appointment) {
            Appointment saveAppointment = appointmentService.addAppointment(appointment);
            return new ResponseEntity<>(saveAppointment, HttpStatus.CREATED);
    }

    @GetMapping("/doctor/{id}")
    public ResponseEntity<List<Appointment>>getByDoctorId(@PathVariable("id") Long doctorId) {
        List<Appointment>getAllList = appointmentService.getAllAppointmentsByDoctor(doctorId);
        return new ResponseEntity<>(getAllList, HttpStatus.OK);


    }
    @GetMapping("/patient/{id}")
    public ResponseEntity<List<Appointment>>getByPatientId(@PathVariable("id") Long patientId) {
        List<Appointment>getAllList = appointmentService.getAllAppointmentsByDoctor(patientId);
        return new ResponseEntity<>(getAllList, HttpStatus.OK);


    }

}

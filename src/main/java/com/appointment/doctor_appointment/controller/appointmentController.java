package com.appointment.doctor_appointment.controller;

import com.appointment.doctor_appointment.dto.AppointmentRequest;
import com.appointment.doctor_appointment.model.Appointment;
import com.appointment.doctor_appointment.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/appointments")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class appointmentController {
    private final AppointmentService appointmentService;

    @Autowired
    public appointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping("/book")
    public ResponseEntity<Appointment> saveAppointment(@RequestBody AppointmentRequest appointment) {
        Appointment saveAppointment = appointmentService.bookAppointment(appointment);
        System.out.println("Booking Data ==================" + saveAppointment);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveAppointment);
    }

    @GetMapping("/doctor/{id}")
    public ResponseEntity<List<Appointment>> getByDoctorId(@PathVariable("id") Long doctorId) {
        List<Appointment> getAllList = appointmentService.getAppointmentsForDoctor(doctorId);
        return new ResponseEntity<>(getAllList, HttpStatus.OK);


    }

    @GetMapping("/patient/{id}")
    public ResponseEntity<List<Appointment>> getByPatientId(@PathVariable("id") Long patientId) {
        List<Appointment> getAllList = appointmentService.getAppointmentsForPatient(patientId);
        return new ResponseEntity<>(getAllList, HttpStatus.OK);
    }

}

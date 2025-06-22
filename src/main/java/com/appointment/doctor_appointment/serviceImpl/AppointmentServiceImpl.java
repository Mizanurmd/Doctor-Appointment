package com.appointment.doctor_appointment.serviceImpl;

import com.appointment.doctor_appointment.dto.AppointmentRequest;
import com.appointment.doctor_appointment.model.Appointment;
import com.appointment.doctor_appointment.model.OurUser;
import com.appointment.doctor_appointment.repository.AppointmentRepository;
import com.appointment.doctor_appointment.repository.OurUserRepository;
import com.appointment.doctor_appointment.service.AppointmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final OurUserRepository ourUserRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository, OurUserRepository ourUserRepository) {
        this.appointmentRepository = appointmentRepository;
        this.ourUserRepository = ourUserRepository;
    }

    @Override
    public Appointment bookAppointment(AppointmentRequest request) {
        // Step 1: Fetch Doctor and Patient from DB
        OurUser doctor = ourUserRepository.findById(request.doctorId())
                .orElseThrow(() -> new RuntimeException("Doctor not found with ID: " + request.doctorId()));

        OurUser patient = ourUserRepository.findById(request.patientId())
                .orElseThrow(() -> new RuntimeException("Patient not found with ID: " + request.patientId()));
        // Example: prevent double booking at same time
        boolean alreadyBooked = appointmentRepository.existsByDoctorAndDateAndTime(doctor, request.date(), request.time());
        if (alreadyBooked) {
            throw new RuntimeException("Doctor already has an appointment at this time.");
        }

        // Step 3: Save appointment
        Appointment appointment = new Appointment();
        appointment.setDate(request.date());
        appointment.setTime(request.time());
        appointment.setStatus(request.status());
        appointment.setDoctor(doctor);
        appointment.setPatient(patient);

        return appointmentRepository.save(appointment);
    }

    @Override
    public List<Appointment> getAppointmentsForDoctor(Long doctorId) {
        return appointmentRepository.findByDoctorId(doctorId);
    }

    @Override
    public List<Appointment> getAppointmentsForPatient(Long patientId) {
        return appointmentRepository.findByPatientId(patientId);
    }
}

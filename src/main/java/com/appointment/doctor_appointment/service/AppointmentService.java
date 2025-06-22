package com.appointment.doctor_appointment.service;

import com.appointment.doctor_appointment.dto.AppointmentRequest;
import com.appointment.doctor_appointment.model.Appointment;
import com.appointment.doctor_appointment.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AppointmentService {
    Appointment bookAppointment(AppointmentRequest request);

    List<Appointment> getAppointmentsForDoctor(Long doctorId);

    List<Appointment> getAppointmentsForPatient(Long patientId);
}

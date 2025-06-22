package com.appointment.doctor_appointment.repository;

import com.appointment.doctor_appointment.model.Appointment;
import com.appointment.doctor_appointment.model.OurUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    boolean existsByDoctorAndDateAndTime(OurUser doctor, LocalDate date, LocalTime time);

    List<Appointment> findByDoctorId(Long doctorId);

    List<Appointment> findByPatientId(Long patientId);
}

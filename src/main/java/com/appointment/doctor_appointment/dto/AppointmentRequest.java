package com.appointment.doctor_appointment.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public record AppointmentRequest(
        LocalDate date,
        LocalTime time,
        String status,
        Long doctorId,
        Long patientId
) {

}

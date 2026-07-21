package com.appoiment.service;

import java.util.List;

import com.appoiment.model.Appointment;

public interface AppointmentService {

    List<Appointment> getAllAppointments();
    Appointment getAppoimentById(Long id);
    Appointment createAppointment(Appointment appointment);
    Appointment updateAppointment(Long id, Appointment appointment);
    Appointment deleteAppointment (Long id);



    
}

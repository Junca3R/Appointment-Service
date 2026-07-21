package com.appoiment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.appoiment.model.Appointment;
import com.appoiment.repository.AppointmentRepository;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Service
@Data
@RequiredArgsConstructor
public class  AppointmentServiceimpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;

    @Override
    public List <Appointment> getAllAppointments (){
        return appointmentRepository.findAll();
    }

    @Override
    public  Appointment getAppoimentById(Long id){
        return appointmentRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("cita no encontrado con ID: " + id));
    }

    @Override
    public Appointment createAppointment (Appointment appointment){
        return appointmentRepository.save(appointment);
    }

    @Override
    public Appointment updateAppointment (Long id, Appointment appointment){
        Appointment existingAppointment = appointmentRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + id));

        existingAppointment.setAppointmentDate(appointment.getAppointmentDate());

        return appointmentRepository.save(appointment);

    }

    @Override
    public Appointment deleteAppointment(Long id){
        Appointment existingAppointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + id));
        
        appointmentRepository.delete(existingAppointment);
        return existingAppointment;}
    }


    
    



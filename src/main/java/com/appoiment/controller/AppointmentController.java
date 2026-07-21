package com.appoiment.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appoiment.model.Appointment;
import com.appoiment.service.AppointmentService;

import lombok.RequiredArgsConstructor;






@RestController
@RequiredArgsConstructor
@RequestMapping("/api/appointments")
public class AppointmentController {

  private final AppointmentService appointmentService;

  @GetMapping()
  public ResponseEntity<List<Appointment>> getAllAppointments(){
    return ResponseEntity.ok(appointmentService.getAllAppointments());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Appointment> getAppoimentById(@PathVariable long id){
    return ResponseEntity.ok(appointmentService.getAppoimentById(id));
  }
  
  
  

  @PostMapping
  public ResponseEntity<Appointment>createAppointment(@RequestBody Appointment appointment){

    return ResponseEntity.status(HttpStatus.CREATED).body(appointmentService.createAppointment(appointment));



  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Appointment>deleteAppointment(@PathVariable Long id){
    return ResponseEntity.ok(appointmentService.deleteAppointment(id));
  }


  
  
}
  
  

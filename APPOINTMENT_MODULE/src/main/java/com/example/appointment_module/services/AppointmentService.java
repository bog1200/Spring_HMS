package com.example.appointment_module.services;import com.example.appointment_module.domain.Appointment;import java.util.List;import java.util.Optional;public interface AppointmentService {    List<Appointment> findAll();    Optional<Appointment> findById(Long id);    Appointment save(Appointment appointment);    Appointment update(Appointment appointment);    void delete(Long id);}
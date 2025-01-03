package com.example.appointment_module.services;import com.example.appointment_module.domain.Appointment;import java.util.List;import java.util.Optional;import java.util.Set;public interface AppointmentService {    List<Appointment> findAll();    Optional<Appointment> findById(Long id);    Optional<Set<Appointment>> findStartingAppointments();    Appointment save(Appointment appointment);    Appointment update(Appointment appointment);    void delete(Long id);    Set<Appointment> findByPatientId(Long id);    Set<Appointment> findByDoctorId(Long id);}
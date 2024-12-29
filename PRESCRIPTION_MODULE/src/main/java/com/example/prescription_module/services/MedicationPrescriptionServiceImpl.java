package com.example.prescription_module.services;import com.example.prescription_module.domain.MedicationPrescription;import com.example.prescription_module.repositories.MedicationPrescriptionRepository;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Service;import java.util.List;import java.util.Optional;@Servicepublic class MedicationPrescriptionServiceImpl implements MedicationPrescriptionService {    @Autowired    private MedicationPrescriptionRepository medicationPrescriptionRepository;    @Override    public List<MedicationPrescription> findAll() {        return (List<MedicationPrescription>) medicationPrescriptionRepository.findAll();    }    @Override    public Optional<MedicationPrescription> findById(Long id) {        return medicationPrescriptionRepository.findById(id);    }    @Override    public MedicationPrescription save(MedicationPrescription medicationPrescription) {        return medicationPrescriptionRepository.save(medicationPrescription);    }    @Override    public MedicationPrescription update(MedicationPrescription medicationPrescription) {        return medicationPrescriptionRepository.save(medicationPrescription);    }    @Override    public void delete(Long id) {        medicationPrescriptionRepository.deleteById(id);    }}
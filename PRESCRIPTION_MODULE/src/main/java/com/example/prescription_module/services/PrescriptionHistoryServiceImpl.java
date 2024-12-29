package com.example.prescription_module.services;import com.example.prescription_module.domain.PrescriptionHistory;import com.example.prescription_module.repositories.PrescriptionHistoryRepository;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Service;import java.util.List;import java.util.Optional;@Servicepublic class PrescriptionHistoryServiceImpl implements PrescriptionHistoryService {    @Autowired    private PrescriptionHistoryRepository prescriptionHistoryRepository;    @Override    public List<PrescriptionHistory> findAll() {        return (List<PrescriptionHistory>) prescriptionHistoryRepository.findAll();    }    @Override    public Optional<PrescriptionHistory> findById(Long id) {        return prescriptionHistoryRepository.findById(id);    }    @Override    public PrescriptionHistory save(PrescriptionHistory prescriptionHistory) {        return prescriptionHistoryRepository.save(prescriptionHistory);    }    @Override    public PrescriptionHistory update(PrescriptionHistory prescriptionHistory) {        return prescriptionHistoryRepository.save(prescriptionHistory);    }    @Override    public void delete(Long id) {        prescriptionHistoryRepository.deleteById(id);    }}
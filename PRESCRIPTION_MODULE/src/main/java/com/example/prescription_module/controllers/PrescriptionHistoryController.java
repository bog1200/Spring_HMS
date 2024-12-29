package com.example.prescription_module.controllers;import com.example.prescription_module.domain.PrescriptionHistory;import com.example.prescription_module.services.PrescriptionHistoryService;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.http.ResponseEntity;import org.springframework.web.bind.annotation.*;import java.util.List;@RestController@RequestMapping("/prescription-histories")public class PrescriptionHistoryController {    private final PrescriptionHistoryService prescriptionHistoryService;    @Autowired    public PrescriptionHistoryController(PrescriptionHistoryService prescriptionHistoryService) {        this.prescriptionHistoryService = prescriptionHistoryService;    }    @GetMapping("/")    public ResponseEntity<List<PrescriptionHistory>> getAllPrescriptionHistories() {        return ResponseEntity.ok(prescriptionHistoryService.findAll());    }    @GetMapping("/{id}")    public ResponseEntity<PrescriptionHistory> getPrescriptionHistoryById(@PathVariable Long id) {        return prescriptionHistoryService.findById(id)                .map(ResponseEntity::ok)                .orElseGet(() -> ResponseEntity.notFound().build());    }    @PostMapping("/")    public ResponseEntity<PrescriptionHistory> createPrescriptionHistory(@RequestBody PrescriptionHistory prescriptionHistory) {        return ResponseEntity.ok(prescriptionHistoryService.save(prescriptionHistory));    }    @PutMapping("/{id}")    public ResponseEntity<PrescriptionHistory> updatePrescriptionHistory(@PathVariable Long id, @RequestBody PrescriptionHistory prescriptionHistory) {        prescriptionHistory.setId(id);        return ResponseEntity.ok(prescriptionHistoryService.update(prescriptionHistory));    }    @DeleteMapping("/{id}")    public ResponseEntity<Void> deletePrescriptionHistory(@PathVariable Long id) {        prescriptionHistoryService.delete(id);        return ResponseEntity.noContent().build();    }}
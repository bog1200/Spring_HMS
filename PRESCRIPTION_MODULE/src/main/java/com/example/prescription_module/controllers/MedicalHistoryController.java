package com.example.prescription_module.controllers;import com.example.prescription_module.domain.MedicalHistory;import com.example.prescription_module.services.MedicalHistoryService;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.http.ResponseEntity;import org.springframework.web.bind.annotation.*;import java.util.List;@RestController@RequestMapping("/medical-histories")public class MedicalHistoryController {    private final MedicalHistoryService medicalHistoryService;    @Autowired    public MedicalHistoryController(MedicalHistoryService medicalHistoryService) {        this.medicalHistoryService = medicalHistoryService;    }    @GetMapping("/")    public ResponseEntity<List<MedicalHistory>> getAllMedicalHistories() {        return ResponseEntity.ok(medicalHistoryService.findAll());    }    @GetMapping("/{id}")    public ResponseEntity<MedicalHistory> getMedicalHistoryById(@PathVariable Long id) {        return medicalHistoryService.findById(id)                .map(ResponseEntity::ok)                .orElseGet(() -> ResponseEntity.notFound().build());    }    @PostMapping("/")    public ResponseEntity<MedicalHistory> createMedicalHistory(@RequestBody MedicalHistory medicalHistory) {        return ResponseEntity.ok(medicalHistoryService.save(medicalHistory));    }    @PutMapping("/{id}")    public ResponseEntity<MedicalHistory> updateMedicalHistory(@PathVariable Long id, @RequestBody MedicalHistory medicalHistory) {        medicalHistory.setId(id);        return ResponseEntity.ok(medicalHistoryService.update(medicalHistory));    }    @DeleteMapping("/{id}")    public ResponseEntity<Void> deleteMedicalHistory(@PathVariable Long id) {        medicalHistoryService.delete(id);        return ResponseEntity.noContent().build();    }}
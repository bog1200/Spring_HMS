package com.example.prescription_module.domain;import jakarta.persistence.*;import lombok.Getter;import lombok.Setter;@Entity@Getter@Setterpublic class Medical_History {    @Id    @GeneratedValue(strategy = GenerationType.IDENTITY)    private Long id;    private Long idPatient;    private String disease;    public Medical_History() {    }    public Medical_History(Long id, Long idPatient, String disease) {        this.idPatient = idPatient;        this.disease = disease;    }}
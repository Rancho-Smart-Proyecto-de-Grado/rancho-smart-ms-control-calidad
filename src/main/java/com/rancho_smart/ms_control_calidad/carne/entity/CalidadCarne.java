package com.rancho_smart.ms_control_calidad.carne.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CALIDAD_CARNE")
public class CalidadCarne {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCalidadCarne;

    @Column(name = "ID_ANIMAL")
    private Long idAnimal; 

    @Column(name = "OBSERVACIONES")
    private String observaciones;

    @Column(name = "RESULTADO_FINAL")
    private String resultadoFinal;

    @Column(name = "ID_LOTE")
    private Long idLote;

    @Column(name = "ID_FINCA")
    private Long idFinca;

    public CalidadCarne() {
    }

    public CalidadCarne(Long idAnimal, String observaciones, String resultadoFinal, Long idLote, Long idFinca) {
        this.idAnimal = idAnimal;
        this.observaciones = observaciones;
        this.resultadoFinal = resultadoFinal;
        this.idLote = idLote;
        this.idFinca = idFinca;
    }
    
    public Long getIdLote() {
        return idLote;
    }

    public void setIdLote(Long idLote) {
        this.idLote = idLote;
    }

    public Long getIdFinca() {
        return idFinca;
    }

    public void setIdFinca(Long idFinca) {
        this.idFinca = idFinca;
    }

    public Long getIdCalidadCarne() {
        return idCalidadCarne;
    }

    public void setIdCalidadCarne(Long idCalidadCarne) {
        this.idCalidadCarne = idCalidadCarne;
    }

    public Long getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(Long idAnimal) {
        this.idAnimal = idAnimal;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getResultadoFinal() {
        return resultadoFinal;
    }

    public void setResultadoFinal(String resultadoFinal) {
        this.resultadoFinal = resultadoFinal;
    }

    
}

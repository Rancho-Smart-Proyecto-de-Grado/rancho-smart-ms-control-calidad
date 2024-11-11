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

    @Column(name = "OBSERVACIONES")
    private String observaciones;

    @Column(name = "RESULTADO_FINAL")
    private String resultadoFinal;

    @Column(name = "ID_PRODUCCION_CARNE")
    private Long idProduccionCarne;

    public CalidadCarne() {
    }

    public CalidadCarne(String observaciones, String resultadoFinal, Long idProduccionCarne) {
        this.observaciones = observaciones;
        this.resultadoFinal = resultadoFinal;
        this.idProduccionCarne = idProduccionCarne;
    }

    public Long getIdCalidadCarne() {
        return idCalidadCarne;
    }

    public void setIdCalidadCarne(Long idCalidadCarne) {
        this.idCalidadCarne = idCalidadCarne;
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



    public Long getIdProduccionCarne() {
        return idProduccionCarne;
    }



    public void setIdProduccionCarne(Long idProduccionCarne) {
        this.idProduccionCarne = idProduccionCarne;
    }

    
}

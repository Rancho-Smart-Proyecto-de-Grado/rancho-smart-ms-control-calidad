package com.rancho_smart.ms_control_calidad.carne.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rancho_smart.ms_control_calidad.carne.entity.CalidadCarne;
import com.rancho_smart.ms_control_calidad.carne.repository.CalidadCarneRepository;

@Service
public class CalidadCarneService {

    @Autowired
    private CalidadCarneRepository calidadCarneRepository;

    public List<CalidadCarne> getCalidadesCarne() {
        return this.calidadCarneRepository.findAll();
    }

    public Optional<CalidadCarne> getCalidadCarneById(Long id) {
        return this.calidadCarneRepository.findById(id);
    }

    public CalidadCarne saveCalidadCarne(CalidadCarne calidadCarne) {
        return this.calidadCarneRepository.save(calidadCarne);
    }

    public void deleteCalidadCarne(Long id) {
        this.calidadCarneRepository.deleteById(id);
    }
}

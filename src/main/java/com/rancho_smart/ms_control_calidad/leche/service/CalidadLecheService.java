package com.rancho_smart.ms_control_calidad.leche.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rancho_smart.ms_control_calidad.leche.entity.CalidadLeche;
import com.rancho_smart.ms_control_calidad.leche.repository.CalidadLecheRepository;

@Service
public class CalidadLecheService {

    @Autowired
    private CalidadLecheRepository calidadLecheRepository;

    public List<CalidadLeche> getCalidadesLeche() {
        return this.calidadLecheRepository.findAll();
    }

    public Optional<CalidadLeche> getCalidadLecheById(Long id) {
        return this.calidadLecheRepository.findById(id);
    }

    public CalidadLeche saveCalidadLeche(CalidadLeche calidadLeche) {
        return this.calidadLecheRepository.save(calidadLeche);
    }

    public void deleteCalidadLeche(Long id) {
        this.calidadLecheRepository.deleteById(id);
    }
}

package com.rancho_smart.ms_control_calidad.leche.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rancho_smart.ms_control_calidad.leche.entity.CalidadLeche;
import java.util.List;


@Repository
public interface CalidadLecheRepository extends JpaRepository<CalidadLeche, Long>{
    public List<CalidadLeche> findByIdProduccionLeche(Long idProduccionLeche);
}

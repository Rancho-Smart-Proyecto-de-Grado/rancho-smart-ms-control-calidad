package com.rancho_smart.ms_control_calidad.carne.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rancho_smart.ms_control_calidad.carne.entity.CalidadCarne;
import java.util.List;


@Repository
public interface CalidadCarneRepository extends JpaRepository<CalidadCarne, Long>{
    public List<CalidadCarne> findByIdProduccionCarne(Long idProduccionCarne);
}

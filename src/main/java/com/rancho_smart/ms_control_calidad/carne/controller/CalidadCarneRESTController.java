package com.rancho_smart.ms_control_calidad.carne.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rancho_smart.ms_control_calidad.carne.entity.CalidadCarne;
import com.rancho_smart.ms_control_calidad.carne.service.CalidadCarneService;

@RestController
@RequestMapping(path = "/calidades-carne")
public class CalidadCarneRESTController {

    @Autowired
    private CalidadCarneService calidadCarneService;

    @GetMapping
    public ResponseEntity<List<CalidadCarne>> getAllCalidadesCarne() {
        List<CalidadCarne> listado = this.calidadCarneService.getCalidadesCarne();
        return new ResponseEntity<>(listado, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CalidadCarne> getCalidadCarneById(@PathVariable Long id) {
        Optional<CalidadCarne> calidadCarne = this.calidadCarneService.getCalidadCarneById(id);
        return calidadCarne.map(ResponseEntity::ok)
                           .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/produccion-carne/{idProduccionCarne}")
    public ResponseEntity<List<CalidadCarne>> getCalidadesCarneByIdProduccionCarne(@PathVariable Long idProduccionCarne){
        List<CalidadCarne> calidadesProduccionCarne = this.calidadCarneService.getCalidadesCarneByIdProduccionCarne(idProduccionCarne);
        if(calidadesProduccionCarne.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(calidadesProduccionCarne, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<CalidadCarne> saveCalidadCarne(@RequestBody CalidadCarne calidadCarne) {
        CalidadCarne calidadCarneCreada = this.calidadCarneService.saveCalidadCarne(calidadCarne);
        return new ResponseEntity<>(calidadCarneCreada, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CalidadCarne> updateCalidadCarne(@PathVariable Long id, @RequestBody CalidadCarne calidadCarne) {
        if (!this.calidadCarneService.getCalidadCarneById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            calidadCarne.setIdCalidadCarne(id);
            CalidadCarne calidadCarneActualizada = this.calidadCarneService.saveCalidadCarne(calidadCarne);
            return new ResponseEntity<>(calidadCarneActualizada, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCalidadCarne(@PathVariable Long id) {
        if (!this.calidadCarneService.getCalidadCarneById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            this.calidadCarneService.deleteCalidadCarne(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}

package com.rancho_smart.ms_control_calidad.leche.controller;

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

import com.rancho_smart.ms_control_calidad.leche.entity.CalidadLeche;
import com.rancho_smart.ms_control_calidad.leche.service.CalidadLecheService;

@RestController
@RequestMapping(path = "/calidades-leche")
public class CalidadLecheRESTController {

    @Autowired
    private CalidadLecheService calidadLecheService;

    @GetMapping
    public ResponseEntity<List<CalidadLeche>> getAllCalidadesLeche() {
        List<CalidadLeche> listado = this.calidadLecheService.getCalidadesLeche();
        return new ResponseEntity<>(listado, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CalidadLeche> getCalidadLecheById(@PathVariable Long id) {
        Optional<CalidadLeche> calidadLeche = this.calidadLecheService.getCalidadLecheById(id);
        return calidadLeche.map(ResponseEntity::ok)
                           .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/produccion-leche/{idProduccionLeche}")
    public ResponseEntity<List<CalidadLeche>> getCalidadesLecheByIdProduccionLeche(@PathVariable Long idProduccionLeche){
        List<CalidadLeche> calidadesProduccionLeche = this.calidadLecheService.getCalidadesLecheByIdProduccionLeche(idProduccionLeche);
        if(calidadesProduccionLeche.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(calidadesProduccionLeche, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<CalidadLeche> saveCalidadLeche(@RequestBody CalidadLeche calidadLeche) {
        CalidadLeche calidadLecheCreada = this.calidadLecheService.saveCalidadLeche(calidadLeche);
        return new ResponseEntity<>(calidadLecheCreada, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CalidadLeche> updateCalidadLeche(@PathVariable Long id, @RequestBody CalidadLeche calidadLeche) {
        if (!this.calidadLecheService.getCalidadLecheById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            calidadLeche.setIdCalidadLeche(id);
            CalidadLeche calidadLecheActualizada = this.calidadLecheService.saveCalidadLeche(calidadLeche);
            return new ResponseEntity<>(calidadLecheActualizada, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCalidadLeche(@PathVariable Long id) {
        if (!this.calidadLecheService.getCalidadLecheById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            this.calidadLecheService.deleteCalidadLeche(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}

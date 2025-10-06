package com.proyecto.notificaciones.controller;
import com.proyecto.notificaciones.model.Notificacion;
import com.proyecto.notificaciones.repository.NotificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/notificaciones")
public class NotificacionController {

    @Autowired
    private NotificacionRepository notificacionRepository;

    // Endpoint para que otros servicios nos envíen notificaciones
    @PostMapping
    public ResponseEntity<Notificacion> crearNotificacion(@RequestBody Notificacion notificacion) {
        notificacion.setFecha(LocalDateTime.now());
        notificacion.setLeida(false);
        Notificacion nuevaNotificacion = notificacionRepository.save(notificacion);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaNotificacion);
    }

    // Endpoint para que el front (tu app de Kotlin) pueda leer las notificaciones
    @GetMapping
    public ResponseEntity<List<Notificacion>> obtenerNotificaciones() {
        List<Notificacion> notificaciones = notificacionRepository.findAll();
        return ResponseEntity.ok(notificaciones);
    }
}
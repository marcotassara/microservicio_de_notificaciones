package com.proyecto.notificaciones.model;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "NOTIFICACIONES")
public class Notificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "notificacion_seq")
    @SequenceGenerator(name = "notificacion_seq", sequenceName = "NOTIFICACION_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "MENSAJE", nullable = false, length = 500)
    private String mensaje;

    @Column(name = "FECHA", nullable = false)
    private LocalDateTime fecha;

    @Column(name = "LEIDA", nullable = false)
    private boolean leida = false;
}
package co.edu.uniquindio.prohospi.Model;

import java.time.LocalDateTime;

public class Notificacion {
    private String mensaje;
    private Persona persona;
    private LocalDateTime fecha; // importa java.time.LocalDateTime

    public Notificacion(String mensaje, Persona persona) {
        this.mensaje = mensaje;
        this.persona = persona;
        this.fecha = LocalDateTime.now();
    }

    public String getMensaje() {
        return mensaje;
    }

    public Persona getPersona() {
        return persona;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        return "[" + fecha + "] " + persona.getNombre() + ": " + mensaje;
    }
}
package co.edu.uniquindio.prohospi.Controller;

import co.edu.uniquindio.prohospi.Model.Notificacion;
import co.edu.uniquindio.prohospi.Model.NotificacionService;
import co.edu.uniquindio.prohospi.Model.Persona;

import java.time.LocalDateTime;

public class CitasController {
    public void confirmarCita(Persona persona) {
        // Crear la notificación
        Notificacion notificacion = new Notificacion("Tu cita fue confirmada", persona);

        // Guardarla en el servicio
        NotificacionService.agregar(notificacion);

        // (opcional) Imprimirla
        System.out.println("Notificación creada: " + notificacion);
    }

}

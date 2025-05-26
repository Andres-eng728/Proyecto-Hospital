import co.edu.uniquindio.prohospi.Model.Medico;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;

public class TestMedico {

    @Test
    public void testVerNotificaciones() {
        Medico medico = new Medico("1", "Dr. Pérez", "perez@hospital.com", "Cardiología","aasf","2414");

        // Agregar algunas notificaciones
        medico.getNotificaciones().add("Cambio en cita: Nueva hora 10:00 AM");
        medico.getNotificaciones().add("Recordatorio: Consulta con Juan López mañana.");
        medico.getNotificaciones().add("Urgente: Nuevo paciente asignado.");

        List<String> notificacionesAntes = medico.getNotificaciones();
        Assertions.assertEquals(3, notificacionesAntes.size(), "Debe haber 3 notificaciones antes de verlas.");

        medico.verNotificaciones();

        List<String> notificacionesDespues = medico.getNotificaciones();
        Assertions.assertTrue(notificacionesDespues.isEmpty(), "Después de ver las notificaciones, la lista debe estar vacía.");

        System.out.println("Todas las pruebas han pasado correctamente");
    }
}

import co.edu.uniquindio.prohospi.Model.CitaMedica;
import co.edu.uniquindio.prohospi.Model.Medico;
import co.edu.uniquindio.prohospi.Model.Paciente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

public class TestCitaMedica {

    @Test
    public void testDetallesCita() {
        // Crear médico y paciente con datos correctos
        Medico medico = new Medico("1", "Dr. Pérez", "perez@hospital.com", "Cardiología","aasf","2414");
        Paciente paciente = new Paciente("101", "Juan López", "juan@correo.com","214","afsaf");

        // Definir fecha y hora de la cita
        LocalDateTime fechaCita = LocalDateTime.of(2025, 5, 10, 14, 30);

        // Crear la cita médica con datos correctos
        CitaMedica cita = new CitaMedica(fechaCita, paciente, medico);

        // Confirmar que la cita se asignó correctamente
        Assertions.assertEquals(fechaCita, cita.getFechaHora(), "La fecha y hora de la cita deben coincidir.");
        Assertions.assertEquals(paciente, cita.getPaciente(), "El paciente asignado a la cita debe coincidir.");
        Assertions.assertEquals(medico, cita.getMedico(), "El médico asignado a la cita debe coincidir.");

        // Confirmar que `detallesCita()` devuelve la información correcta
        String esperado = "Cita con " + medico.getNombre() + " para " + paciente.getNombre() + " el " + fechaCita.toString();
        Assertions.assertEquals(esperado, cita.detallesCita(), "El formato del detalle de la cita debe ser correcto.");

        // **Mensaje de confirmación**
        System.out.println("Todas las pruebas han pasado correctamente");
    }
}

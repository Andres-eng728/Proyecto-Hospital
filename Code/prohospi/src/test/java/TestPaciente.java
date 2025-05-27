import co.edu.uniquindio.prohospi.Model.CitaMedica;
import co.edu.uniquindio.prohospi.Model.Medico;
import co.edu.uniquindio.prohospi.Model.Paciente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class TestPaciente {

    @Test
    public void testGetCitasProgramadas() {

        Paciente paciente = new Paciente("101", "Juan López", "juan@correo.com", "214","afsaf");

        Medico medico = new Medico("1", "Dr. Pérez", "perez@hospital.com", "Cardiología","aasf","2414");

        CitaMedica cita1 = new CitaMedica(LocalDate.of(2020,05,12),"12","medico1");
        CitaMedica cita2 = new CitaMedica(LocalDate.of(2020,05,13),"13","medico2");

        paciente.getCitasProgramadas().add(cita1);
        paciente.getCitasProgramadas().add(cita2);

        List<CitaMedica> citas = paciente.getCitasProgramadas();

        Assertions.assertEquals(2, citas.size(), "Debe haber 2 citas médicas programadas.");
        Assertions.assertTrue(citas.contains(cita1), "El paciente debe tener la cita 1 registrada.");
        Assertions.assertTrue(citas.contains(cita2), "El paciente debe tener la cita 2 registrada.");

       
    }
}

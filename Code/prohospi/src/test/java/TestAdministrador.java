import co.edu.uniquindio.prohospi.Model.Administrador;
import co.edu.uniquindio.prohospi.Model.Hospital;
import co.edu.uniquindio.prohospi.Model.Medico;
import co.edu.uniquindio.prohospi.Model.Paciente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.ArrayList;

public class TestAdministrador {

    @Test
    public void testGenerarReporteOcupacion() {
        Hospital hospital = new Hospital();

        Administrador administrador = new Administrador("1", "Carlos Gómez", "carlos@email.com","3141","admin221");

        Medico medico1 = new Medico("101", "Dr. Juan Pérez", "juan@hospital.com", "Cardiología","aasf","2414");
        Medico medico2 = new Medico("102", "Dra. María López", "maria@hospital.com","13", "Pediatría","434");
        administrador.registrarMedico(hospital, medico1);
        administrador.registrarMedico(hospital, medico2);

        Paciente paciente1 = new Paciente("", "Luis Fernández", "luis@email.com","add","1331");
        Paciente paciente2 = new Paciente("", "Ana Rodríguez", "ana@email.com", "ad","131");
        Paciente paciente3 = new Paciente("", "Pedro García", "pedro@email.com", "addd","13231");


        administrador.registrarPaciente(hospital, paciente1);
        administrador.registrarPaciente(hospital, paciente2);
        administrador.registrarPaciente(hospital, paciente3);

        administrador.asignarPaciente(medico1, paciente1);
        administrador.asignarPaciente(medico1, paciente2);
        administrador.asignarPaciente(medico2, paciente3);

        administrador.generarReporteOcupacion(hospital);

        Assertions.assertEquals(2, medico1.getPacientes().size(), "El Dr. Juan Pérez debería tener 2 pacientes.");
        Assertions.assertEquals(1, medico2.getPacientes().size(), "La Dra. María López debería tener 1 paciente.");
    }
}

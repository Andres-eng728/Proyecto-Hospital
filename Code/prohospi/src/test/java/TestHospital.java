import co.edu.uniquindio.prohospi.Model.Hospital;
import co.edu.uniquindio.prohospi.Model.Medico;
import co.edu.uniquindio.prohospi.Model.Paciente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;

public class TestHospital {

    @Test
    public void testAgregarMedicoYPaciente() {
        // Crear hospital
        Hospital hospital = new Hospital();

        // Crear médico y paciente
        Medico medico = new Medico("1", "Dr. Pérez", "perez@hospital.com", "Cardiología","fsf","2414");
        Paciente paciente = new Paciente("101", "Juan López", "juan@correo.com","13231","absf");

        // Agregar médico y paciente al hospital
        hospital.agregarMedico(medico);
        hospital.agregarPaciente(paciente);

        // Verificar que fueron agregados correctamente
        List<Medico> medicos = hospital.getMedicos();
        List<Paciente> pacientes = hospital.getPacientes();

        Assertions.assertEquals(1, medicos.size(), "Debe haber 1 médico en el hospital.");
        Assertions.assertEquals(1, pacientes.size(), "Debe haber 1 paciente en el hospital.");
        Assertions.assertEquals(medico, medicos.get(0), "El médico agregado debe coincidir.");
        Assertions.assertEquals(paciente, pacientes.get(0), "El paciente agregado debe coincidir.");
    }

    @Test
    public void testAsignarPacienteAMedico() {
        // Crear hospital
        Hospital hospital = new Hospital();

        // Crear médico y paciente
        Medico medico = new Medico("1", "Dr. Pérez", "perez@hospital.com", "Cardiología","fsf","2414");
        Paciente paciente = new Paciente("101", "Juan López", "juan@correo.com","2133","pacien2");

        // Agregar médico y paciente
        hospital.agregarMedico(medico);
        hospital.agregarPaciente(paciente);

        // Asignar paciente al médico
        hospital.asignarPacienteAMedico(paciente, medico);

        // Verificar que el paciente fue asignado correctamente
        Assertions.assertTrue(medico.getPacientes().contains(paciente), "El paciente debe estar en la lista del médico.");

        // Imprimir resultado para visualizar datos correctamente
        System.out.println("Resumen del hospital:");
        System.out.println("Total de médicos: " + hospital.getMedicos().size());
        System.out.println("Total de pacientes: " + hospital.getPacientes().size());
        System.out.println("Pacientes asignados al Dr. Pérez: " + medico.getPacientes().size());

        // Mensaje de confirmación
        System.out.println("Todas las pruebas han pasado correctamente");
    }
}

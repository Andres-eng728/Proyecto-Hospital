package co.edu.uniquindio.prohospi.Controller;

import co.edu.uniquindio.prohospi.Model.Paciente;

import java.util.ArrayList;
import java.util.List;

public class PacienteController {
    private List<Paciente> pacientes = new ArrayList<>();

    public PacienteController() {
        // ejemplo con datos quemados
        pacientes.add(new Paciente("anfel","121","anfel@gmail.com","1345","paciente1"));

    }

    public boolean autenticarPaciente(String usuario, String contrasena) {
        for (Paciente paciente : pacientes) {
            if (paciente.getUsuarioPaciente().equals(usuario) && paciente.getContrasenaPaciente().equals(contrasena)) {
                return true;
            }
        }
        return false;
    }
}

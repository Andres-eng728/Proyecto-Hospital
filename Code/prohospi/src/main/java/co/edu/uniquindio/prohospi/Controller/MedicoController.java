package co.edu.uniquindio.prohospi.Controller;

import co.edu.uniquindio.prohospi.Model.Medico;

import java.util.ArrayList;
import java.util.List;

public class MedicoController {
    private List<Medico> medicos = new ArrayList<>();

    public MedicoController() {
        // ejemplo con datos quemados
        medicos.add(new Medico("medico1", "1234","ada@,","cirujia","medico1","1456"));

    }

    public boolean autenticarMedico(String usuario, String contrasena) {
        for (Medico medico : medicos) {
            if (medico.getUsuarioMedico().equals(usuario) && medico.getContrasenaMedico().equals(contrasena)) {
                return true;
            }
        }
        return false;
    }


}


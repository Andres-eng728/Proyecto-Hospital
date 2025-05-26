package co.edu.uniquindio.prohospi.Model;

import java.util.ArrayList;
import java.util.List;

public class Hospital {
    private List<Medico> medicos;
    private List<Paciente> pacientes;

    public Hospital() {
        this.medicos = new ArrayList<>();
        this.pacientes = new ArrayList<>();
    }

    public void agregarMedico(Medico medico) {
        medicos.add(medico);
    }

    public void agregarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }


    public void asignarPacienteAMedico(Paciente paciente, Medico medico) {
        medico.agregarPaciente(paciente);
    }

    public List<Medico> getMedicos() {
        return medicos;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }
}

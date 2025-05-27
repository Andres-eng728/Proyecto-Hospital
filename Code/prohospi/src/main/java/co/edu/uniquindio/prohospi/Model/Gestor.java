package co.edu.uniquindio.prohospi.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Gestor {
    private static final Gestor instancia = new Gestor();
    private final ObservableList<Paciente> pacientes;
    private  final ObservableList<Medico> listMedicos;

    private Gestor() {
        pacientes = FXCollections.observableArrayList();
        listMedicos = FXCollections.observableArrayList();
    }

    public static Gestor getInstancia() {
        return instancia;
    }

    public ObservableList<Paciente> getPacientes() {
        return pacientes;
    }

    public void eliminarPaciente(Paciente paciente) {
        pacientes.remove(paciente);
    }
    public void eliminarMedico(Medico medico) {
        listMedicos.remove(medico);
    }

    public ObservableList<Medico> getListMedicos() {
        return listMedicos;
    }
}
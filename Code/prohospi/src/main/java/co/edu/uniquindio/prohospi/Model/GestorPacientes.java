package co.edu.uniquindio.prohospi.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class GestorPacientes {
    private static final GestorPacientes instancia = new GestorPacientes();
    private final ObservableList<Paciente> pacientes;

    private GestorPacientes() {
        pacientes = FXCollections.observableArrayList();
    }

    public static GestorPacientes getInstancia() {
        return instancia;
    }

    public ObservableList<Paciente> getPacientes() {
        return pacientes;
    }

    public void eliminarPaciente(Paciente paciente) {
        pacientes.remove(paciente);
    }




}
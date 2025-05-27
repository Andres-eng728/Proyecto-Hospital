package co.edu.uniquindio.prohospi.Model;

import co.edu.uniquindio.prohospi.ViewController.CitaMedicaViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Gestor {
    private static final Gestor instancia = new Gestor();
    private final ObservableList<Paciente> pacientes;
    private  final ObservableList<Medico> listMedicos;
    private final ObservableList<Sala> listaSalas;
    private final ObservableList<HistorialMedico> listaHistoriales;
    private final ObservableList<String> horarios;
    private ObservableList<CitaMedica> listaCitas;

    private Gestor() {
        pacientes = FXCollections.observableArrayList();
        listMedicos = FXCollections.observableArrayList();
        listaSalas = FXCollections.observableArrayList();
        listaHistoriales = FXCollections.observableArrayList();
        horarios = FXCollections.observableArrayList();
        listaCitas = FXCollections.observableArrayList();
    }

    public static Gestor getInstancia() {
        return instancia;
    }

    public ObservableList<Paciente> getPacientes() {
        return pacientes;
    }
    public ObservableList<String> getHorarios() {
        return horarios;
    }
    public ObservableList<CitaMedica> getListaCitas() {
        return listaCitas;
    }
    public void setListaCitas(ObservableList<CitaMedica> listaCitas) {
        this.listaCitas = listaCitas;
    }

    public ObservableList<Sala> getListaSalas() {
        return listaSalas;
    }
    public ObservableList<HistorialMedico> getListaHistoriales() {
        return listaHistoriales;
    }

    public void agregarSala(Sala sala) {
        listaSalas.add(sala);
    }
    public void agregarHistorial(HistorialMedico historial) {
        listaHistoriales.add(historial);
    }
    public void agregarMedico(Medico medico) {
        listMedicos.add(medico);
    }
    public void agregarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }
    public void agregarHorario(String horario) {
        horarios.add(horario);
    }
    public void agregarCita(CitaMedica cita) {
        listaCitas.add(cita);
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
package co.edu.uniquindio.proyectohospital.Model;

import co.edu.uniquindio.proyectohospital.Model.Horario;
import co.edu.uniquindio.proyectohospital.Model.Paciente;

import java.util.ArrayList;
import java.util.List;

public class Medico extends Usuario {
    private String especialidad;
    private List<Paciente> pacientes;
    private List<Horario> horariosConsulta;
    private List<String> notificaciones;

    public Medico(int id, String nombre, String email, String especialidad) {
        super(id, nombre, email);
        this.especialidad = especialidad;
        this.pacientes = new ArrayList<>();
        this.horariosConsulta = new ArrayList<>();
        this.notificaciones = new ArrayList<>();
    }

    public List<String> getNotificaciones() {
        return notificaciones;
    }

    public void setNotificaciones(List<String> notificaciones) {
        this.notificaciones = notificaciones;
    }

    public List<Horario> getHorariosConsulta() {
        return horariosConsulta;
    }

    public void setHorariosConsulta(List<Horario> horariosConsulta) {
        this.horariosConsulta = horariosConsulta;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public void agregarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }

    public void registrarDiagnostico(Paciente paciente, String diagnostico) {
        paciente.getHistorial().actualizarHistorial("Diagnóstico: " + diagnostico);
    }

    public void registrarTratamiento(Paciente paciente, String tratamiento) {
        paciente.getHistorial().actualizarHistorial("Tratamiento: " + tratamiento);
    }

    public void asignarHorario(String dia, String hora) {
        horariosConsulta.add(new Horario(dia, hora));
    }

    public String consultarHorario(String dia) {
        for (Horario horario : horariosConsulta) {
            if (horario.getDia().equalsIgnoreCase(dia)) {
                return horario.getHora();
            }
        }
        return "Sin horario asignado";
    }

    public void notificarCambioCita(Paciente paciente1, String mensaje) {
        notificaciones.add("Cambio en cita: " + mensaje);
    }

    public void verNotificaciones() {
        if (notificaciones.isEmpty()) {
            System.out.println("No hay notificaciones nuevas.");
        } else {
            System.out.println("Notificaciones:");
            for (String nota : notificaciones) {
                System.out.println("- " + nota);
            }
            notificaciones.clear(); // Limpiar después de mostrar
        }
    }

    public String getNombre() {
        return nombre;

    }
}




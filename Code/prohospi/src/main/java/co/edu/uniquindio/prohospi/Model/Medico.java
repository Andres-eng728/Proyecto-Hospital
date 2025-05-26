package co.edu.uniquindio.prohospi.Model;

import java.util.ArrayList;
import java.util.List;

public class Medico extends Persona implements InterfazHistorial {
    private String especialidad;
    private String usuarioMedico;
    private String contrasenaMedico;
    private List<Paciente> pacientes;
    private List<Horario> horariosConsulta;
    private List<String> notificaciones;

    public Medico(String nombre, String identificacion, String correo, String especialidad, String usuarioMedico, String contrasenaMedico) {
        super(nombre, identificacion, correo);
        this.especialidad = especialidad;
        this.usuarioMedico = usuarioMedico;
        this.contrasenaMedico = contrasenaMedico;
        this.pacientes = new ArrayList<>();
        this.horariosConsulta = new ArrayList<>();
        this.notificaciones = new ArrayList<>();
    }



    public void verPacientes() {
        System.out.println("Consultando lista de pacientes del médico " + nombre);
    }

    @Override
    public void verHistorial() {
        System.out.println("Acceso a historial médico por el doctor: " + nombre);
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getContrasenaMedico() {
        return contrasenaMedico;
    }

    public void setContrasenaMedico(String contrasenaMedico) {
        this.contrasenaMedico = contrasenaMedico;
    }

    public String getUsuarioMedico() {
        return usuarioMedico;
    }

    public void setUsuarioMedico(String usuarioMedico) {
        this.usuarioMedico = usuarioMedico;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
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
    /**
     * Metodo para ver el horario de un medico
     * @param dia
     * @return
     */
    public String consultarHorario(String dia) {
        for (Horario horario : horariosConsulta) {
            if (horario.getDia().equalsIgnoreCase(dia)) {
                return horario.getHora();
            }
        }
        return "Sin horario asignado";
    }
    /**
     * Metodo para notificar el cambio de una cita
     * @param paciente1
     * @param mensaje
     */
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

}

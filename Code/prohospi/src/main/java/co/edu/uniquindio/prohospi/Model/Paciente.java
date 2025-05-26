package co.edu.uniquindio.prohospi.Model;

import java.util.ArrayList;
import java.util.List;

public class Paciente extends Persona implements  InterfazHistorial {

    private HistorialMedico historial;
    private String usuarioPaciente;
    private String contrasenaPaciente;
    private List<CitaMedica> citasProgramadas;
    private List<String> notificaciones;

    public Paciente(String nombre, String identificacion, String correo, String contrasenaPaciente,String usuarioPaciente) {
        super(nombre, identificacion, correo);
        this.historial = new HistorialMedico("can","terapia","2021-01-01","142");
        this.usuarioPaciente = usuarioPaciente;
        this.contrasenaPaciente = contrasenaPaciente;
        this.citasProgramadas = new ArrayList<>();
        this.notificaciones = new ArrayList<>();
    }
    /**
     * Actualiza los datos del paciente
     * @param nuevoNombre
     * @param nuevoEmail
     */
    public void actualizarDatos(String nuevoNombre, String nuevoEmail) {
        setNombre(nuevoNombre);
        setCorreo(nuevoEmail);
    }
    /**
     * Metodo para solicitar y agendar cita
     * @param cita
     */
    public void solicitarCita(CitaMedica cita) {
        citasProgramadas.add(cita);
        notificaciones.add("Cita médica programada para el día " + cita.getFechaHora());
    }
    /**
     * Metodo para cancelar una cita
     * @param cita
     */
    public void cancelarCita(CitaMedica cita) {
        if (citasProgramadas.remove(cita)) {
            notificaciones.add("La cita médica para el día " + cita.getFechaHora() + " ha sido cancelada.");
        }
    }

    @Override
    public void verHistorial() {
        System.out.println("Mostrando historial médico de: " + nombre);
        historial.mostrar();
    }

    public HistorialMedico getHistorial() {
        return historial;
    }

    public void setHistorial(HistorialMedico historial) {
        this.historial = historial;
    }

    public String getUsuarioPaciente() {
        return usuarioPaciente;
    }

    public void setUsuarioPaciente(String usuarioPaciente) {
        this.usuarioPaciente = usuarioPaciente;
    }

    public String getContrasenaPaciente() {
        return contrasenaPaciente;
    }

    public void setContrasenaPaciente(String contrasenaPaciente) {
        this.contrasenaPaciente = contrasenaPaciente;
    }

    public List<CitaMedica> getCitasProgramadas() {
        return citasProgramadas;
    }

    public void setCitasProgramadas(List<CitaMedica> citasProgramadas) {
        this.citasProgramadas = citasProgramadas;
    }

    public List<String> getNotificaciones() {
        return notificaciones;
    }

    public void setNotificaciones(List<String> notificaciones) {
        this.notificaciones = notificaciones;
    }

    public void verNotificaciones() {
        if (notificaciones.isEmpty()) {
            System.out.println("No tienes notificaciones nuevas.");
        } else {
            System.out.println("Tus notificaciones:");
            for (String nota : notificaciones) {
                System.out.println("- " + nota);
            }
            notificaciones.clear(); // Limpia después de ver
        }
    }
}

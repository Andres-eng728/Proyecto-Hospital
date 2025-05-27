package co.edu.uniquindio.prohospi.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Paciente extends Persona implements  InterfazHistorial, Serializable {
    private static final long serialVersionUID = 1L;
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
    public Paciente() {
        super();
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
        notificaciones.add("Cita médica programada para el día " + cita.getFecha());
    }
    /**
     * Metodo para cancelar una cita
     * @param cita
     */
    public void cancelarCita(CitaMedica cita) {
        if (citasProgramadas.remove(cita)) {
            notificaciones.add("La cita médica para el día " + cita.getFecha() + " ha sido cancelada.");
        }
    }
    /**
     * Metodo para ver el historial del paciente
     */
    @Override
    public void verHistorial() {
        System.out.println("Mostrando historial médico de: " + nombre);
        historial.mostrar();
    }
    /**
     * metodo que devuelve el historial medico
     * @return
     */
    public HistorialMedico getHistorial() {
        return historial;
    }
    /**
     * metodo para asignar historial
     * @param historial
     */
    public void setHistorial(HistorialMedico historial) {
        this.historial = historial;
    }
    /**
     * metodo que retorna el usuario paciente
     * @return
     */
    public String getUsuarioPaciente() {
        return usuarioPaciente;
    }
    /**
     * metodo para asignar un usuario paciente
     * @param usuarioPaciente
     */
    public void setUsuarioPaciente(String usuarioPaciente) {
        this.usuarioPaciente = usuarioPaciente;
    }
    /**
     * metodo que retorna la contraseña del paciente
     * @return
     */
    public String getContrasenaPaciente() {
        return contrasenaPaciente;
    }
    /**
     * metodo para registrar la contraseña del paciente
     * @param contrasenaPaciente
     */
    public void setContrasenaPaciente(String contrasenaPaciente) {
        this.contrasenaPaciente = contrasenaPaciente;
    }
    /**
     * metodo que retorna las citas programadas
     * @return
     */
    public List<CitaMedica> getCitasProgramadas() {
        return citasProgramadas;
    }
    /**
     * metodo para asignar lista de citas programadas
     * @param citasProgramadas
     */
    public void setCitasProgramadas(List<CitaMedica> citasProgramadas) {
        this.citasProgramadas = citasProgramadas;
    }
    /**
     * metodo que retorna las notificaciones
     * @return
     */
    public List<String> getNotificaciones() {
        return notificaciones;
    }
    /**
     * metodo para registrar las notificaciones
     * @param notificaciones
     */
    public void setNotificaciones(List<String> notificaciones) {
        this.notificaciones = notificaciones;
    }
    /**
     * Metodo para ver y limpiar las notificaciones del paciente
     */
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

package co.edu.uniquindio.proyectohospital.Model;
import co.edu.uniquindio.proyectohospital.Model.CitaMedica;


import java.util.ArrayList;
import java.util.List;

public class Paciente extends Usuario {

    private HistorialMedico historial;
    private List<CitaMedica> citasProgramadas;
    private List<String> notificaciones;

    public Paciente(int id, String nombre, String email) {
        super(id, nombre, email);
        this.historial = new HistorialMedico();
        this.citasProgramadas = new ArrayList<>();
        this.notificaciones = new ArrayList<>();
    }

    public void actualizarDatos(String nuevoNombre, String nuevoEmail) {
        setNombre(nuevoNombre);
        setEmail(nuevoEmail);
    }

    public void solicitarCita(CitaMedica cita) {
        citasProgramadas.add(cita);
        notificaciones.add("Cita médica programada para el día " + cita.getFechaHora());
    }

    public void cancelarCita(CitaMedica cita) {
        if (citasProgramadas.remove(cita)) {
            notificaciones.add("La cita médica para el día " + cita.getFechaHora() + " ha sido cancelada.");
        }
    }

    public HistorialMedico consultarHistorial() {
        return historial;
    }

    public List<String> getNotificaciones() {
        return notificaciones;
    }

    public List<CitaMedica> getCitasProgramadas() {
        return citasProgramadas;
    }

    public HistorialMedico getHistorial() {
        return historial;
    }

    public void setHistorial(HistorialMedico historial) {
        this.historial = historial;
    }

    public void setCitasProgramadas(List<CitaMedica> citasProgramadas) {
        this.citasProgramadas = citasProgramadas;
    }

    public void setNotificaciones(List<String> notificaciones) {
        this.notificaciones = notificaciones;
    }

    public void notificarCita(String mensaje) {
        notificaciones.add("Notificación de cita: " + mensaje);
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

    public String getNombre() {
        return nombre;
    }
}



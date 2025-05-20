package co.edu.uniquindio.prohospi.Model;

public class Paciente extends Persona implements InterfazCitable, InterfazHistorial {
    private HistorialMedico historial;

    public Paciente(String nombre, String identificacion, String correo) {
        super(nombre, identificacion, correo);
        this.historial = new HistorialMedico();
    }

    @Override
    public void solicitarCita(CitaMedica cita) {
        System.out.println("Cita solicitada por el paciente: " + nombre);
    }

    @Override
    public void cancelarCita(CitaMedica cita) {
        System.out.println("Cita cancelada por el paciente: " + nombre);
    }

    @Override
    public void verHistorial() {
        System.out.println("Mostrando historial médico de: " + nombre);
        historial.mostrar();
    }

    public HistorialMedico getHistorial() {
        return historial;
    }
}
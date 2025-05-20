package co.edu.uniquindio.prohospi.Model;

public class Medico extends Persona implements InterfazHistorial {
    private String especialidad;

    public Medico(String nombre, String identificacion, String correo, String especialidad) {
        super(nombre, identificacion, correo);
        this.especialidad = especialidad;
    }

    public void registrarDiagnostico(Paciente paciente, String diagnostico) {
        paciente.getHistorial().agregarEntrada(diagnostico);
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
}
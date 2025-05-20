package co.edu.uniquindio.prohospi.Model;
public class Administrador extends Persona {
    public Administrador(String nombre, String identificacion, String correo) {
        super(nombre, identificacion, correo);
    }

    public void registrarPaciente(Paciente paciente) {
        System.out.println("Paciente registrado: " + paciente.getNombre());
    }

    public void registrarMedico(Medico medico) {
        System.out.println("Médico registrado: " + medico.getNombre());
    }
}
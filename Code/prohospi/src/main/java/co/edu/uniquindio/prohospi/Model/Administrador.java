package co.edu.uniquindio.prohospi.Model;

import java.util.List;

public class Administrador extends Persona {

    private String contrasena;
    public String usuario;
    public Administrador(String nombre, String identificacion, String correo,String contrasena,String usuario) {
        super(nombre, identificacion, correo);
        this.contrasena=contrasena;
        this.usuario=usuario;
    }

    public void registrarPaciente(Paciente paciente) {
        System.out.println("Paciente registrado: " + paciente.getNombre());
    }

    public void registrarMedico(Medico medico) {
        System.out.println("Médico registrado: " + medico.getNombre());
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasenia) {
        this.contrasena = contrasenia;
    }

    public void setusuario(String usuario) {
        this.usuario = usuario;
    }

    public String getusuario() {
        return usuario;
    }
    public void registrarMedico(Hospital hospital, Medico nuevoMedico) {
        hospital.agregarMedico(nuevoMedico);
    }

    public void modificarMedico(Medico medico, String nuevaEspecialidad) {
        medico.setEspecialidad(nuevaEspecialidad);
    }

    public void eliminarMedico(List<Medico> medicos, Medico medico) {
        medicos.remove(medico);
    }

    public void registrarPaciente(Hospital hospital, Paciente nuevoPaciente) {
        hospital.agregarPaciente(nuevoPaciente);
    }

    public void eliminarPaciente(List<Paciente> pacientes, Paciente paciente) {
        pacientes.remove(paciente);
    }

    public void asignarSala(List<String> salas, String sala) {
        salas.add(sala);
    }

    public void eliminarSala(List<String> salas, String sala) {
        salas.remove(sala);
    }

    public void mostrarDisponibilidad(List<Medico> medicos) {
        for (Medico m : medicos) {
            System.out.println("Médico: " + m.getNombre());
            m.getHorariosConsulta().forEach(h -> System.out.println("- " + h));
        }
    }

    public void asignarPaciente(Medico medico, Paciente paciente) {
        medico.agregarPaciente(paciente);
    }

    public void generarReporteCitas(Hospital hospital) {
        System.out.println("REPORTE DE CITAS:");
        for (Paciente paciente : hospital.getPacientes()) {
            for (CitaMedica cita : paciente.getCitasProgramadas()) {
                System.out.println("- Paciente: " + paciente.getNombre() +
                        ", Médico: " + cita.getMedico().getNombre() +
                        ", Fecha: " + cita.getFechaHora());
            }
        }
    }

    public void generarReporteOcupacion(Hospital hospital) {
        System.out.println("REPORTE DE OCUPACIÓN MÉDICA:");
        for (Medico medico : hospital.getMedicos()) {
            System.out.println("- " + medico.getNombre() + ": " + medico.getPacientes().size() + " pacientes asignados.");
        }
    }



    @Override
    public String toString() {
        return "Administrador{" +
                "contrasenia='" + contrasena + '\'' +
                ", correo='" + correo + '\'' +
                ", identificacion='" + identificacion + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
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
    /**
     * metodo para registrar un paciente
     * @param paciente
     */
    public void registrarPaciente(Paciente paciente) {
        System.out.println("Paciente registrado: " + paciente.getNombre());
    }
    /**
     * Metodo para registrar un medico
     * @param medico
     */
    public void registrarMedico(Medico medico) {
        System.out.println("Médico registrado: " + medico.getNombre());
    }
    /**
     * Metodo para retornar la contraseña
     * @return
     */
    public String getContrasena() {
        return contrasena;
    }
    /**
     * Metodo para asignar la contraseña
     * @param contrasenia
     */
    public void setContrasena(String contrasenia) {
        this.contrasena = contrasenia;
    }
    /**
     * Metodo para asignar el usuario
     * @param usuario
     */
    public void setusuario(String usuario) {
        this.usuario = usuario;
    }
    /**
     * Metodo para retornar el usuario
     * @return
     */
    public String getusuario() {
        return usuario;
    }
     /**
     * Metodo para registrar medico en el hospital
     * @param hospital
     * @param nuevoMedico
     */
    public void registrarMedico(Hospital hospital, Medico nuevoMedico) {
        hospital.agregarMedico(nuevoMedico);
    }
    /**
     * Metodo para modificar la especialidad del medico
     * @param medico
     * @param nuevaEspecialidad
     */
    public void modificarMedico(Medico medico, String nuevaEspecialidad) {
        medico.setEspecialidad(nuevaEspecialidad);
    }
    /**
     * Metodo para eliminar un medico 
     * @param medicos
     * @param medico
     */
    public void eliminarMedico(List<Medico> medicos, Medico medico) {
        medicos.remove(medico);
    }
    /**
     * Metodo para registrar un paciente
     * @param hospital
     * @param nuevoPaciente
     */
    public void registrarPaciente(Hospital hospital, Paciente nuevoPaciente) {
        hospital.agregarPaciente(nuevoPaciente);
    }
    /**
     * Metodo para eliminar pacientes
     * @param pacientes
     * @param paciente
     */
    public void eliminarPaciente(List<Paciente> pacientes, Paciente paciente) {
        pacientes.remove(paciente);
    }
    /**
     * Metodo para asignar una sala
     * @param salas
     * @param sala
     */
    public void asignarSala(List<String> salas, String sala) {
        salas.add(sala);
    }
    /**
     * metodo para eliminar una sala
     * @param salas
     * @param sala
     */
    public void eliminarSala(List<String> salas, String sala) {
        salas.remove(sala);
    }
    /**
     * Metodo para mostrar la disponibilidad de los medicos
     * @param medicos
     */
    public void mostrarDisponibilidad(List<Medico> medicos) {
        for (Medico m : medicos) {
            System.out.println("Médico: " + m.getNombre());
            m.getHorariosConsulta().forEach(h -> System.out.println("- " + h));
        }
    }
    /**
     * Metodo para asignar un paciente
     * @param medico
     * @param paciente
     */
    public void asignarPaciente(Medico medico, Paciente paciente) {
        medico.agregarPaciente(paciente);
    }
    /**
     * Metodo para generar los reportes de las citas de los pacientes
     * @param hospital
     */
    public void generarReporteCitas(Hospital hospital) {
        System.out.println("REPORTE DE CITAS:");
        for (Paciente paciente : hospital.getPacientes()) {
            for (CitaMedica cita : paciente.getCitasProgramadas()) {
                System.out.println("- Paciente: " + paciente.getNombre() +
                        ", Médico: " + cita.getMedico() +
                        ", Fecha: " + cita.getFecha());
            }
        }
    }
    /**
     * Metodo que genera reportes de ocupacion de los medicos
     * @param hospital
     */
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

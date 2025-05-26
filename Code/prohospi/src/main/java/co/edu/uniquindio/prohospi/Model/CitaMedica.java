package co.edu.uniquindio.prohospi.Model;

import java.time.LocalDateTime;

public class CitaMedica {
    private LocalDateTime fechaHora;
    private Paciente paciente;
    private Medico medico;

    public CitaMedica(LocalDateTime fechaHora, Paciente paciente, Medico medico) {
        this.fechaHora = fechaHora;
        this.paciente = paciente;
        this.medico = medico;
    }
    /**
     * Metodo para retornar la hora
     * @return
     */
    public LocalDateTime getFechaHora() {
        return fechaHora;
    }
    /**
     * metodo para retornar el paciente
     * @return
     */
    public Paciente getPaciente() {
        return paciente;
    }
    /**
     * metodo para retornar al medico
     * @return
     */
    public Medico getMedico() {
        return medico;
    }
    /**
     * Metodo para asignar hora
     * @param fechaHora
     */
    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }
    /**
     * metodo para asignar paciente
     * @param paciente
     */
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    /**
     * Metodo para asignar medico
     * @param medico
     */
    public void setMedico(Medico medico) {
        this.medico = medico;
    }
    /**
     * Metodo que muestras los detalles asignados de la cita
     * @return
     */
    public String detallesCita() {
        return "Cita con el Dr. " + medico.nombre + " para " + paciente.nombre + " el " + fechaHora.toString();
    }


}

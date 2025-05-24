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

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public String detallesCita() {
        return "Cita con el Dr. " + medico.nombre + " para " + paciente.nombre + " el " + fechaHora.toString();
    }


}
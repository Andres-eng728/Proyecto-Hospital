package co.edu.uniquindio.prohospi.Model;

import co.edu.uniquindio.prohospi.Model.Medico;
import co.edu.uniquindio.prohospi.Model.Paciente;
import co.edu.uniquindio.prohospi.Model.Sala;

import java.time.LocalDateTime;

public class CitaMedica {
    private LocalDateTime fecha;
    private Medico medico;
    private Paciente paciente;
    private Sala sala;

    public CitaMedica(LocalDateTime fecha, Medico medico, Paciente paciente, Sala sala) {
        this.fecha = fecha;
        this.medico = medico;
        this.paciente = paciente;
        this.sala = sala;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public Medico getMedico() {
        return medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Sala getSala() {
        return sala;
    }
}
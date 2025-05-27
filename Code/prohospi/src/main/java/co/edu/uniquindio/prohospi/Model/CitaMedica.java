package co.edu.uniquindio.prohospi.Model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class CitaMedica {
    private  LocalDate fecha;
    private  String hora;
    private  String medico;

    public CitaMedica(LocalDate fecha, String hora, String medico) {
        this.fecha = fecha;
        this.hora = hora;
        this.medico = medico;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }



    /**
     * metodo para retornar al medico
     * @return
     */
    public String getMedico() {
        return medico;
    }

    /**
     * Metodo para asignar medico
     * @param medico
     */
    public void setMedico(String medico) {
        this.medico = medico;
    }
    /**
     * Metodo que muestras los detalles asignados de la cita
     * @return
     */



}

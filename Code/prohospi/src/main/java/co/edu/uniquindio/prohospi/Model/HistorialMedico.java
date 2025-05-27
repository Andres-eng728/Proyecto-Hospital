package co.edu.uniquindio.prohospi.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class HistorialMedico implements Serializable{
    private static final long serialVersionUID = 1L;
    private List<String> entradas;
    private List<String> antecedentes;
    private String diagnostico;
    private String tratamiento;
    private String fecha;
    private String idPaciente;

    public HistorialMedico(String diagnostico, String tratamiento, String fecha, String idPaciente)  {
        this.fecha = fecha;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
        this.idPaciente = idPaciente;
        this.entradas = new ArrayList<>();
        this.antecedentes = new ArrayList<>();
    }
    public HistorialMedico() {}
    /**
     * Metodo para agregar entrada
     * @param entrada
     */
    public void agregarEntrada(String entrada) {
        entradas.add(entrada);
    }
    /**
     * Metodo para mostrar la entrada
     */
    public void mostrar() {
        for (String entrada : entradas) {
            System.out.println(entrada);
        }
    }
    /**
     * metodo para actualizar el historial
     * @param nuevoAntecedente
     */
    public void actualizarHistorial(String nuevoAntecedente) {
        antecedentes.add(nuevoAntecedente);
    }
    /**
     * Metodo para obtener los antecedentes
     * @return
     */
    public List<String> getAntecedentes() {
        return antecedentes;
    }
    /**
     * Metodo que retorna las entradas
     *
     * @return
     */
    public List<String> getEntradas() {
        return entradas;
    }
    /**
     * Metodo para asignar una entrada
     * @param entradas
     */
    public void setEntradas(List<String> entradas) {
        this.entradas = entradas;
    }
    /**
     * Metodo para asignar antecedentes
     * @param antecedentes
     */
    public void setAntecedentes(List<String> antecedentes) {
        this.antecedentes = antecedentes;
    }
    /**
     * metodo que retorna el diagnostico
     * @return
     */
    public String getDiagnostico() {
        return diagnostico;
    }
    /**
     * Metodo para asignar el diagnostico
     * @param diagnostico
     */
    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }
    /**
     * Metodo que retorna el tratamiento
     * @return
     */
    public String getTratamiento() {
        return tratamiento;
    }
    /**
     * Metodo para asignar tratamiento
     * @param tratamiento
     */
    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }
    /**
     * Metodo que retorna la fecha
     * @return
     */
    public String getFecha() {
        return fecha;
    }
    /**
     * Metodo para asignar fecha
     * @param fecha
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    /**
     * metodo que retorna el id de paciente
     * @return
     */
    public String getIdPaciente() {
        return idPaciente;
    }
    /**
     * Metodo para asignar id a un paciente
     * @param idPaciente
     */
    public void setIdPaciente(String idPaciente) {
        this.idPaciente = idPaciente;
    }
}


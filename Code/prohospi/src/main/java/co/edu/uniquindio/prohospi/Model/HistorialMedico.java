package co.edu.uniquindio.prohospi.Model;

import java.util.ArrayList;
import java.util.List;

public class HistorialMedico {
    private List<String> entradas;
    private List<String> antecedentes;
    private String diagnostico;
    private String tratamiento;
    private String fecha;
    public HistorialMedico(String diagnostico, String tratamiento, String fecha) {
        this.fecha = fecha;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
        this.entradas = new ArrayList<>();
        this.antecedentes = new ArrayList<>();
    }

    public void agregarEntrada(String entrada) {
        entradas.add(entrada);
    }

    public void mostrar() {
        for (String entrada : entradas) {
            System.out.println(entrada);
        }
    }

    public void actualizarHistorial(String nuevoAntecedente) {
        antecedentes.add(nuevoAntecedente);
    }

    public List<String> getAntecedentes() {
        return antecedentes;
    }

    public List<String> getEntradas() {
        return entradas;
    }

    public void setEntradas(List<String> entradas) {
        this.entradas = entradas;
    }

    public void setAntecedentes(List<String> antecedentes) {
        this.antecedentes = antecedentes;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
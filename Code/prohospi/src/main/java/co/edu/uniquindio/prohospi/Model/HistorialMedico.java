package co.edu.uniquindio.prohospi.Model;

import java.util.ArrayList;
import java.util.List;

public class HistorialMedico {
    private List<String> entradas;
    private List<String> antecedentes;
    public HistorialMedico() {
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
}
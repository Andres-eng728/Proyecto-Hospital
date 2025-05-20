package co.edu.uniquindio.prohospi.Model;

import java.util.ArrayList;
import java.util.List;

public class HistorialMedico {
    private List<String> entradas;

    public HistorialMedico() {
        this.entradas = new ArrayList<>();
    }

    public void agregarEntrada(String entrada) {
        entradas.add(entrada);
    }

    public void mostrar() {
        for (String entrada : entradas) {
            System.out.println(entrada);
        }
    }
}
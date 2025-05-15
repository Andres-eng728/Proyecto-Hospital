package co.edu.uniquindio.proyectohospital.Model;

import java.util.ArrayList;
import java.util.List;

public class HistorialMedico {
    private List<String> antecedentes;

    public HistorialMedico() {
        this.antecedentes = new ArrayList<>();
    }

    public void actualizarHistorial(String nuevoAntecedente) {
        antecedentes.add(nuevoAntecedente);
    }

    public List<String> getAntecedentes() {
        return antecedentes;
    }
}



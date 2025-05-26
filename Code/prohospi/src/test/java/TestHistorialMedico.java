import co.edu.uniquindio.prohospi.Model.HistorialMedico;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;

public class TestHistorialMedico {

    @Test
    public void testGetAntecedentes() {
        // Crear historial médico
        HistorialMedico historial = new HistorialMedico("amnesia","pasta","2025-01-01","1414");

        // Agregar antecedentes médicos
        historial.actualizarHistorial("Hipertensión");
        historial.actualizarHistorial("Cirugía de rodilla");
        historial.actualizarHistorial("Alergia a la penicilina");

        // Obtener lista de antecedentes
        List<String> antecedentes = historial.getAntecedentes();

        // Verificar que los antecedentes fueron almacenados correctamente
        Assertions.assertEquals(3, antecedentes.size(), "Debe haber exactamente 3 antecedentes en el historial.");
        Assertions.assertTrue(antecedentes.contains("Hipertensión"), "El historial debería contener 'Hipertensión'.");
        Assertions.assertTrue(antecedentes.contains("Cirugía de rodilla"), "El historial debería contener 'Cirugía de rodilla'.");
        Assertions.assertTrue(antecedentes.contains("Alergia a la penicilina"), "El historial debería contener 'Alergia a la penicilina'.");

        // **Imprimir los antecedentes en consola**
        System.out.println("Antecedentes médicos registrados:");
        for (String antecedente : antecedentes) {
            System.out.println("- " + antecedente);
        }

        // Mensaje de confirmación
        System.out.println("Todas las pruebas han pasado correctamente");
    }
}

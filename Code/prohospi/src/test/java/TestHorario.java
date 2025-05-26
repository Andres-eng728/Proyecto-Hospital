import co.edu.uniquindio.prohospi.Model.Horario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestHorario {

    @Test
    public void testGetDiaYHora() {
        // Crear un horario con valores específicos
        Horario horario = new Horario("Lunes", "08:00 AM");

        // Confirmar que `getDia()` devuelve el día correcto
        Assertions.assertEquals("Lunes", horario.getDia(), "El día asignado no es correcto.");

        // Confirmar que `getHora()` devuelve la hora correcta
        Assertions.assertEquals("08:00 AM", horario.getHora(), "La hora asignada no es correcta.");

        // **Imprimir los valores para verlos en consola**
        System.out.println("Horario registrado:");
        System.out.println("- Día: " + horario.getDia());
        System.out.println("- Hora: " + horario.getHora());

        // Mensaje de confirmación
        System.out.println("Todas las pruebas han pasado correctamente");
    }
}

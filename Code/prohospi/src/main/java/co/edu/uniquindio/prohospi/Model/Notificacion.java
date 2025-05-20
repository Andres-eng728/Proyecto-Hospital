package co.edu.uniquindio.prohospi.Model;

public class Notificacion {
    public static void enviar(String mensaje, Persona persona) {
        System.out.println("Notificación a " + persona.getNombre() + ": " + mensaje);
    }
}
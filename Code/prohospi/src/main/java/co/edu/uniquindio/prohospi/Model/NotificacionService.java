package co.edu.uniquindio.prohospi.Model;

import java.util.ArrayList;
import java.util.List;

public class NotificacionService {
    private static final List<Notificacion> notificaciones = new ArrayList<>();

    public static List<Notificacion> obtenerTodas() {
        return new ArrayList<>(notificaciones);
    }

    public static void agregar(Notificacion n) {
        notificaciones.add(n);
    }
}

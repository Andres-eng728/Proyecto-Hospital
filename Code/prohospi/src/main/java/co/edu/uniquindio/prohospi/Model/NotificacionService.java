package co.edu.uniquindio.prohospi.Model;

import java.util.ArrayList;
import java.util.List;

public class NotificacionService {
    private static final List<Notificacion> notificaciones = new ArrayList<>();

    /**
     * metodo que devuelve una copia de la lista de notificaciones
     * @return
     */
    public static List<Notificacion> obtenerTodas() {
        return new ArrayList<>(notificaciones);
    }
    /**
     * metodo que agrega una notificacion
     * @param n
     */
    public static void agregar(Notificacion n) {
        notificaciones.add(n);
    }
}

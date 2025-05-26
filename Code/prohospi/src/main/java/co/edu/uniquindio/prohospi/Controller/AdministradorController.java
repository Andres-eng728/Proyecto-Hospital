package co.edu.uniquindio.prohospi.Controller;

import co.edu.uniquindio.prohospi.Model.Administrador;

import java.util.ArrayList;
import java.util.List;

public class AdministradorController {
    private List<Administrador> administradores = new ArrayList<>();

    public AdministradorController() {
        administradores.add(new Administrador("admin1", "1234","add@","1234","admin1234"));
        administradores.add(new Administrador("admin2", "abcd","add@","124","admin1235"));
        // Agrega todos los administradores que necesites
    }

    public boolean autenticar(String usuario, String contrasena) {
        for (Administrador admin : administradores) {
            if (admin.getusuario().equals(usuario) && admin.getContrasena().equals(contrasena)) {
                return true;
            }
        }
        return false;
    }
}

package co.edu.uniquindio.prohospi.ViewController;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;

public class LoginViewController {

    @FXML
    private TextField usuarioField;

    @FXML
    private PasswordField contrasenaField;

    @FXML
    private void iniciarSesion() {
        String usuario = usuarioField.getText();
        String contrasena = contrasenaField.getText();

        if (usuario.equals("admin") && contrasena.equals("1234")) {
            mostrarAlerta("Inicio de sesión exitoso", "Bienvenido, " + usuario);
        } else {
            mostrarAlerta("Error", "Usuario o contraseña incorrectos");
        }
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}



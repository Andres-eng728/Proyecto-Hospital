package co.edu.uniquindio.prohospi.ViewController;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SeleccionRolViewController {

        public void loginAdministrador(ActionEvent event) throws Exception {
            cargarLogin("administrador");
        }

        public void loginMedico(ActionEvent event) throws Exception {
            cargarLogin("medico");
        }

        public void loginPaciente(ActionEvent event) throws Exception {
            cargarLogin("paciente");
        }

    private void cargarLogin(String rol) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/prohospi/Login.fxml"));
        Parent root = loader.load();

        LoginViewController loginController = loader.getController();
        loginController.setRol(rol); // Pasamos el rol al login

        Stage stage = new Stage();
        stage.setTitle("Login - " + rol);
        stage.setScene(new Scene(root));
        stage.show();
    }
}

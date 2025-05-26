package co.edu.uniquindio.prohospi.ViewController;

import co.edu.uniquindio.prohospi.Controller.AdministradorController;
import co.edu.uniquindio.prohospi.Controller.MedicoController;
import co.edu.uniquindio.prohospi.Controller.PacienteController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginViewController {

    @FXML
    private TextField usuarioField;

    @FXML
    private PasswordField contrasenaField;

    private String rol;

    private AdministradorController adminController = new AdministradorController();
    private MedicoController medicoController = new MedicoController();
    private PacienteController pacienteController = new PacienteController();
    public void setRol(String rol) {
        this.rol = rol;
    }

    private void cargarVista(String ruta, String titulo, Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(ruta));
        stage.setScene(new Scene(loader.load()));
        stage.setTitle(titulo);
        stage.show();
    }



    @FXML
    public void iniciarSesion() throws Exception {

        String usuario = usuarioField.getText();
        String contrasena = contrasenaField.getText();
        Stage stage = new Stage();
        switch (rol) {
            case "administrador":
                if (adminController.autenticar(usuario, contrasena)) {
                    cargarVista("/co/edu/uniquindio/prohospi/Admin.fxml", "Panel Administrador", stage);
                }
                break;
            case "medico":
                if (medicoController.autenticarMedico(usuario, contrasena)) {
                    cargarVista("/co/edu/uniquindio/prohospi/Medico.fxml", "Panel Médico", stage);
                }
                break;
            case "paciente":
                if (pacienteController.autenticarPaciente(usuario, contrasena)) {
                    cargarVista("/co/edu/uniquindio/prohospi/Paciente.fxml", "Panel Paciente", stage);
                }
                break;
        }

        ((Stage) usuarioField.getScene().getWindow()).close();



    }
}
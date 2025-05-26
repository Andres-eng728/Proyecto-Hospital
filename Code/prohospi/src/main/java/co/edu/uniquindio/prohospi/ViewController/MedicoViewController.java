package co.edu.uniquindio.prohospi.ViewController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MedicoViewController {

    @FXML
    private Button btnCerrarSesion;

    @FXML
    private Button btnDiagnostico;

    @FXML
    private Button btnHistoriales;

    @FXML
    private Button btnHorarios;

    @FXML
    private Button btnNotificaciones;

    @FXML
    private Button btnEnviarNoti;

    @FXML
    void administrarHorarios(ActionEvent event) {
        abrirVentana("/co/edu/uniquindio/prohospi/Horarios.fxml", "Horarios de Consulta");

    }

    @FXML
    void cerrarSesion(ActionEvent event) {
        Stage stage = (Stage) btnCerrarSesion.getScene().getWindow();
        stage.close();
    }

    @FXML
    void registrarDiagnostico(ActionEvent event) {
        abrirVentana("/co/edu/uniquindio/prohospi/Diagnostico.fxml", "Registrar Diagnóstico");
    }

    @FXML
    void verHistoriales(ActionEvent event) {
        abrirVentana("/co/edu/uniquindio/prohospi/VerHistorialMedico.fxml", "Historiales Médicos");

    }

    @FXML
    void verNotificaciones(ActionEvent event) {
        abrirVentana("/co/edu/uniquindio/prohospi/VerNotificaciones.fxml", "Notificaciones de Citas");
    }

    public void OnEnviarNoti(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/prohospi/CorreoNoti.fxml"));
            Parent root = fxmlLoader.load();

            Stage stage = new Stage();
            stage.setTitle("Enviar Correo");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace(); // o mostrar un Alert
        }
    }


    private void abrirVentana(String rutaFXML, String titulo) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(rutaFXML));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle(titulo);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

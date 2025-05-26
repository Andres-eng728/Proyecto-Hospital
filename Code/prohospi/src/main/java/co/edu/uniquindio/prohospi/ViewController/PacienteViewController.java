package co.edu.uniquindio.prohospi.ViewController;

import co.edu.uniquindio.prohospi.Model.Notificacion;
import co.edu.uniquindio.prohospi.Model.NotificacionService;
import co.edu.uniquindio.prohospi.Model.Paciente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class PacienteViewController {

    @FXML
    private Button btnCancelarCita;

    @FXML
    private Button btnCerrarSesion;

    @FXML
    private Button btnRegistrarActualizar;

    @FXML
    private Button btnSolicitarCita;

    @FXML
    private Button btnVerHistorial;

    @FXML
    private Button btnVerNotificaciones;

    private String pacienteActual;
    public void setPacienteActual(String pacienteActual) {
        this.pacienteActual = pacienteActual;
    }




    @FXML
    void cerrarSesion(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnCerrarSesion.getScene().getWindow();
        stage.close();
    }



    @FXML
    void registrarActualizarDatos(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/prohospi/DatosPaciente.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Actualizar Datos del Paciente");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void mostrarError(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    @FXML
    void solicitarCita(ActionEvent event) {

            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/prohospi/CitasPaciente.fxml"));
                Parent root = loader.load();

                Stage stage = new Stage();
                stage.setTitle("Gestión de Citas");
                stage.setScene(new Scene(root));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
                mostrarError("No se pudo abrir la ventana de citas.");
            }


    }

    @FXML
    void verHistorial(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/prohospi/VerHistorialMedico.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Historial Medico");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            mostrarError("No se pudo abrir la ventana de Historial.");
        }
    }

    @FXML
    void verNotificaciones(ActionEvent event) {
        Paciente paciente = new Paciente("Andres", "123", "jp@gmail.com", "juanp", "1234");

        // Crear y agregar una notificación asociada a ese paciente
        Notificacion n = new Notificacion("Recuerda tu cita médica mañana a las 9 a.m.", paciente);
        NotificacionService.agregar(n);

        // Cargar y mostrar la vista de notificaciones
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/prohospi/VerNotificaciones.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Notificaciones");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
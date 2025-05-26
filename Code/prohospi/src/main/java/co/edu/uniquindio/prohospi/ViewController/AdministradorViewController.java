package co.edu.uniquindio.prohospi.ViewController;

import co.edu.uniquindio.prohospi.Model.Administrador;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class AdministradorViewController {

    @FXML
    private Button btn_cerrar;

    @FXML
    private Button btn_gesmed;

    @FXML
    private Button btn_gespac;

    @FXML
    private Button btn_gessa;
    private Administrador administrador;

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    @FXML
    void abrirGestionSalas(ActionEvent event) {

    }

    @FXML
    void abririGestionMedicos(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/prohospi/GestionMedicos.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Gestión de Medicos");
            stage.setScene(new Scene(root));
            stage.show();

            // 🔻 Cerramos la ventana actual:
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void abrirGestionPacientes(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/prohospi/Gestionpacientes.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Gestión de Pacientes");
            stage.setScene(new Scene(root));
            stage.show();

            // 🔻 Cerramos la ventana actual:
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void OnEnivarNoti(ActionEvent actionEvent) {
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
}


package co.edu.uniquindio.prohospi.ViewController;
import co.edu.uniquindio.prohospi.Model.Gestor;
import co.edu.uniquindio.prohospi.Model.Paciente;
import co.edu.uniquindio.prohospi.Model.HistorialMedico;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class DiagnosticoViewController  {
    @FXML
    private TextField txtIdPaciente;
    @FXML
    private TextField txtDiagnostico;
    @FXML
    private TextField txtTratamiento;

    @FXML
    private TableView<HistorialMedico> tablaDiagnosticos;
    @FXML
    private TableColumn<HistorialMedico, String> colIdPaciente;
    @FXML
    private TableColumn<HistorialMedico, String> colDiagnostico;
    @FXML
    private TableColumn<HistorialMedico, String> colTratamiento;


    @FXML
    public void initialize() {


        colIdPaciente.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getIdPaciente()));
        colDiagnostico.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getDiagnostico()));
        colTratamiento.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getTratamiento()));

        tablaDiagnosticos.setItems(Gestor.getInstancia().getListaHistoriales());
    }

    @FXML
    public void onGuardarDiagnostico() {
        String id = txtIdPaciente.getText();
        String diagnostico = txtDiagnostico.getText();
        String tratamiento = txtTratamiento.getText();
        String fecha = "20" ;

        if (id.isEmpty() || diagnostico.isEmpty() || tratamiento.isEmpty()) {
            mostrarAlerta("Debe llenar todos los campos.");
            return;
        }

        HistorialMedico historial = new HistorialMedico( diagnostico,tratamiento,fecha  ,id);
        Gestor.getInstancia().getListaHistoriales().add(historial);


        txtIdPaciente.clear();
        txtDiagnostico.clear();
        txtTratamiento.clear();
    }

    private void mostrarAlerta(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Campos incompletos");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    public void volverAdmin(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/prohospi/Medico.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Panel de Administrador");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

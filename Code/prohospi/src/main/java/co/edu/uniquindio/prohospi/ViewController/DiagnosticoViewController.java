package co.edu.uniquindio.prohospi.ViewController;
import co.edu.uniquindio.prohospi.Model.Paciente;
import co.edu.uniquindio.prohospi.Model.HistorialMedico;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.awt.*;

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

    private ObservableList<HistorialMedico> listaHistoriales;

    @FXML
    public void initialize() {
        listaHistoriales = FXCollections.observableArrayList();

        colIdPaciente.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getIdPaciente()));
        colDiagnostico.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getDiagnostico()));
        colTratamiento.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getTratamiento()));

        tablaDiagnosticos.setItems(listaHistoriales);
    }

    @FXML
    public void onGuardarDiagnostico() {
        String id = txtIdPaciente.getText();
        String diagnostico = txtDiagnostico.getText();
        String tratamiento = txtTratamiento.getText();

        if (id.isEmpty() || diagnostico.isEmpty() || tratamiento.isEmpty()) {
            mostrarAlerta("Debe llenar todos los campos.");
            return;
        }

        HistorialMedico historial = new HistorialMedico( diagnostico,tratamiento,"20"  ,id);
        listaHistoriales.add(historial);


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
}

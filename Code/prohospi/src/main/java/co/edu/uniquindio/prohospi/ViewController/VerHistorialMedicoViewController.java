package co.edu.uniquindio.prohospi.ViewController;


import co.edu.uniquindio.prohospi.Model.HistorialMedico;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


public class VerHistorialMedicoViewController  {

    @FXML
    private TableColumn<HistorialMedico, String> colDiagnostico;

    @FXML
    private TableColumn<HistorialMedico, String> colFecha;

    @FXML
    private TableColumn<HistorialMedico, String> colTratamiento;

    @FXML
    private TableView<HistorialMedico> tablaHistorial;

    @FXML
    private javafx.scene.control.Button btnVolver;

    @FXML
    public void initialize() {
        colDiagnostico.setCellValueFactory(new PropertyValueFactory<>("diagnostico"));
        colTratamiento.setCellValueFactory(new PropertyValueFactory<>("tratamiento"));
        colFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));

        // Datos de ejemplo (puedes cargarlos desde tu sistema real)
        ObservableList<HistorialMedico> historial = FXCollections.observableArrayList(
                new HistorialMedico("Gripe", "Paracetamol", "2023-05-01","313213"),
                new HistorialMedico("Fractura", "Yeso", "2023-07-15","15251")
        );

        tablaHistorial.setItems(historial);
    }
    @FXML
    void volverAlMenu(ActionEvent event) {
        Stage stage = (Stage) btnVolver.getScene().getWindow();
        stage.close();
    }

}

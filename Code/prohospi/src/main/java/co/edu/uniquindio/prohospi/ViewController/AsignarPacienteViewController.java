package co.edu.uniquindio.prohospi.ViewController;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class AsignarPacienteViewController {
    @FXML
    private ChoiceBox<String> cbPaciente, cbDia, cbHora, cbMedico;

    @FXML
    private Button btnAsignar;

    @FXML
    private TableView<Asignacion> tablaAsignaciones;

    @FXML
    private TableColumn<Asignacion, String> colPaciente, colMedico;

    private ObservableList<Asignacion> asignaciones = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        cbPaciente.setItems(FXCollections.observableArrayList("Ana", "Luis", "Marta"));
        cbDia.setItems(FXCollections.observableArrayList("Lunes", "Martes", "Miércoles"));
        cbHora.setItems(FXCollections.observableArrayList("08:00", "09:00", "10:00"));
        cbMedico.setItems(FXCollections.observableArrayList("Dr. Pérez", "Dra. Gómez"));

        colPaciente.setCellValueFactory(data -> data.getValue().pacienteProperty());
        colMedico.setCellValueFactory(data -> data.getValue().medicoProperty());

        tablaAsignaciones.setItems(asignaciones);
    }

    @FXML
    public void asignarPaciente(javafx.event.ActionEvent actionEvent) {
        String paciente = cbPaciente.getValue();
        String medico = cbMedico.getValue();

        if (paciente != null && medico != null) {
            asignaciones.add(new Asignacion(paciente, medico));
        }
    }

    public void volverAdmin(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/prohospi/Admin.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Panel de Administrador");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class Asignacion {
        private final javafx.beans.property.SimpleStringProperty paciente;
        private final javafx.beans.property.SimpleStringProperty medico;

        public Asignacion(String paciente, String medico) {
            this.paciente = new javafx.beans.property.SimpleStringProperty(paciente);
            this.medico = new javafx.beans.property.SimpleStringProperty(medico);
        }

        public javafx.beans.property.StringProperty pacienteProperty() {
            return paciente;
        }

        public javafx.beans.property.StringProperty medicoProperty() {
            return medico;
        }
    }
}

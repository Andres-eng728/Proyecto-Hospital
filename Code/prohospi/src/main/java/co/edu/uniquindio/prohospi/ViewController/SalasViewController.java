package co.edu.uniquindio.prohospi.ViewController;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class SalasViewController {

    @FXML
    private TextField txtIdSala, txtTipoSala, txtCapacidad;

    @FXML
    private Button btnRegistrarSala;

    @FXML
    private TableView<Sala> tablaSalas;

    @FXML
    private TableColumn<Sala, String> colIdSala, colTipoSala;

    @FXML
    private TableColumn<Sala, Integer> colCapacidad;

    private ObservableList<Sala> listaSalas = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        colIdSala.setCellValueFactory(data -> data.getValue().idProperty());
        colTipoSala.setCellValueFactory(data -> data.getValue().tipoProperty());
        colCapacidad.setCellValueFactory(data -> data.getValue().capacidadProperty().asObject());

        tablaSalas.setItems(listaSalas);
    }

    @FXML
    public void registrarSala(javafx.event.ActionEvent actionEvent) {
        String id = txtIdSala.getText();
        String tipo = txtTipoSala.getText();
        int capacidad;

        try {
            capacidad = Integer.parseInt(txtCapacidad.getText());
        } catch (NumberFormatException e) {
            System.out.println("Capacidad inválida");
            return;
        }

        listaSalas.add(new Sala(id, tipo, capacidad));

        txtIdSala.clear();
        txtTipoSala.clear();
        txtCapacidad.clear();
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

    public static class Sala {
        private final javafx.beans.property.SimpleStringProperty id;
        private final javafx.beans.property.SimpleStringProperty tipo;
        private final javafx.beans.property.SimpleIntegerProperty capacidad;

        public Sala(String id, String tipo, int capacidad) {
            this.id = new javafx.beans.property.SimpleStringProperty(id);
            this.tipo = new javafx.beans.property.SimpleStringProperty(tipo);
            this.capacidad = new javafx.beans.property.SimpleIntegerProperty(capacidad);
        }

        public javafx.beans.property.StringProperty idProperty() {
            return id;
        }

        public javafx.beans.property.StringProperty tipoProperty() {
            return tipo;
        }

        public javafx.beans.property.IntegerProperty capacidadProperty() {
            return capacidad;
        }
    }
}

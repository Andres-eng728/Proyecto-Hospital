package co.edu.uniquindio.prohospi.ViewController;

import co.edu.uniquindio.prohospi.Model.Gestor;
import co.edu.uniquindio.prohospi.Model.Sala;
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



    @FXML
    public void initialize() {
        colIdSala.setCellValueFactory(data -> data.getValue().idProperty());
        colTipoSala.setCellValueFactory(data -> data.getValue().tipoProperty());
        colCapacidad.setCellValueFactory(data -> data.getValue().capacidadProperty().asObject());

        tablaSalas.setItems(Gestor.getInstancia().getListaSalas());
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
        Sala nuevasala = new Sala(id, tipo, capacidad); // Model.Sala
        Gestor.getInstancia().getListaSalas().add(nuevasala);


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


}


package co.edu.uniquindio.prohospi.ViewController;

import co.edu.uniquindio.prohospi.Model.Administrador;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class GestionPacientesViewController {

    @FXML
    private Button btn_Agregarpaciente;

    @FXML
    private Button btn_actualizarpaciente;

    @FXML
    private Button btn_eliminarpaciente;

    @FXML
    private Button btn_volverad;

    @FXML
    private TableColumn<?, ?> clm_contrapaciente;

    @FXML
    private TableColumn<?, ?> clm_idpaciente;

    @FXML
    private TableColumn<?, ?> clm_nombrepaciente;

    @FXML
    private TableColumn<?, ?> clm_usuaripaciente;

    @FXML
    private Label lbl_contraseñap;

    @FXML
    private Label lbl_idp;

    @FXML
    private Label lbl_nombrep;

    @FXML
    private Label lbl_usuariop;

    @FXML
    private TableView<?> tbv_gestionpacientes;

    @FXML
    private TextField txt_idpaciente;

    @FXML
    private TextField txt_nombrepaciente;
    private Administrador administrador;

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
        // aquí puedes usar sus datos, por ejemplo:
        // nombreAdminLabel.setText(administrador.getNombre());
    }

    @FXML
    void OnActualizarPaciente(ActionEvent event) {

    }

    @FXML
    void OnAgregarpaciente(ActionEvent event) {

    }

    @FXML
    void OnEliminarPaciente(ActionEvent event) {

    }

    @FXML
    void volverAdmin(ActionEvent event) {
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
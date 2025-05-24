package co.edu.uniquindio.prohospi.ViewController;

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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class GestionMedicosViewController {

    @FXML
    private AnchorPane Panemedico;

    @FXML
    private Button btn_AgregarMedico;

    @FXML
    private Button btn_actualizarMedico;

    @FXML
    private Button btn_eliminarMedico;

    @FXML
    private Button btn_volverad;

    @FXML
    private TableColumn<?, ?> clm_contraMedico;

    @FXML
    private TableColumn<?, ?> clm_correoM;

    @FXML
    private TableColumn<?, ?> clm_escialidadM;

    @FXML
    private TableColumn<?, ?> clm_idMedico;

    @FXML
    private TableColumn<?, ?> clm_nombreMedico;

    @FXML
    private TableColumn<?, ?> clm_usuarioMedico;

    @FXML
    private Label lbl_contrañiaM;

    @FXML
    private Label lbl_correoM;

    @FXML
    private Label lbl_especialidadM;

    @FXML
    private Label lbl_idM;

    @FXML
    private Label lbl_nombreM;

    @FXML
    private Label lbl_usuarioM;

    @FXML
    private TableView<?> tbv_gestionMedico;

    @FXML
    private TextField txt_contraseniaM;

    @FXML
    private TextField txt_correoM;

    @FXML
    private TextField txt_especialidadM;

    @FXML
    private TextField txt_idMedico;

    @FXML
    private TextField txt_nombreMedico;

    @FXML
    private TextField txt_usuarioM;

    @FXML
    void OnActualizarMedico(ActionEvent event) {

    }

    @FXML
    void OnAgregarMedico(ActionEvent event) {

    }

    @FXML
    void OnEliminarMedico(ActionEvent event) {

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

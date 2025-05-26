package co.edu.uniquindio.prohospi.ViewController;

import co.edu.uniquindio.prohospi.Model.Administrador;
import co.edu.uniquindio.prohospi.Model.Medico;
import co.edu.uniquindio.prohospi.Model.Paciente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GestionMedicosViewController implements Initializable {

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
    private TableColumn<Medico, String> clm_contraMedico;

    @FXML
    private TableColumn<Medico, String> clm_correoM;

    @FXML
    private TableColumn<Medico, String> clm_escialidadM;

    @FXML
    private TableColumn<Medico, String> clm_idMedico;

    @FXML
    private TableColumn<Medico, String> clm_nombreMedico;

    @FXML
    private TableColumn<Medico, String> clm_usuarioMedico;

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
    private TableView<Medico> tbv_gestionMedico;

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


    private Administrador administrador;
    private ObservableList<Medico> listMedicos = FXCollections.observableArrayList();

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
        // aquí puedes usar sus datos, por ejemplo:
        // nombreAdminLabel.setText(administrador.getNombre());
    }

    public void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText("Resultado de la acción");
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private void limpiarCampos() {
        txt_nombreMedico.clear();
        txt_idMedico.clear();
        txt_correoM.clear();
        txt_usuarioM.clear();
        txt_contraseniaM.clear();
        txt_especialidadM.clear();
    }

    @FXML
    void OnActualizarMedico(ActionEvent event) {
        Medico seleccionado = tbv_gestionMedico.getSelectionModel().getSelectedItem();

        if (seleccionado != null) {
            seleccionado.setNombre(txt_nombreMedico.getText());
            seleccionado.setIdentificacion(txt_idMedico.getText());
            seleccionado.setCorreo(txt_correoM.getText());
            seleccionado.setUsuarioMedico(txt_usuarioM.getText());
            seleccionado.setContrasenaMedico(txt_contraseniaM.getText());
            seleccionado.setEspecialidad(txt_especialidadM.getText());

            tbv_gestionMedico.refresh(); // Refresca la tabla para mostrar los cambios
            mostrarAlerta( "Actualizado","Paciente actualizado exitosamente");
        } else {
            mostrarAlerta("Error", "Debe seleccionar un paciente para actualizar");
        }

    }

    @FXML
    void OnAgregarMedico(ActionEvent event) {
        String nombre = txt_nombreMedico.getText();
        String identificacion = txt_idMedico.getText();
        String correo = txt_correoM.getText();
        String usuarioMedico = txt_usuarioM.getText();
        String contrasenaMedico = txt_contraseniaM.getText();
        String especialidad = txt_especialidadM.getText();

        Medico nuevoMedico = new Medico(nombre, identificacion, correo, contrasenaMedico, usuarioMedico, especialidad);

        listMedicos.add(nuevoMedico);


        limpiarCampos();
        mostrarAlerta("Agregado","Paciente agregado exitosamente");
    }

    @FXML
    void OnEliminarMedico(ActionEvent event) {
        Medico seleccionado = tbv_gestionMedico.getSelectionModel().getSelectedItem();

        if (seleccionado != null) {
            listMedicos.remove(seleccionado);
            mostrarAlerta("Eliminado", "Paciente eliminado exitosamente");
        } else {
            mostrarAlerta("Error","Debe seleccionar un paciente para eliminar");
        }
        limpiarCampos();
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        clm_idMedico.setCellValueFactory(new PropertyValueFactory<>("identificacion"));
        clm_nombreMedico.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        clm_usuarioMedico.setCellValueFactory(new PropertyValueFactory<>("usuarioMedico"));
        clm_contraMedico.setCellValueFactory(new PropertyValueFactory<>("contrasenaMedico"));
        clm_correoM.setCellValueFactory(new PropertyValueFactory<>("correo"));
        clm_escialidadM.setCellValueFactory(new PropertyValueFactory<>("especialidad"));

        tbv_gestionMedico.setItems(listMedicos);
        listMedicos.add(new Medico("Andrés", "123", "andres@email.com", "Citugia", "andresu14","1234141"));
        tbv_gestionMedico.getSelectionModel().selectedItemProperty().addListener((obs, oldSel, newSel) -> {
            if (newSel != null) {
                txt_nombreMedico.setText(newSel.getNombre());
                txt_idMedico.setText(newSel.getIdentificacion());
                txt_correoM.setText(newSel.getCorreo());
                txt_usuarioM.setText(newSel.getUsuarioMedico());
                txt_contraseniaM.setText(newSel.getContrasenaMedico());
                txt_especialidadM.setText(newSel.getEspecialidad());
            }
        });
    }
}

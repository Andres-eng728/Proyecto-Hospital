
package co.edu.uniquindio.prohospi.ViewController;

import co.edu.uniquindio.prohospi.Model.Administrador;
import co.edu.uniquindio.prohospi.Model.GestorPacientes;
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
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class GestionPacientesViewController implements Initializable {


    @FXML
    private Button btn_Agregarpaciente;

    @FXML
    private Button btn_actualizarpaciente;

    @FXML
    private Button btn_eliminarpaciente;

    @FXML
    private Button btn_volverad;

    @FXML
    private TableColumn<Paciente, String> clm_contrapaciente;

    @FXML
    private TableColumn<Paciente, String> clm_idpaciente;

    @FXML
    private TableColumn<Paciente, String> clm_nombrepaciente;

    @FXML
    private TableColumn<Paciente, String> clm_usuaripaciente;
    @FXML
    private TableColumn<Paciente, String> clm_correoP;
    @FXML
    private Label lbl_contraseñap;

    @FXML
    private Label lbl_idp;

    @FXML
    private Label lbl_nombrep;

    @FXML
    private Label lbl_usuariop;

    @FXML
    private TableView<Paciente> tbv_gestionpacientes;


    @FXML
    private TextField txt_contraseniaP;

    @FXML
    private TextField txt_correop;

    @FXML
    private TextField txt_idpaciente;

    @FXML
    private TextField txt_nombrepaciente;

    @FXML
    private TextField txt_usuarioP;
    private Administrador administrador;
    String mensaje;
    String titulo;


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
        txt_nombrepaciente.clear();
        txt_idpaciente.clear();
        txt_correop.clear();
        txt_usuarioP.clear();
        txt_contraseniaP.clear();
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
    public void initialize(URL url, ResourceBundle rb) {
        cargarPacientesDesdeArchivoSerializado();
        tbv_gestionpacientes.setItems(GestorPacientes.getInstancia().getPacientes());

        clm_idpaciente.setCellValueFactory(new PropertyValueFactory<>("identificacion"));
        clm_nombrepaciente.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        clm_usuaripaciente.setCellValueFactory(new PropertyValueFactory<>("usuarioPaciente"));
        clm_contrapaciente.setCellValueFactory(new PropertyValueFactory<>("contrasenaPaciente"));
        clm_correoP.setCellValueFactory(new PropertyValueFactory<>("correo"));

        tbv_gestionpacientes.setItems(GestorPacientes.getInstancia().getPacientes());

        tbv_gestionpacientes.getSelectionModel().selectedItemProperty().addListener((obs, oldSel, newSel) -> {
            if (newSel != null) {
                txt_nombrepaciente.setText(newSel.getNombre());
                txt_idpaciente.setText(newSel.getIdentificacion());
                txt_correop.setText(newSel.getCorreo());
                txt_usuarioP.setText(newSel.getUsuarioPaciente());
                txt_contraseniaP.setText(newSel.getContrasenaPaciente());
            }
        });
        tbv_gestionpacientes.setItems(GestorPacientes.getInstancia().getPacientes());
    }
    @FXML
    void OnAgregarpaciente(ActionEvent event) {
        String nombre = txt_nombrepaciente.getText();
        String identificacion = txt_idpaciente.getText();
        String correo = txt_correop.getText();
        String usuario = txt_usuarioP.getText();
        String contrasena = txt_contraseniaP.getText();

        Paciente nuevoPaciente = new Paciente(nombre, identificacion, correo, contrasena, usuario);


        GestorPacientes.getInstancia().getPacientes().add(nuevoPaciente);
        guardarPacientesEnArchivoSerializado();

        limpiarCampos();
        mostrarAlerta("Agregado","Paciente agregado exitosamente");
    }
    @FXML
    void OnEliminarPaciente(ActionEvent event) {
        Paciente seleccionado = tbv_gestionpacientes.getSelectionModel().getSelectedItem();

        if (seleccionado != null) {
            GestorPacientes.getInstancia().eliminarPaciente(seleccionado);
            tbv_gestionpacientes.getItems().remove(seleccionado);

            try {
                ObservableList<Paciente> listaObservable = GestorPacientes.getInstancia().getPacientes();
                List<Paciente> pacientesSerializables = new ArrayList<>();
                pacientesSerializables.addAll(listaObservable);
                Persistencia.serializarObjeto("Data\\BaseDatos", pacientesSerializables);

                mostrarAlerta("Eliminado", "Paciente eliminado exitosamente");
            } catch (IOException e) {
                mostrarAlerta("Error", "Error al guardar los datos: " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            mostrarAlerta("Error", "Debe seleccionar un paciente para eliminar");
        }
        limpiarCampos();
    }
    @FXML
    void OnActualizarPaciente(ActionEvent event) {
        Paciente seleccionado = tbv_gestionpacientes.getSelectionModel().getSelectedItem();

        if (seleccionado != null) {
            seleccionado.setNombre(txt_nombrepaciente.getText());
            seleccionado.setIdentificacion(txt_idpaciente.getText());
            seleccionado.setCorreo(txt_correop.getText());
            seleccionado.setUsuarioPaciente(txt_usuarioP.getText());
            seleccionado.setContrasenaPaciente(txt_contraseniaP.getText());

            tbv_gestionpacientes.refresh(); // Refresca la tabla para mostrar los cambios
            mostrarAlerta( "Actualizado","Paciente actualizado exitosamente");

            guardarPacientesEnArchivoSerializado();
        } else {
            mostrarAlerta("Error", "Debe seleccionar un paciente para actualizar");
        }

    }
    private void guardarPacientesEnArchivoSerializado () {
        System.out.println("Pacientes en lista: " + GestorPacientes.getInstancia().getPacientes().size());

        try {
            ObservableList<Paciente> listaObservable = GestorPacientes.getInstancia().getPacientes();
            List<Paciente> pacientesSerializables = new ArrayList<>();
            pacientesSerializables.addAll(listaObservable);
            Persistencia.serializarObjeto("Data\\BaseDatos", pacientesSerializables);            System.out.println("Pacientes guardados en Base datos.txt");
        } catch (IOException e) {
            System.err.println("Error al guardar Pacientes:");
            e.printStackTrace();
        }
    }

    private void cargarPacientesDesdeArchivoSerializado() {
        try {
            Object obj = Persistencia.deserializarObjeto("Data\\BaseDatos.txt");
            if (obj instanceof ArrayList<?>) {
                GestorPacientes.getInstancia().getPacientes().clear();
                GestorPacientes.getInstancia().getPacientes().addAll((ArrayList<Paciente>) obj);
                System.out.println("Pacientes cargados desde Base datos.txt");
            }
        } catch (Exception e) {
            System.err.println("Error al cargar Pacientes:");
            e.printStackTrace();
   }
}

}
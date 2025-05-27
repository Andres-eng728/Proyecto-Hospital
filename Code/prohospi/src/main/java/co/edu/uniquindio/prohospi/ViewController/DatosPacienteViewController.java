package co.edu.uniquindio.prohospi.ViewController;

import co.edu.uniquindio.prohospi.Model.Gestor;
import co.edu.uniquindio.prohospi.Model.Medico;
import co.edu.uniquindio.prohospi.Model.Paciente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class DatosPacienteViewController  implements Initializable {

    @FXML
    private Button btn_Actualizarp;

    @FXML
    private Button btn_eliminarp;

    @FXML
    private Button btn_guardarp;

    @FXML
    private TableColumn<Paciente, String> colContraseña;

    @FXML
    private TableColumn<Paciente, String> colCorreo;

    @FXML
    private TableColumn<Paciente, String> colDocumento;

    @FXML
    private TableColumn<Paciente, String> colNombre;

    @FXML
    private TableColumn<Paciente, String> colUsuario;

    @FXML
    private TableView<Paciente> tablaPacientes;

    @FXML
    private PasswordField txtContrasenia;

    @FXML
    private TextField txtCorreo;

    @FXML
    private TextField txtDocumento;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtUsuario;


    public void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText("Resultado de la acción");
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private void limpiarCampos() {
        txtNombre.clear();
        txtDocumento.clear();
        txtCorreo.clear();
        txtUsuario.clear();
        txtContrasenia.clear();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cargarPacientesDesdeArchivoSerializado();
        tablaPacientes.setItems(Gestor.getInstancia().getPacientes());
        colDocumento.setCellValueFactory(new PropertyValueFactory<>("identificacion"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colUsuario.setCellValueFactory(new PropertyValueFactory<>("usuarioPaciente"));
        colContraseña.setCellValueFactory(new PropertyValueFactory<>("contrasenaPaciente"));
        colCorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));

        tablaPacientes.setItems(Gestor.getInstancia().getPacientes());
        tablaPacientes.getSelectionModel().selectedItemProperty().addListener((obs, oldSel, newSel) -> {
            if (newSel != null) {
                txtNombre.setText(newSel.getNombre());
                txtDocumento.setText(newSel.getIdentificacion());
                txtCorreo.setText(newSel.getCorreo());
                txtUsuario.setText(newSel.getUsuarioPaciente());
                txtContrasenia.setText(newSel.getContrasenaPaciente());
            }
        });
    }

    @FXML
    void actualizarPaciente(ActionEvent event) {
        Paciente seleccionado = tablaPacientes.getSelectionModel().getSelectedItem();

        if (seleccionado != null) {
            seleccionado.setNombre(txtNombre.getText());
            seleccionado.setIdentificacion(txtDocumento.getText());
            seleccionado.setCorreo(txtCorreo.getText());
            seleccionado.setUsuarioPaciente(txtUsuario.getText());
            seleccionado.setContrasenaPaciente(txtContrasenia.getText());

            tablaPacientes.refresh(); // Refresca la tabla para mostrar los cambios
            mostrarAlerta( "Actualizado","Paciente actualizado exitosamente");

            guardarPacientesEnArchivoSerializado();
        } else {
            mostrarAlerta("Error", "Debe seleccionar un paciente para actualizar");
        }

    }
    private void guardarPacientesEnArchivoSerializado () {
        System.out.println("Pacientes en lista: " + Gestor.getInstancia().getPacientes().size());

        try {
            ObservableList<Paciente> listaObservable = Gestor.getInstancia().getPacientes();
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
                Gestor.getInstancia().getPacientes().clear();
                Gestor.getInstancia().getPacientes().addAll((ArrayList<Paciente>) obj);
                System.out.println("Pacientes cargados desde Base datos.txt");
            }
        } catch (Exception e) {
            System.err.println("Error al cargar Pacientes:");
            e.printStackTrace();
        }


    }

}

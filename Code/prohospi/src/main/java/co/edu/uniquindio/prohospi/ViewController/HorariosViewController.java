package co.edu.uniquindio.prohospi.ViewController;


import co.edu.uniquindio.prohospi.Model.Gestor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HorariosViewController {

    @FXML
    private ChoiceBox<String> cbDia;

    @FXML
    private TextField txtHoraInicio;

    @FXML
    private TextField txtHoraFin;

    @FXML
    private ListView<String> listaHorarios;



    @FXML
    public void initialize() {
        listaHorarios.setItems(Gestor.getInstancia().getHorarios());
    }

    @FXML
    private void agregarHorario() {
        String dia = cbDia.getValue();
        String horaInicio = txtHoraInicio.getText();
        String horaFin = txtHoraFin.getText();

        if (dia == null || horaInicio.isBlank() || horaFin.isBlank()) {
            mostrarAlerta("Campos incompletos", "Por favor complete todos los campos.");
            return;
        }

        String horario = dia + ": " + horaInicio + " - " + horaFin;
        Gestor.getInstancia().getHorarios().add(horario);

        // Limpiar campos
        cbDia.setValue(null);
        txtHoraInicio.clear();
        txtHoraFin.clear();
    }

    @FXML
    private void guardarHorarios() {
        if (Gestor.getInstancia().getHorarios().isEmpty()) {
            mostrarAlerta("Sin horarios", "Debe agregar al menos un horario.");
            return;
        }

        // Aquí podrías guardar los horarios a una base de datos, archivo, etc.
        System.out.println("Horarios guardados:");
        for (String horario : Gestor.getInstancia().getHorarios()) {
            System.out.println(horario);
        }

        mostrarAlerta("Éxito", "Horarios guardados correctamente.");
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
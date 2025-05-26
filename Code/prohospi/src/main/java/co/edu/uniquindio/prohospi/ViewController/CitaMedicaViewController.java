package co.edu.uniquindio.prohospi.ViewController;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;


import java.time.LocalDate;

public class CitaMedicaViewController {
    @FXML
    private ComboBox<String> cbEspecialidades;

    @FXML
    private ComboBox<String> cbMedicos;

    @FXML
    private DatePicker dpFechaCita;

    @FXML
    private TableView<Cita> tablaCitas;

    @FXML
    private TableColumn<Cita, LocalDate> colFecha;

    @FXML
    private TableColumn<Cita, String> colHora;

    @FXML
    private TableColumn<Cita, String> colMedico;

    @FXML
    private Button btnCancelarCita;

    // Lista de citas del paciente
    private ObservableList<Cita> listaCitas = FXCollections.observableArrayList();

    public void initialize() {
        // Inicializar combos con datos (pueden venir de DB)
        cbEspecialidades.setItems(FXCollections.observableArrayList(
                "Medicina General", "Pediatría", "Dermatología", "Cardiología"
        ));
        cbEspecialidades.getSelectionModel().selectFirst();

        cbMedicos.setItems(FXCollections.observableArrayList(
                "Dr. Pérez", "Dra. Gómez", "Dr. Martínez"
        ));
        cbMedicos.getSelectionModel().selectFirst();

        // Configurar columnas tabla
        colFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        colHora.setCellValueFactory(new PropertyValueFactory<>("hora"));
        colMedico.setCellValueFactory(new PropertyValueFactory<>("medico"));

        // Ejemplo de citas precargadas
        listaCitas.addAll(
                new Cita(LocalDate.now().plusDays(1), "10:00 AM", "Dr. Pérez"),
                new Cita(LocalDate.now().plusDays(3), "2:00 PM", "Dra. Gómez")
        );

        tablaCitas.setItems(listaCitas);

        // Inicialmente botón cancelar deshabilitado
        btnCancelarCita.setDisable(true);

        // Detectar selección en tabla para activar botón cancelar
        tablaCitas.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            btnCancelarCita.setDisable(newSelection == null);
        });
    }



    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    public void solicitarCita(javafx.event.ActionEvent actionEvent) {
        LocalDate fecha = dpFechaCita.getValue();
        String especialidad = cbEspecialidades.getValue();

        String medico = cbMedicos.getEditor().getText();

        if (fecha == null) {
            mostrarAlerta("Error", "Debe seleccionar una fecha para la cita.");
            return;
        }
        if (fecha.isBefore(LocalDate.now())) {
            mostrarAlerta("Error", "La fecha debe ser igual o posterior a hoy.");
            return;
        }



        String horaEjemplo = "9:00 AM"; // En app real, seleccionable o generado

        Cita nuevaCita = new Cita(fecha, horaEjemplo, medico);
        listaCitas.add(nuevaCita);

        mostrarAlerta("Éxito", "Cita solicitada para el " + fecha.toString());


        dpFechaCita.setValue(null);
    }

    public void cancelarCita(javafx.event.ActionEvent actionEvent) {
        Cita citaSeleccionada = tablaCitas.getSelectionModel().getSelectedItem();

        if (citaSeleccionada == null) {
            mostrarAlerta("Error", "Debe seleccionar una cita para cancelar.");
            return;
        }


        listaCitas.remove(citaSeleccionada);
        mostrarAlerta("Éxito", "Cita cancelada para el " + citaSeleccionada.getFecha().toString());
    }

    // Clase anidada para representar una cita
    public static class Cita {
        private final LocalDate fecha;
        private final String hora;
        private final String medico;

        public Cita(LocalDate fecha, String hora, String medico) {
            this.fecha = fecha;
            this.hora = hora;
            this.medico = medico;
        }

        public LocalDate getFecha() {
            return fecha;
        }

        public String getHora() {
            return hora;
        }

        public String getMedico() {
            return medico;
        }
    }
}

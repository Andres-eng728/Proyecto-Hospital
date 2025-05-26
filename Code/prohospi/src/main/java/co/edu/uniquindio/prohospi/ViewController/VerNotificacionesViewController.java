package co.edu.uniquindio.prohospi.ViewController;

import co.edu.uniquindio.prohospi.Model.Notificacion;
import co.edu.uniquindio.prohospi.Model.Persona;
import co.edu.uniquindio.prohospi.Model.NotificacionService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class VerNotificacionesViewController implements Initializable {
    @FXML
    private Button btnVolver;
    @FXML
    private ListView<Notificacion> listaNotificaciones;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listaNotificaciones.getItems().clear(); // limpia antes

        List<Notificacion> originales = NotificacionService.obtenerTodas();

        // Si aún así vienen duplicadas, puedes eliminar duplicados aquí:
        List<Notificacion> sinDuplicados = originales.stream()
                .distinct()
                .collect(Collectors.toList());

        ObservableList<Notificacion> notificaciones = FXCollections.observableArrayList(sinDuplicados);
        System.out.println("Notificaciones crudas:");
        NotificacionService.obtenerTodas().forEach(n -> System.out.println(n));

        listaNotificaciones.setItems(notificaciones);
    }

    @FXML
    void volverAlMenu(ActionEvent event) {
        // Código para volver al menú principal
        Stage stage = (Stage) btnVolver.getScene().getWindow();
        stage.close();
    }
}

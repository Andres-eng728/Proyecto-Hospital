package co.edu.uniquindio.prohospi.ViewController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class ReportesViewController {

    @FXML
    private Button btnReporteCitas, btnReporteOcupacion;

    @FXML
    private TextArea areaResultados;

    @FXML
    public void generarReporteCitas(javafx.event.ActionEvent actionEvent) {
        StringBuilder sb = new StringBuilder();
        sb.append("📅 Reporte de Citas:\n");
        sb.append("Paciente: Ana | Médico: Dr. Pérez | Fecha: Lunes 08:00\n");
        sb.append("Paciente: Luis | Médico: Dra. Gómez | Fecha: Martes 09:00\n");
        sb.append("Paciente: Marta | Médico: Dr. Pérez | Fecha: Miércoles 10:00\n");

        areaResultados.setText(sb.toString());
    }

    @FXML
    public void generarReporteOcupacion(javafx.event.ActionEvent actionEvent) {
        StringBuilder sb = new StringBuilder();
        sb.append("🏥 Reporte de Ocupación de Salas:\n");
        sb.append("Sala A1: 80% ocupada\n");
        sb.append("Sala B2: 60% ocupada\n");
        sb.append("Sala C3: 100% ocupada\n");

        areaResultados.setText(sb.toString());
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


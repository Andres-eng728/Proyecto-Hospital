package co.edu.uniquindio.prohospi.ViewController;



import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ReportesViewController {

    @FXML
    private Button btnReporteCitas, btnReporteOcupacion;

    @FXML
    private TextArea areaResultados;

    @FXML
    public void generarReporteCitas(javafx.event.ActionEvent actionEvent) {
        areaResultados.setText("Generando reporte de citas...");
    }

    @FXML
    public void generarReporteOcupacion(javafx.event.ActionEvent actionEvent) {
        areaResultados.setText("Generando reporte de ocupación...");
    }
}


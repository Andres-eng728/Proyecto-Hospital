package co.edu.uniquindio.prohospi.Model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.time.LocalDateTime;

public class Main extends  Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/co/edu/uniquindio/prohospi/SeleccionRol.fxml"));
        primaryStage.setTitle("Selecciona tu rol");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
        Medico medico = new Medico("Dra. López", "M123", "lopez@hospital.com", "Cardiología","medico1234","4567");
        Paciente paciente = new Paciente("Juan Pérez", "P456", "juan@correo.com","142","paciente32");
        Sala sala = new Sala("S001", "Sala de Cardiología",34);

        medico.registrarDiagnostico(paciente, "Hipertensión leve");
        paciente.verHistorial();




    }


}
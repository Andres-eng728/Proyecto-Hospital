package co.edu.uniquindio.prohospi.Model;

import co.edu.uniquindio.prohospi.Model.Medico;
import co.edu.uniquindio.prohospi.Model.Paciente;
import co.edu.uniquindio.prohospi.Model.Sala;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.time.LocalDateTime;

public class Main extends  Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/prohospi/Login.fxml"));
        Parent root = loader.load();

        primaryStage.setTitle("Hospital UQ - Login");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
        Medico medico = new Medico("Dra. López", "M123", "lopez@hospital.com", "Cardiología");
        Paciente paciente = new Paciente("Juan Pérez", "P456", "juan@correo.com");
        Sala sala = new Sala("S001", "Sala de Cardiología");
        CitaMedica cita = new CitaMedica(LocalDateTime.now().plusDays(1), medico, paciente, sala);

        paciente.solicitarCita(cita);
        medico.registrarDiagnostico(paciente, "Hipertensión leve");
        paciente.verHistorial();




    }


}
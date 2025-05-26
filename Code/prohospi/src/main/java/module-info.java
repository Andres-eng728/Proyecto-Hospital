module co.edu.uniquindio.prohospi {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires jakarta.mail;
    requires java.desktop;


    exports co.edu.uniquindio.prohospi.Model;
    exports co.edu.uniquindio.prohospi.Controller;
    exports co.edu.uniquindio.prohospi.ViewController;

    // Permitir acceso reflexivo desde FXML a los controladores si usas JavaFX
    opens co.edu.uniquindio.prohospi.Controller to javafx.fxml;
    opens co.edu.uniquindio.prohospi.ViewController to javafx.fxml;
}
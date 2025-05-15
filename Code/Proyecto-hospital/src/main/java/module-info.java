module co.edu.uniquindio.hospital {
    requires javafx.controls;
    requires javafx.fxml;

    opens co.edu.uniquindio.hospital.Controller to javafx.fxml;
    opens co.edu.uniquindio.hospital.Viewcontroller to javafx.fxml;
    opens co.edu.uniquindio.hospital to javafx.fxml;
    exports co.edu.uniquindio.hospital.Model;

}
module com.example.registrocolaboradores {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.registrocolaboradores to javafx.fxml;
    opens com.example.registrocolaboradores.controllers to javafx.fxml;
    exports com.example.registrocolaboradores;
}

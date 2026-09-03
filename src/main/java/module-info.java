module com.example.registrocolaboradores {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;

    opens com.example.registrocolaboradores to javafx.base, javafx.fxml;
    opens com.example.registrocolaboradores.controllers to javafx.fxml, javafx.base;
    opens com.example.registrocolaboradores.models to javafx.base;
    exports com.example.registrocolaboradores;
}

module com.example.registrocolaboradores {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;


    opens com.example.registrocolaboradores to javafx.fxml;
    exports com.example.registrocolaboradores;
}
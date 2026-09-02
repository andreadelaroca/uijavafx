package com.example.registrocolaboradores.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

public class MatriculaController {
    @FXML private TextField txtNombres;
    @FXML private TextField txtApellidos;
    @FXML private TextField txtUsuario;
    @FXML private PasswordField pwPassword;
    @FXML private DatePicker dpFechaNac;
    @FXML private ComboBox cbDepartamento;
    @FXML private ListView lwCurso;
    @FXML private RadioButton rbModalidad;
    @FXML private CheckBox cbHorario;
    @FXML private CheckBox cbAceptarNormas;
    @FXML private ImageView imgLogo;
    @FXML private Button btnLogin;

    @FXML
    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle(titulo);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}

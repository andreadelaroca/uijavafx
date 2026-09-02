package com.example.registrocolaboradores.controllers;

import com.example.registrocolaboradores.models.Curso;
import com.example.registrocolaboradores.models.Usuario;
import com.example.registrocolaboradores.utils.CursoCRUD;
import com.example.registrocolaboradores.utils.UsuarioCRUD;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class MatriculaController implements Initializable {
    @FXML private TextField txtNombres;
    @FXML private TextField txtApellidos;
    @FXML private TextField txtUsuario;
    @FXML private PasswordField pwPassword;
    @FXML private DatePicker dpFechaNac;
    @FXML private ComboBox<String> cbDepartamento;
    @FXML private ListView<String> lwCurso;

    @FXML private ToggleGroup tgModalidad;
    @FXML private RadioButton rbPresencial;
    @FXML private RadioButton rbVirtual;

    @FXML private CheckBox cbHorario;
    @FXML private CheckBox cbAceptarNormas;
    @FXML private ImageView imgLogo;

    //Botones
    @FXML private Button btnRegistrar;
    @FXML private Button btnActualizar;
    @FXML private Button btnEliminar;

    //Tabla
    @FXML private TableView<Usuario> tablaUsuarios;
    @FXML private TableColumn<Usuario, String> colNombres;
    @FXML private TableColumn<Usuario, String> colApellidos;
    @FXML private TableColumn<Usuario, String> colUsuario;
    @FXML private TableColumn<Usuario, LocalDate> colFechaNac;
    @FXML private TableColumn<Usuario, String > colDepartamento;

    private final UsuarioCRUD usuarioCRUD = new UsuarioCRUD();
    private final CursoCRUD cursoCRUD = new CursoCRUD();

    private final ObservableList<Usuario> usuariosObservable = FXCollections.observableArrayList();
    private final ObservableList<Curso> cursosObservable = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cbDepartamento.setItems(FXCollections.observableArrayList("Managua", "León", "Granada", "Masaya", "Carazo", "Chinandega", "Estelí"));
    }

    @FXML
    protected void agregarOnClick() {
        String nombres = txtNombres.getText().trim();
        String apellidos = txtApellidos.getText().trim();
        String usuario = txtUsuario.getText().trim();
        String password = pwPassword.getText().trim();
        LocalDate fechaNac = dpFechaNac.getValue();
        String departamento = cbDepartamento.getValue();
    }

    private void validarCampos() {

    }

    private void limpiarCampos() {
        txtNombres.clear();
        txtApellidos.clear();
        txtUsuario.clear();
        pwPassword.clear();
        dpFechaNac.setValue(null);
        txtNombres.requestFocus();
    }

    @FXML
    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle(titulo);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}

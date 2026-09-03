package com.example.registrocolaboradores.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import lombok.Data;

public class MatriculaController {
    @FXML
    private TextField nombresTextField;
    @FXML
    private TextField apellidosTextField;
    @FXML
    private TextField usuarioTextField;
    @FXML
    private PasswordField contrasenaPasswordField;
    @FXML
    private DatePicker fechaNacimientoDatePicker;
    @FXML
    private ComboBox<String> departamentoComboBox;
    @FXML
    private ListView<String> cursoListView;
    @FXML
    private RadioButton presencialRadioButton;
    @FXML
    private RadioButton virtualRadioButton;
    @FXML
    private ToggleGroup modalidadToggleGroup;
    @FXML
    private CheckBox matutinoCheckBox;
    @FXML
    private CheckBox vespertinoCheckBox;
    @FXML
    private CheckBox sabatinoCheckBox;
    @FXML
    private CheckBox normasCheckBox;
    @FXML
    private TableView<MatriculaTabla> matriculaTableView;
    @FXML
    private TableColumn<MatriculaTabla, String> nombresColumn;
    @FXML
    private TableColumn<MatriculaTabla, String> apellidosColumn;
    @FXML
    private TableColumn<MatriculaTabla, String> departamentoColumn;
    @FXML
    private TableColumn<MatriculaTabla, String> cursoColumn;
    @FXML
    private TableColumn<MatriculaTabla, String> modalidadColumn;
    @FXML
    private TableColumn<MatriculaTabla, String> horarioColumn;
    @FXML
    private TableColumn<MatriculaTabla, String> fechaNacimientoColumn;

    private final ObservableList<MatriculaTabla> matriculas =FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        departamentoComboBox.setItems(FXCollections.observableArrayList(
                "Boaco",
                "Carazo",
                "Chinandega",
                "Chontales",
                "Esteli",
                "Granada",
                "Jinotega",
                "Leon",
                "Madriz",
                "Managua",
                "Masaya",
                "Matagalpa",
                "Nueva Segovia",
                "Rivas",
                "Rio San Juan",
                "Region Autonoma de la Costa Caribe Norte",
                "Region Autonoma de la Costa Caribe Sur"
        ));

        cursoListView.setItems(FXCollections.observableArrayList(
                "Programacion",
                "Excel",
                "Redes",
                "Diseno grafico"
        ));

        nombresColumn.setCellValueFactory(new PropertyValueFactory<>("nombres"));
        apellidosColumn.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
        departamentoColumn.setCellValueFactory(new PropertyValueFactory<>("departamento"));
        cursoColumn.setCellValueFactory(new PropertyValueFactory<>("curso"));
        modalidadColumn.setCellValueFactory(new PropertyValueFactory<>("modalidad"));
        horarioColumn.setCellValueFactory(new PropertyValueFactory<>("horario"));
        fechaNacimientoColumn.setCellValueFactory(new PropertyValueFactory<>("fechaNacimiento"));

        matriculaTableView.setItems(matriculas);
    }

    @FXML
    private void registrarMatricula() {
        String error = validarCampos();
        if (!error.isEmpty()) {
            mostrarAlerta(error);
            return;
        }

        String nombres = nombresTextField.getText().trim();
        String apellidos = apellidosTextField.getText().trim();
        String departamento = departamentoComboBox.getValue();
        String curso = cursoListView.getSelectionModel().getSelectedItem();
        String modalidad = presencialRadioButton.isSelected() ? "Presencial" : "Virtual";
        String horario = obtenerHorario();
        String fechaNacimiento = fechaNacimientoDatePicker.getValue().toString();

        MatriculaTabla matriculaTabla = new MatriculaTabla(
                nombres,
                apellidos,
                departamento,
                curso,
                modalidad,
                horario,
                fechaNacimiento
        );

        matriculas.add(matriculaTabla);
        limpiarCampos();
    }

    @FXML
    private void limpiarCampos() {
        nombresTextField.clear();
        apellidosTextField.clear();
        usuarioTextField.clear();
        contrasenaPasswordField.clear();
        fechaNacimientoDatePicker.setValue(null);
        departamentoComboBox.getSelectionModel().clearSelection();
        cursoListView.getSelectionModel().clearSelection();
        modalidadToggleGroup.selectToggle(null);
        matutinoCheckBox.setSelected(false);
        vespertinoCheckBox.setSelected(false);
        sabatinoCheckBox.setSelected(false);
        normasCheckBox.setSelected(false);
    }

    private String validarCampos() {
        StringBuilder errores = new StringBuilder();

        if (nombresTextField.getText().trim().isEmpty()) {
            errores.append("Ingrese los nombres.\n");
        }

        if (apellidosTextField.getText().trim().isEmpty()) {
            errores.append("Ingrese los apellidos.\n");
        }

        if (usuarioTextField.getText().trim().isEmpty()) {
            errores.append("Ingrese el usuario.\n");
        } else if (usuarioTextField.getText().trim().length() < 5) {
            errores.append("El usuario debe tener al menos 5 caracteres.\n");
        }

        if (contrasenaPasswordField.getText().isEmpty()) {
            errores.append("Ingrese la contrasena.\n");
        } else if (contrasenaPasswordField.getText().length() < 8) {
            errores.append("La contrasena debe tener al menos 8 caracteres.\n");
        }

        if (fechaNacimientoDatePicker.getValue() == null) {
            errores.append("Seleccione la fecha de nacimiento.\n");
        }

        if (departamentoComboBox.getValue() == null) {
            errores.append("Seleccione un departamento.\n");
        }

        if (cursoListView.getSelectionModel().getSelectedItem() == null) {
            errores.append("Seleccione un curso.\n");
        }

        if (modalidadToggleGroup.getSelectedToggle() == null) {
            errores.append("Seleccione la modalidad.\n");
        }

        if (!matutinoCheckBox.isSelected() && !vespertinoCheckBox.isSelected() && !sabatinoCheckBox.isSelected()) {
            errores.append("Seleccione al menos un horario.\n");
        }

        if (!normasCheckBox.isSelected()) {
            errores.append("Debe aceptar las normas del centro.\n");
        }

        return errores.toString();
    }

    private String obtenerHorario() {
        StringBuilder horario = new StringBuilder();

        if (matutinoCheckBox.isSelected()) {
            horario.append("Matutino");
        }

        if (vespertinoCheckBox.isSelected()) {
            if (!horario.isEmpty()) {
                horario.append(", ");
            }
            horario.append("Vespertino");
        }

        if (sabatinoCheckBox.isSelected()) {
            if (!horario.isEmpty()) {
                horario.append(", ");
            }
            horario.append("Sabatino");
        }

        return horario.toString();
    }

    private void mostrarAlerta(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Errores de validacion");
        alert.setHeaderText("Revise los datos ingresados");
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    @Data
    public static class MatriculaTabla {
        private final String nombres;
        private final String apellidos;
        private final String departamento;
        private final String curso;
        private final String modalidad;
        private final String horario;
        private final String fechaNacimiento;

        public MatriculaTabla(String nombres, String apellidos, String departamento, String curso, String modalidad, String horario, String fechaNacimiento) {

            this.nombres = nombres;
            this.apellidos = apellidos;
            this.departamento = departamento;
            this.curso = curso;
            this.modalidad = modalidad;
            this.horario = horario;
            this.fechaNacimiento = fechaNacimiento;
        }
    }


}

package controller;

import bo.BOFactory;
import bo.custom.RegisterStudentsBO;
import com.jfoenix.controls.JFXButton;
import dto.ProgramDTO;
import dto.StudentDTO;
import dto.StudentProgramDTO;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class RegisterStudentsViewController {

    public TextField txtStudentId;
    public TextField txtName;
    public TextField txtDOB;
    public TextField txtNIC;
    public TextField txtAddress;
    public TextField txtContact;
    public TextField txtEmail;
    public ComboBox<String> cmbProgramId;
    public TextField txtProgram;
    public TextField txtDuration;
    public TextField txtFee;
    public JFXButton btnRegister;

    RegisterStudentsBO registerStudentsBO=(RegisterStudentsBO)BOFactory.getInstance().getBO(BOFactory.BOType.REGISTERSTUDENTS);

    public void initialize(){
        setStudentId();
        setCombo();
        cmbProgramId.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            setProgramData(newValue);
        });
    }

    private void setStudentId() {
        String sId=registerStudentsBO.getStudentId();
        txtStudentId.setText(sId);
    }

    private void setProgramData(String id) {
        ProgramDTO dto=registerStudentsBO.getProgram(id);
        if (dto!=null) {
            txtProgram.setText(dto.getName());
            txtDuration.setText(dto.getDuration());
            txtFee.setText(String.valueOf(dto.getFee()));
        }
    }

    private void setCombo() {
        ArrayList<String> programIds=registerStudentsBO.getProgramIds();
        if (programIds!=null) {
            cmbProgramId.getItems().addAll(programIds);
        }
    }

    public void registerOnAction(ActionEvent actionEvent) {
        StudentDTO student=new StudentDTO(txtStudentId.getText(), txtName.getText(), txtDOB.getText(), txtNIC.getText(), txtAddress.getText(), txtContact.getText(), txtEmail.getText());
        ProgramDTO program=new ProgramDTO(cmbProgramId.getValue(), txtProgram.getText(), txtDuration.getText(), Double.parseDouble(txtFee.getText()));
        StudentProgramDTO studentProgram=new StudentProgramDTO(new SimpleDateFormat("dd-MM-yyyy").format(new Date()), program, student);
        if (registerStudentsBO.isExistStudent(txtStudentId.getText())) {
            student=registerStudentsBO.
            if (registerStudentsBO.addStudentProgram(studentProgram)) {
                new Alert(Alert.AlertType.CONFIRMATION,"Registered...").show();
                clearAllFields();
                setStudentId();
            }else{
                new Alert(Alert.AlertType.WARNING,"Try again...").show();
            }
        }else{
            if (registerStudentsBO.addStudent(student)) {
                if (registerStudentsBO.addStudentProgram(studentProgram)) {
                    new Alert(Alert.AlertType.CONFIRMATION,"Registered...").show();
                    clearAllFields();
                    setStudentId();
                }else{
                    new Alert(Alert.AlertType.WARNING,"Try again...").show();
                }
            }else{
                new Alert(Alert.AlertType.WARNING,"Try again...").show();
            }
        }
    }
    private void clearAllFields() {
        txtStudentId.clear();
        txtName.clear();
        txtDOB.clear();
        txtNIC.clear();
        txtAddress.clear();
        txtContact.clear();
        txtEmail.clear();
        txtProgram.clear();
        txtDuration.clear();
        txtFee.clear();
    }
}

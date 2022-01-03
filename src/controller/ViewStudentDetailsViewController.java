package controller;

import bo.BOFactory;
import bo.custom.ManageProgramsBO;
import bo.custom.ViewStudentsBO;
import dto.ProgramDTO;
import dto.StudentDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.StudentProgramTM;

import java.util.ArrayList;

public class ViewStudentDetailsViewController {
    public TextField txtStudentId;
    public TextField txtName;
    public TextField txtDOB;
    public TextField txtNIC;
    public TextField txtAddress;
    public TextField txtContact;
    public TextField txtEmail;
    public ComboBox<String> cmbProgramId;

    public TableView<StudentDTO> tblStudents;
    public TableColumn<StudentDTO,String> colStudentId;
    public TableColumn<StudentDTO,String> colName;
    public TableColumn<StudentDTO,String> colDob;
    public TableColumn<StudentDTO,String> colNic;
    public TableColumn<StudentDTO,String> colAddress;
    public TableColumn<StudentDTO,String> colContact;
    public TableColumn<StudentDTO,String> colEmail;

    public TableView<StudentProgramTM> tblStudentPrograms;
    public TableColumn<StudentProgramTM,String> colRegistrationDate;
    public TableColumn<StudentProgramTM,String> colProgramId;
    public TableColumn<StudentProgramTM,String> colProgram;
    public TableColumn<StudentProgramTM,String> colDuration;

    ViewStudentsBO viewStudentsBO=(ViewStudentsBO) BOFactory.getInstance().getBO(BOFactory.BOType.VIEWSTUDENTS);
    ObservableList<StudentDTO> obList= FXCollections.observableArrayList();

    public void initialize(){
        viewAllStudents();
        colStudentId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colDob.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colNic.setCellValueFactory(new PropertyValueFactory<>("nic"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        tblStudents.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            setStudentData(newValue);
        });
    }

    private void viewAllStudents() {
        obList.clear();
        ArrayList<StudentDTO> students=viewStudentsBO.getAllStudents();
        if (students!=null) {
            for (StudentDTO student : students) {
                System.out.println(student.getId());
            }
            obList.addAll(students);
            tblStudents.setItems(obList);
        }
    }

    private void setStudentData(StudentDTO dto) {
        if (dto!=null) {
            txtStudentId.setText(dto.getId());
            txtName.setText(dto.getName());
            txtDOB.setText(dto.getDob());
            txtNIC.setText(dto.getNic());
            txtAddress.setText(dto.getAddress());
            txtContact.setText(dto.getContact());
            txtEmail.setText(dto.getEmail());
        }
    }
}

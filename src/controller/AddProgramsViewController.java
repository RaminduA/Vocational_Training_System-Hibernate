package controller;

import bo.BOFactory;
import bo.custom.AddProgramsBO;
import com.jfoenix.controls.JFXButton;
import dto.ProgramDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class AddProgramsViewController {

    public TextField txtProgramId;
    public TextField txtProgram;
    public TextField txtDuration;
    public TextField txtFee;

    public TableView<ProgramDTO> tblPrograms;
    public TableColumn<ProgramDTO,String> colProgramId;
    public TableColumn<ProgramDTO,String> colProgram;
    public TableColumn<ProgramDTO,String> colDuration;
    public TableColumn<ProgramDTO,Double> colFee;

    public JFXButton btnAddProgram;

    AddProgramsBO addProgramsBO=(AddProgramsBO)BOFactory.getInstance().getBO(BOFactory.BOType.ADDPROGRAMS);
    ObservableList<ProgramDTO> obList= FXCollections.observableArrayList();

    public void initialize(){
        viewAllPrograms();
        colProgramId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colProgram.setCellValueFactory(new PropertyValueFactory<>("name"));
        colDuration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        colFee.setCellValueFactory(new PropertyValueFactory<>("fee"));
    }

    public void addProgramOnAction(ActionEvent actionEvent) {
        ProgramDTO programDTO=new ProgramDTO(
                txtProgramId.getText(),
                txtProgram.getText(),
                txtDuration.getText(),
                Double.parseDouble(txtFee.getText())
        );
        if(addProgramsBO.addProgram(programDTO)){
            new Alert(Alert.AlertType.CONFIRMATION,"Saved...").show();
            clearAllFields();
            viewAllPrograms();
        }else{
            new Alert(Alert.AlertType.WARNING,"Try again...").show();
        }
    }

    public void viewAllPrograms(){
        obList.clear();
        ArrayList<ProgramDTO> programs=addProgramsBO.getAllPrograms();
        if (programs!=null) {
            for (ProgramDTO program : programs) {
                System.out.println(program.getId());
            }
            obList.addAll(programs);
            tblPrograms.setItems(obList);
        }
    }
    private void clearAllFields() {
        txtProgramId.clear();
        txtProgram.clear();
        txtDuration.clear();
        txtFee.clear();
    }
}
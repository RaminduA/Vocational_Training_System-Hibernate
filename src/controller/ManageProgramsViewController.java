package controller;

import bo.BOFactory;
import bo.custom.AddProgramsBO;
import bo.custom.ManageProgramsBO;
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

public class ManageProgramsViewController {
    public TextField txtProgramId;
    public TextField txtProgram;
    public TextField txtDuration;
    public TextField txtFee;

    public TableView<ProgramDTO> tblPrograms;
    public TableColumn<ProgramDTO,String> colProgramId;
    public TableColumn<ProgramDTO,String> colProgram;
    public TableColumn<ProgramDTO,String> colDuration;
    public TableColumn<ProgramDTO,Double> colFee;

    public JFXButton btnModifyProgram;
    public JFXButton btnRemoveProgram;

    ManageProgramsBO manageProgramsBO=(ManageProgramsBO) BOFactory.getInstance().getBO(BOFactory.BOType.MANAGEPROGRAMS);
    ObservableList<ProgramDTO> obList= FXCollections.observableArrayList();

    public void initialize(){
        viewAllPrograms();
        colProgramId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colProgram.setCellValueFactory(new PropertyValueFactory<>("name"));
        colDuration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        colFee.setCellValueFactory(new PropertyValueFactory<>("fee"));

        tblPrograms.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            setProgramData(newValue);
        });
    }

    private void setProgramData(ProgramDTO dto) {
        if (dto!=null) {
            txtProgramId.setText(dto.getId());
            txtProgram.setText(dto.getName());
            txtDuration.setText(dto.getDuration());
            txtFee.setText(String.valueOf(dto.getFee()));
        }
    }

    public void modifyProgramOnAction(ActionEvent actionEvent) {
        ProgramDTO programDTO=new ProgramDTO(
                txtProgramId.getText(),
                txtProgram.getText(),
                txtDuration.getText(),
                Double.parseDouble(txtFee.getText())
        );
        if(manageProgramsBO.updateProgram(programDTO)){
            new Alert(Alert.AlertType.CONFIRMATION,"Updated...").show();
            clearAllFields();
            viewAllPrograms();
        }else{
            new Alert(Alert.AlertType.WARNING,"Try again...").show();
        }
    }

    public void removeProgramOnAction(ActionEvent actionEvent) {
        String pId=txtProgramId.getText();
        if(manageProgramsBO.deleteProgram(pId)){
            new Alert(Alert.AlertType.CONFIRMATION,"Deleted...").show();
            clearAllFields();
            viewAllPrograms();
        }else{
            new Alert(Alert.AlertType.WARNING,"Try again...").show();
        }
    }

    public void viewAllPrograms(){
        obList.clear();
        ArrayList<ProgramDTO> programs=manageProgramsBO.getAllPrograms();
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

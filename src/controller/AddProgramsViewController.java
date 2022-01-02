package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class AddProgramsViewController {

    public TextField txtProgramId;
    public TextField txtProgram;
    public TextField txtDuration;
    public TextField txtFee;

    public TableView tblPrograms;
    public TableColumn colProgramId;
    public TableColumn colProgram;
    public TableColumn colDuration;
    public TableColumn colFee;

    public JFXButton btnAddProgram;

    public void addProgramOnAction(ActionEvent actionEvent) {
            
    }
}
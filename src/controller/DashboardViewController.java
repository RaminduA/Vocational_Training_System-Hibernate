package controller;

import com.jfoenix.controls.JFXButton;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DashboardViewController {
    public AnchorPane dashboardContext;
    public AnchorPane performanceContext;
    public AnchorPane sidePanel;

    public JFXButton btnLogout;
    public JFXButton btnRegisterStudents;
    public JFXButton btnAddPrograms;
    public JFXButton btnViewStudentDetails;
    public JFXButton btnManagePrograms;

    public Label lblDate;
    public Label lblTime;

    public void initialize() {
        lblDate.setText(new SimpleDateFormat("EEEE, dd MMMM yyyy").format(new Date()));
        Timeline time=new Timeline(new KeyFrame(Duration.ZERO, e -> {
            LocalTime currentTime=LocalTime.now();
            lblTime.setText(currentTime.format(DateTimeFormatter.ofPattern("hh:mm:ss a")));//ISO_LOCAL_TIME.substring(0,8)
        }),
                new KeyFrame(Duration.seconds(1))
        );
        time.setCycleCount(Animation.INDEFINITE);
        time.play();
    }

    public void backToLoginForm(ActionEvent actionEvent) throws IOException {
        dashboardContext.getChildren().add(FXMLLoader.load(getClass().getResource("../view/LoginView.fxml")));
    }

    public void registerStudentsOnAction(ActionEvent actionEvent) throws IOException {
        performanceContext.getChildren().add(FXMLLoader.load(getClass().getResource("../view/RegisterStudentsView.fxml")));
    }

    public void addProgramsOnAction(ActionEvent actionEvent) throws IOException {
        performanceContext.getChildren().add(FXMLLoader.load(getClass().getResource("../view/AddProgramsView.fxml")));
    }

    public void viewStudentDetailsOnAction(ActionEvent actionEvent) throws IOException {
        performanceContext.getChildren().add(FXMLLoader.load(getClass().getResource("../view/ViewStudentDetailsView.fxml")));
    }

    public void manageProgramsOnAction(ActionEvent actionEvent) throws IOException {
        performanceContext.getChildren().add(FXMLLoader.load(getClass().getResource("../view/ManageProgramsView.fxml")));
    }
}

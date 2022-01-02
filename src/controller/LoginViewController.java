package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class LoginViewController {
    public AnchorPane loginView;

    public void loadDashboardOnAction(ActionEvent actionEvent) throws IOException {
        loginView.getChildren().add(FXMLLoader.load(getClass().getResource("../view/DashboardView.fxml")));
    }
}

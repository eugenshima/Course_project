package com.example.salaryclient;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.salaryclient.ClientWork.ClientConnect;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class UsualWorkerController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ExitButton;

    @FXML
    private Button ViewMyInformationButton;

    @FXML
    private Button ViewMySalaryButton;

    @FXML
    void initialize() {
        ExitButton.setOnAction(ActionEvent -> {
            ClientConnect.client.sendMessage("ClearHistory");
            ExitButton.getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("authorization.fxml"));
            try {
                fxmlLoader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Parent parent = fxmlLoader.getRoot();
            Stage stage = new Stage();
            stage.setTitle("Payroll System");
            stage.setScene(new Scene(parent));
            stage.show();
        });
    }

}

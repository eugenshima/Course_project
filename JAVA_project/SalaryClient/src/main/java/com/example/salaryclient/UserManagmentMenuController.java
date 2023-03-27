package com.example.salaryclient;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class UserManagmentMenuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button AddButton;

    @FXML
    private Button DeleteButton;

    @FXML
    private Button ExtButton;

    @FXML
    private Button UpdateButton;

    @FXML
    void initialize() {
        ExtButton.setOnAction(ActionEvent -> {
            ExtButton.getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("AdminMenu.fxml"));
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
        DeleteButton.setOnAction(ActionEvent -> {
            DeleteButton.getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("DeletePage.fxml"));
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
        AddButton.setOnAction(ActionEvent -> {
            AddButton.getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("AddPage.fxml"));
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

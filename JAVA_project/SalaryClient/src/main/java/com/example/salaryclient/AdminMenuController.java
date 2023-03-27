package com.example.salaryclient;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.example.salaryclient.ClientWork.ClientConnect;
import com.example.salaryclient.Model.Staffing;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdminMenuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button HistoryOfThisSession;

    @FXML
    private Button SearchingPage;

    @FXML
    private Button ExitButton;

    @FXML
    private Button ReportCardButton;

    @FXML
    private Button SalaryButton;

    @FXML
    private Button StaffingButton;

    @FXML
    private Button UserManagmentButton;

    @FXML
    private Button UserListButton;

    @FXML
    void initialize() {
        UserManagmentButton.setOnAction(ActionEvent -> {
            UserManagmentButton.getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("UserManagmentMenu.fxml"));
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
        StaffingButton.setOnAction(ActionEvent -> {
            StaffingButton.getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("StaffingWindow.fxml"));
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
        UserListButton.setOnAction(ActionEvent -> {
            UserListButton.getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("UserList.fxml"));
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
        HistoryOfThisSession.setOnAction(ActionEvent -> {
            ListView<String> listView = new ListView<>();
            ClientConnect.client.sendMessage("History");
            Gson gson = new Gson();
            String obj = ClientConnect.client.readObject().toString();
            Type fooType = new TypeToken<ArrayList<String>>() {}.getType();
            ArrayList<String> list = gson.fromJson(obj, fooType);
            for (String List : list) {
                listView.getItems().add(List);
            }
            VBox vBox = new VBox(listView);
            Scene scene = new Scene(vBox, 1000, 400);
            Stage stage = new Stage();
            stage.setTitle("List Of Students");
            stage.setScene(scene);
            stage.showAndWait();
            listView.getItems().clear();
        });
       SearchingPage.setOnAction(ActionEvent -> {
           SearchingPage.getScene().getWindow().hide();
           FXMLLoader fxmlLoader = new FXMLLoader();
           fxmlLoader.setLocation(getClass().getResource("SearchingPage.fxml"));
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

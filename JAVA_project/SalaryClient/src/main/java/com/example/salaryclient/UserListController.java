package com.example.salaryclient;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.example.salaryclient.Model.*;
import com.example.salaryclient.ClientWork.ClientConnect;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UserListController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button AllInformationButton;

    @FXML
    private Button ExitButton;

    @FXML
    private Button FSalaryButton;

    @FXML
    private Button RCButton;

    @FXML
    private Button StaffingOverviewButton;

    @FXML
    private Button UsersButton;


    private ListView<UserInfo> listView = new ListView<>();
    private ListView<Staffing> listView1 = new ListView<>();
    private ListView<ReportCard> listView2 = new ListView<>();
    private ListView<FinalSalary> listView3 = new ListView<>();
    private ListView<FinalModel> listView4 = new ListView<>();

    @FXML
    void initialize() {
        ExitButton.setOnAction(ActionEvent -> {
            ExitButton.getScene().getWindow().hide();
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
        UsersButton.setOnAction(ActionEvent -> {
            Gson gson = new Gson();
            ClientConnect.client.sendMessage("Users");
            try {
                listView.getItems().clear();
                String obj = ClientConnect.client.readObject().toString();
                Type fooType = new TypeToken<ArrayList<UserInfo>>() {}.getType();
                ArrayList<UserInfo> list = gson.fromJson(obj, fooType);
                System.out.println(list);
                for (UserInfo List : list) {
                    listView.getItems().add(List);
                }
                VBox vBox = new VBox(listView);
                Scene scene = new Scene(vBox, 1000, 400);
                Stage stage = new Stage();
                stage.setTitle("List Of Students");
                stage.setScene(scene);
                stage.showAndWait();
                listView.getItems().clear();



            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        });
        StaffingOverviewButton.setOnAction(ActionEvent -> {
            Gson gson = new Gson();
            ClientConnect.client.sendMessage("StaffingOverview");
            try {
                listView1.getItems().clear();
                String obj = ClientConnect.client.readObject().toString();
                Type fooType = new TypeToken<ArrayList<Staffing>>() {}.getType();
                ArrayList<Staffing> list = gson.fromJson(obj, fooType);
                System.out.println(list);
                for (Staffing List : list) {
                    listView1.getItems().add(List);
                }
                VBox vBox = new VBox(listView1);
                Scene scene = new Scene(vBox, 1000, 400);
                Stage stage = new Stage();
                stage.setTitle("List Of Students");
                stage.setScene(scene);
                stage.showAndWait();
                listView1.getItems().clear();

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        RCButton.setOnAction(ActionEvent -> {
            Gson gson = new Gson();
            ClientConnect.client.sendMessage("ReportCardOverview");
            try {
                listView2.getItems().clear();
                String obj = ClientConnect.client.readObject().toString();
                Type fooType = new TypeToken<ArrayList<ReportCard>>() {}.getType();
                ArrayList<ReportCard> list = gson.fromJson(obj, fooType);
                System.out.println(list);
                for (ReportCard List : list) {
                    listView2.getItems().add(List);
                }
                VBox vBox = new VBox(listView2);
                Scene scene = new Scene(vBox, 1000, 400);
                Stage stage = new Stage();
                stage.setTitle("List Of Students");
                stage.setScene(scene);
                stage.showAndWait();
                listView2.getItems().clear();

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        FSalaryButton.setOnAction(ActionEvent -> {
            Gson gson = new Gson();
            ClientConnect.client.sendMessage("FSalaryOverview");
            try {
                listView3.getItems().clear();
                String obj = ClientConnect.client.readObject().toString();
                Type fooType = new TypeToken<ArrayList<FinalSalary>>() {}.getType();
                ArrayList<FinalSalary> list = gson.fromJson(obj, fooType);
                System.out.println(list);
                for (FinalSalary List : list) {
                    listView3.getItems().add(List);
                }
                VBox vBox = new VBox(listView3);
                Scene scene = new Scene(vBox, 1000, 400);
                Stage stage = new Stage();
                stage.setTitle("List Of Students");
                stage.setScene(scene);
                stage.showAndWait();
                listView3.getItems().clear();
            } catch (JsonSyntaxException e) {
                throw new RuntimeException(e);
            }

        });

        AllInformationButton.setOnAction(ActionEvent -> {
            ClientConnect.client.sendMessage("SalaryCalculationOverview");
            Gson gson = new Gson();
            try {
                listView4.getItems().clear();
                String obj = ClientConnect.client.readObject().toString();
                Type fooType = new TypeToken<ArrayList<FinalModel>>() {}.getType();
                ArrayList<FinalModel> list = gson.fromJson(obj, fooType);
                System.out.println(list);
                for (FinalModel List : list) {
                    listView4.getItems().add(List);
                }
                VBox vBox = new VBox(listView4);
                Scene scene = new Scene(vBox, 1000, 400);
                Stage stage = new Stage();
                stage.setTitle("List Of Students");
                stage.setScene(scene);
                stage.showAndWait();
                listView4.getItems().clear();
            } catch (JsonSyntaxException e) {
                throw new RuntimeException(e);
            }
        });
    }
}

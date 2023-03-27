package com.example.salaryclient;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.salaryclient.Model.Role;
import com.example.salaryclient.ClientWork.ClientConnect;
import com.google.gson.Gson;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class ChartMenuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ExitButton;

    @FXML
    private Button RoleChart;

    @FXML
    private Button SalaryChart;

    private ListView<Role> listView = new ListView<>();


    @FXML
    void initialize() {
        ExitButton.setOnAction(ActionEvent -> {
            ExitButton.getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("MenuHR.fxml"));
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
        RoleChart.setOnAction(ActionEvent -> {
            Gson gson = new Gson();
            ClientConnect.client.sendMessage("RoleChart");
            try {
                int count = Integer.parseInt(ClientConnect.client.readMessage());
                int count1 = Integer.parseInt(ClientConnect.client.readMessage());
                int count2 = Integer.parseInt(ClientConnect.client.readMessage());
                int count3 = Integer.parseInt(ClientConnect.client.readMessage());
                ObservableList<PieChart.Data> observableList = FXCollections.observableArrayList(
                        new PieChart.Data("Admin", count),
                        new PieChart.Data("HR", count1),
                        new PieChart.Data("Encounter", count2),
                        new PieChart.Data("Worker", count3)
                );
                PieChart pieChart = new PieChart();
                pieChart.getData().addAll(observableList);

                Scene scene = new Scene(pieChart, 600, 600);
                Stage stage = new Stage();
                stage.setTitle("Payroll System");
                stage.setScene(scene);
                stage.showAndWait();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        SalaryChart.setOnAction(ActionEvent -> {

        });
    }

}


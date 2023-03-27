package com.example.salaryclient;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.example.salaryclient.ClientWork.ClientConnect;
import com.example.salaryclient.Model.*;
import com.example.salaryclient.util.Checking;
import com.example.salaryclient.util.Dialog;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SalaryCalculationController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button CalculateSalary;

    @FXML
    private Button ExitButton;

    @FXML
    private TextField IdField;

    @FXML
    private Button ReportCardButton;
    @FXML
    private Button SaveButton;

    @FXML
    private Button SalaryInformation;

    @FXML
    private Button StaffingButton;

    @FXML
    private Button TaxesButton;

    @FXML
    private ComboBox<String> typeOfCalc;
    private ListView<FinalModel> listView = new ListView<>();
    @FXML
    void initialize() {
        ExitButton.setOnAction(ActionEvent -> {
            ExitButton.getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("BuhgalterMenu.fxml"));
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
        CalculateSalary.setOnAction(ActionEvent -> {
            if(CheckInput()) {
                Dialog.WarningAlertWindow("You need to input all the information");
            }
            else {
                ClientConnect.client.sendMessage("SalaryCalculation");
                Gson gson = new Gson();
                Person person = new Person();
                FinalSalary finalSalary = new FinalSalary();
                person.setID(Integer.parseInt(IdField.getText()));
                ClientConnect.client.sendObject(gson.toJson(person));
                String obj = ClientConnect.client.readObject().toString();
                finalSalary = gson.fromJson(obj, FinalSalary.class);
                System.out.println(finalSalary.getFS());
                Dialog.WarningAlertWindow("Can't delete person with this ID");
            }
        });
        SalaryInformation.setOnAction(ActionEvent -> {
            ClientConnect.client.sendMessage("SalaryCalculationOverview");
            Dialog.WarningAlertWindow("Salary Info Successfully saved!!!");
            Gson gson = new Gson();
            try {
                listView.getItems().clear();
                String obj = ClientConnect.client.readObject().toString();
                Type fooType = new TypeToken<ArrayList<FinalModel>>() {}.getType();
                ArrayList<FinalModel> list = gson.fromJson(obj, fooType);
                System.out.println(list);

                for (FinalModel List : list) {
                    listView.getItems().add(List);
                }
                VBox vBox = new VBox(listView);
                Scene scene = new Scene(vBox, 1000, 400);
                Stage stage = new Stage();
                stage.setTitle("List Of Students");
                stage.setScene(scene);
                stage.showAndWait();
                listView.getItems().clear();
            } catch (JsonSyntaxException e) {
                throw new RuntimeException(e);
            }
        });
        SaveButton.setOnAction(ActionEvent -> {
            ClientConnect.client.sendMessage("FileWriter");
            Gson gson = new Gson();
            Person person = new Person();
            person.setID(Integer.parseInt(IdField.getText()));
            ClientConnect.client.sendObject(gson.toJson(person));
            String message = "";
            try {
                message = ClientConnect.client.readMessage();
            }catch (IOException e) {
                throw new RuntimeException(e);
            }
            if(message.equals("There is no data!")) {
                Dialog.WarningAlertWindow();
            }
        });
        typeOfCalc.getItems().addAll(
                "1",
                "2");

    }
    private boolean CheckInput() {
        try {
            return IdField.getText().equals("");
        }
        catch (Exception e) {
            System.out.println("Error");
            return true;
        }
    }


}



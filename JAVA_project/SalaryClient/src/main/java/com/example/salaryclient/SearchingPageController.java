package com.example.salaryclient;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.example.salaryclient.ClientWork.ClientConnect;
import com.example.salaryclient.Model.FinalModel;
import com.example.salaryclient.util.Dialog;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SearchingPageController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ExitButton;

    @FXML
    private TextField ID;

    @FXML
    private TextField Role;

    @FXML
    private TextField Salary;

    @FXML
    private Button SearchByID;

    @FXML
    private Button SearchByName;

    @FXML
    private Button SearchByRole;

    @FXML
    private Button SearchBySalary;

    @FXML
    private TextField name;

    private ListView<FinalModel> listView = new ListView<>();

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
        SearchByName.setOnAction(ActionEvent -> {

        });
        SearchByID.setOnAction(ActionEvent -> {
            if(CheckInput()){
                Dialog.WarningAlertWindow("Input ID for searching");
            } else {
                Gson gson = new Gson();
                ClientConnect.client.sendMessage("SearchById");
                FinalModel finalModel = new FinalModel();
                finalModel.setPersonID(Integer.parseInt(ID.getText()));
                ClientConnect.client.sendObject(gson.toJson(finalModel));

                String message = "";
                /*try {
                    message = ClientConnect.client.readMessage();
                }catch (IOException e) {
                    throw new RuntimeException(e);
                }*/

                if(message.equals("There is no data!")) {
                    Dialog.WarningAlertWindow();
                }
                else {
                    System.out.println("correct");
                    String obj = ClientConnect.client.readObject().toString();
                    System.out.println("correct");
                    Type fooType = new TypeToken<ArrayList<FinalModel>>() {}.getType();
                    ArrayList<FinalModel> list = gson.fromJson(obj, fooType);
                    System.out.println("correct");
                    //finalModel = gson.fromJson(obj, FinalModel.class);
                    for (FinalModel List : list) {
                        listView.getItems().add(List);
                    }
                    System.out.println("correct");
                    VBox vBox = new VBox(listView);
                    Scene scene = new Scene(vBox, 1000, 400);
                    Stage stage = new Stage();
                    stage.setTitle("List Of Students");
                    stage.setScene(scene);
                    stage.showAndWait();
                    listView.getItems().clear();
                    }
                }

        });
        SearchByRole.setOnAction(ActionEvent -> {

        });
        SearchBySalary.setOnAction(ActionEvent -> {

        });
    }

    private boolean CheckInput() {
        try {
            return ID.getText().equals("");
        }
        catch (Exception e) {
            System.out.println("Error");
            return true;
        }
    }
}

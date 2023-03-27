package com.example.salaryclient;

import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.example.salaryclient.ClientWork.ClientConnect;
import com.example.salaryclient.Model.FinalModel;
import com.example.salaryclient.Model.Role;
import com.example.salaryclient.util.Dialog;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HRUpdateButtonController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button CheckInfo;

    @FXML
    private Button ExtButton;

    @FXML
    private ComboBox<String> RoleChoiceCB;

    @FXML
    private Button UpdateButton;

    @FXML
    private TextField idField;

    private ListView<FinalModel> listView = new ListView<>();

    @FXML
    void initialize() {
        RoleChoiceCB.getItems().addAll(
                "Worker",
                "HR",
                "Encounter");
        UpdateButton.setOnAction(ActionEvent -> {
            if(CheckInput()) {
                Dialog.WarningAlertWindow("You need to input ID and Role");
            } else {
                ClientConnect.client.sendMessage("UpdateRole");
                Gson gson = new Gson();
                Role role = new Role();
                role.setURole(RoleChoiceCB.getValue());
                role.setPersonID(Integer.parseInt(idField.getText()));
                ClientConnect.client.sendObject(gson.toJson(role));

                String obj = ClientConnect.client.readObject().toString();
                role = gson.fromJson(obj, Role.class);
                if(!role.getURole().equals("") || role.getPersonID() != 0) {
                    Dialog.InformationAlertWindow("Role was successfully Updated!!!");
                }
            }
        });
        CheckInfo.setOnAction(ActionEvent -> {
            ClientConnect.client.sendMessage("SalaryCalculationOverview");
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
    }

    private boolean CheckInput() {
        try {
            return idField.getText().equals("") || RoleChoiceCB.getValue().equals("");
        }
        catch (Exception e) {
            System.out.println("Error");
            return true;
        }
    }
}

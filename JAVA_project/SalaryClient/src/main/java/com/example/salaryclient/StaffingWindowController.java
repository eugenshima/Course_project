package com.example.salaryclient;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.example.salaryclient.Model.Staffing;
import com.example.salaryclient.ClientWork.ClientConnect;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StaffingWindowController {

    private ListView<Staffing> listView = new ListView<>();
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ExitButton;

    @FXML
    private Button StaffingManagmentButton;

    @FXML
    private Button StaffingOverviewButton;

    ObservableList<Staffing> arrayList = FXCollections.observableArrayList();

    @FXML
    void initialize() {
       StaffingOverviewButton.setOnAction(ActionEvent -> {
           Gson gson = new Gson();
           ClientConnect.client.sendMessage("StaffingOverview");
           try {
               String obj = ClientConnect.client.readObject().toString();
               Type fooType = new TypeToken<ArrayList<Staffing>>() {}.getType();
               ArrayList<Staffing> list = gson.fromJson(obj, fooType);
               System.out.println(list);
               for (Staffing List : list) {
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
    }

}

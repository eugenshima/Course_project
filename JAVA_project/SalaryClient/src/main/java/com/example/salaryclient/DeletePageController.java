package com.example.salaryclient;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.example.salaryclient.Model.Person;
import com.example.salaryclient.Model.UserInfo;
import com.example.salaryclient.ClientWork.ClientConnect;
import com.example.salaryclient.util.Dialog;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DeletePageController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button DeleteButton;

    @FXML
    private Button ExtButton;

    @FXML
    private Button ListofUsersButton;

    @FXML
    private TextField idField;

    private ListView<UserInfo> listView = new ListView<>();

    @FXML
    void initialize() {
        ExtButton.setOnAction(ActionEvent -> {
            ExtButton.getScene().getWindow().hide();
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
        DeleteButton.setOnAction(ActionEvent -> {
            if(CheckInput()){
                Dialog.WarningAlertWindow();
            } else {
                Gson gson = new Gson();
                ClientConnect.client.sendMessage("DeleteUser");
                Person person = new Person();
                person.setID(Integer.parseInt(idField.getText()));
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
                else {
                    String obj = ClientConnect.client.readObject().toString();
                    Person person1 = gson.fromJson(obj, Person.class);
                    System.out.println("Пользователь удален! -> " + person1);
                    Dialog.InformationAlertWindow("User successfully deleted");
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
                }
            }
        });
        ListofUsersButton.setOnAction(ActionEvent -> {
            Gson gson = new Gson();
            ClientConnect.client.sendMessage("Users");
            try {
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
    }
    private boolean CheckInput() {
        try {
            return idField.getText().equals("");
        }
        catch (Exception e) {
            System.out.println("Error");
            return true;
        }
    }
}

package com.example.salaryclient;

import com.example.salaryclient.Model.Role;
import com.example.salaryclient.Model.User;
import com.example.salaryclient.ClientWork.ClientConnect;
import com.example.salaryclient.util.Dialog;
import com.google.gson.Gson;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.ResourceBundle;

public class authorizationController implements Serializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button enterButton;

    @FXML
    private TextField login;

    @FXML
    private PasswordField password;

    @FXML
    private Button registrationButton;

    Role role = new Role();
    @FXML
    void initialize() {
        enterButton.setOnAction(ActionEvent -> {
            if (CheckInput()) {
                Dialog.WarningAlertWindow();
            } else {

                Gson gson = new Gson();
                ClientConnect.client.sendMessage("authorization");
                User user = new User();
                user.setUserLogin(login.getText());
                user.setUserPassword(password.getText());
                ClientConnect.client.sendObject(gson.toJson(user));

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
                    System.out.println(message + " Получилось");
                    String obj = ClientConnect.client.readObject().toString();
                    Role role = gson.fromJson(obj, Role.class);
                    System.out.println(role);
                    ClientConnect.role = role.getURole();
                    System.out.println("Получилось!!!\nТвоя роль --> " + ClientConnect.role);
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    enterButton.getScene().getWindow().hide();
                    if (ClientConnect.role.equals("Admin")) {
                        fxmlLoader.setLocation(getClass().getResource("AdminMenu.fxml"));
                    } else if (ClientConnect.role.equals("HR")) {
                        fxmlLoader.setLocation(getClass().getResource("MenuHR.fxml"));
                    } else if (ClientConnect.role.equals("Encounter")) {
                        fxmlLoader.setLocation(getClass().getResource("BuhgalterMenu.fxml"));
                    } else if(ClientConnect.role.equals("Worker")){
                        fxmlLoader.setLocation(getClass().getResource("UsualWorker.fxml"));
                    }

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
        registrationButton.setOnAction(ActionEvent -> {
            FXMLLoader fxmlLoader = new FXMLLoader();
            registrationButton.getScene().getWindow().hide();
            fxmlLoader.setLocation(getClass().getResource("Registration.fxml"));
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
    private boolean CheckInput() {
        try {
            return login.getText().equals("") || password.getText().equals("");
        }
        catch (Exception e) {
            System.out.println("Error");
            return true;
        }
    }
}

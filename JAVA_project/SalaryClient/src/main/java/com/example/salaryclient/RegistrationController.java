package com.example.salaryclient;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.salaryclient.Model.Person;
import com.example.salaryclient.Model.User;
import com.example.salaryclient.ClientWork.ClientConnect;
import com.example.salaryclient.util.Checking;
import com.example.salaryclient.util.Dialog;
import com.google.gson.Gson;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegistrationController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ConfirmButton;

    @FXML
    private Button ExitButton;

    @FXML
    private TextField FName;

    @FXML
    private TextField LName;

    @FXML
    private TextField PhoneNumber;

    @FXML
    private TextField login;

    @FXML
    private TextField DateOfBirth;

    @FXML
    private TextField mail;

    @FXML
    private TextField password;

    @FXML
    void initialize() {
        ExitButton.setOnAction(ActionEvent -> {
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
        ConfirmButton.setOnAction(ActionEvent -> {
            if(CheckInput()) {
                Dialog.WarningAlertWindow("You need to input all the information");
            }
            else if(Checking.checkInt(PhoneNumber.getText())) {
                Dialog.WarningAlertWindow("Incorrect Phone Number!!! you need to input code+7 numbers");
            }
            else {
                ClientConnect.client.sendMessage("registration");
                Person person = new Person();
                User user = new User();
                person.setUserFName(FName.getText());
                person.setUserLName(LName.getText());
                person.setPhoneNumber(PhoneNumber.getText());
                person.setEmail(mail.getText());
                user.setUserLogin(login.getText());
                user.setUserPassword(password.getText());
                Gson gson = new Gson();
                ClientConnect.client.sendObject(gson.toJson(person));
                ClientConnect.client.sendObject(gson.toJson(user));
                /////////////
                    String obj = ClientConnect.client.readObject().toString();
                    Person person1 = gson.fromJson(obj, Person.class);
                    String obj1 = ClientConnect.client.readObject().toString();
                    User user1 = gson.fromJson(obj1, User.class);
                    ClientConnect.id = person1.getID();
                    System.out.println("Вы ввели в базу эту информацию --> " + person1 + " ID=" + ClientConnect.id);
                    Dialog.InformationAlertWindow("person add completed successfully");
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    ConfirmButton.getScene().getWindow().hide();
                    fxmlLoader.setLocation(getClass().getResource("Registration.fxml"));

                /////////////
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
        });
    }
    private boolean CheckInput() {
        try {
            return FName.getText().equals("") || LName.getText().equals("") || PhoneNumber.getText().equals("") || login.getText().equals("") || password.getText().equals("") || mail.getText().equals("");
        }
        catch (Exception e) {
            System.out.println("Error");
            return true;
        }
    }
}

package com.example.salaryclient.util;

import javafx.scene.control.Alert;

public class Dialog {
    public static void WarningAlertWindow() {
        Alert alert = new Alert(Alert.AlertType.WARNING);

        alert.setTitle("WARNING");
        alert.setHeaderText("WARNING");
        alert.setContentText("You need to input all the information");

        alert.showAndWait();
    }
    public static void WarningAlertWindow(String str) {
        Alert alert = new Alert(Alert.AlertType.WARNING);

        alert.setTitle("WARNING");
        alert.setHeaderText("WARNING");
        alert.setContentText(str);

        alert.showAndWait();
    }
    public static void InformationAlertWindow(String str) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("INFORMATION");
        alert.setHeaderText("INFORMATION");
        alert.setContentText(str);

        alert.showAndWait();
    }
    public static void ErrorAlertWindow() {
        Alert alert = new Alert(Alert.AlertType.ERROR);

        alert.setTitle("Error");
        alert.setHeaderText("Error");
        alert.setContentText("vatafak");

        alert.showAndWait();
    }
    public static void ConfirmationAlertWindow() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

        alert.setTitle("CONFIRMATION");
        alert.setHeaderText("CONFIRMATION");
        alert.setContentText("vatafak");

        alert.showAndWait();
    }
}

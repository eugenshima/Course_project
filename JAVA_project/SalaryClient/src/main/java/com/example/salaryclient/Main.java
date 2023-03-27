package com.example.salaryclient;

import com.example.salaryclient.ClientWork.ClientConnect;
import com.example.salaryclient.ClientWork.ClientStart;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("authorization.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Payroll system");
        stage.setScene(scene);

        stage.show();

    }

    public static void main(String[] args) {
        ClientConnect.client = new ClientStart("127.0.0.2", "8888");
        launch();
    }
}
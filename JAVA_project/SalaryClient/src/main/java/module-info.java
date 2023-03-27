module com.example.salaryclient {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires com.google.gson;

    opens com.example.salaryclient to javafx.fxml;
    exports com.example.salaryclient;
    exports com.example.salaryclient.Controllers;
    opens com.example.salaryclient.Controllers to javafx.fxml;


}
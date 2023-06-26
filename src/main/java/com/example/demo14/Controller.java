package com.example.demo14;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button LoginSingUpButton;

    @FXML
    private Button authSingInButton;

    @FXML
    private TextField loginField;

    @FXML
    private TextField passwordField;

    @FXML
    public void initialize() {

        authSingInButton.setOnAction(event ->{
            String loginText = loginField.getText().trim();
            String loginPassword = passwordField.getText().trim();

            if(!loginText.equals("") && !loginPassword.equals(""))
                loginUser(loginText,loginPassword);
            else
                System.out.println("Login and password is empty");
        });

        LoginSingUpButton.setOnAction(event -> {
            LoginSingUpButton.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("windowTwo.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
    }

    private void loginUser(String loginText, String loginPassword) {
    }
}

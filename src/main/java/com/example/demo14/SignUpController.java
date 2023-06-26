package com.example.demo14;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class SignUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField logimField;

    @FXML
    private TextField passwordField;

    @FXML
    private Button signUp;

    @FXML
    private TextField signUpLastNmae;

    @FXML
    private TextField signUpName;

    @FXML
    void initialize() {
        DatabaseHandler dbHandler = new DatabaseHandler();

        signUp.setOnAction(event ->{


            dbHandler.signUpUser(signUpName.getText(), signUpLastNmae.getText(),
                    logimField.getText(), passwordField.getText());

        });
    }

}
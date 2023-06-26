package com.example.demo14;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.sql.Connection;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("windowOne.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();

     try{
        String url = "jdbc:mysql://localhost/applehotel";
        String username = "root";
        String password = "Root";
        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        try (Connection conn = DriverManager.getConnection(url, username, password)){

            System.out.println("!!!");
        }
    }
        catch(Exception ex){

        System.out.println(ex);
    }
}
}

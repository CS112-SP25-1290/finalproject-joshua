package edu.miracosta.cs112.finalproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FinanceApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("main-view.fxml"));
        stage.setScene(new Scene(loader.load(), 800, 600));
        stage.setTitle("Finance Manager");
        stage.show();
    }
    public static void main(String[] args) { launch(); }
}


package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("My Interface");
        StackPane root = new StackPane();
        root.getChildren().add(new Label("Hello, JavaFX!"));
        primaryStage.setScene(new Scene(root, 300, 200));
        primaryStage.show();
    }
}

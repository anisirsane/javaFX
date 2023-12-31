package com.example;

import javafx.application.Application; 
import static javafx.application.Application.launch;

import java.lang.reflect.Array;

import javafx.geometry.Insets; 
import javafx.geometry.Pos; 
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField; 
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text; 
import javafx.scene.control.TextField; 
import javafx.stage.Stage;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import com.fazecast.jSerialComm.*; // Importation libraire externe JserialComm
import java.util.Collections;

import java.util.ArrayList;
import com.example.NonblockingReading;



public class Main extends Application {
    String val = NonblockingReading.getValue();
 
    
    public static void main(String[] args) {
        launch(args);
    }
 
    

    @Override
    public void start(Stage primaryStage) {
        Text text1 = new Text("Temperature actuelle:");       
        Text text3 = new Text(val);       
   

        primaryStage.setTitle("My Interface");

 //Creating a Grid Pane 
      GridPane gridPane = new GridPane();    

      //Setting the padding  
      gridPane.setPadding(new Insets(10, 10, 10, 10)); 
      
      //Setting the vertical and horizontal gaps between the columns 
      gridPane.setVgap(5); 
      gridPane.setHgap(5);       
      
      //Setting the Grid alignment 
      gridPane.setAlignment(Pos.CENTER); 
       
      //Arranging all the nodes in the grid 
      gridPane.add(text1, 0, 0); 
      gridPane.add(text3, 1, 0); 

       
      //Styling nodes  
      text1.setStyle("-fx-font: normal bold 20px 'serif' "); 
      text3.setStyle("-fx-font: normal bold 20px 'serif' "); 
      gridPane.setStyle("-fx-background-color: #f4f4f4;"); 
       

    //chart


       

        

        SubScene scene = new SubScene(gridPane,300,300); 
     
        VBox root = new VBox(10);  
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(scene);
        Scene mainScene = new Scene(root,300,300);
        primaryStage.setScene(mainScene);
        primaryStage.show();

    }
}

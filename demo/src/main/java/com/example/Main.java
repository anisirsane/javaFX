package com.example;

import javafx.application.Application; 
import static javafx.application.Application.launch; 
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
public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Text text1 = new Text("Temperature actuelle:");       
        Text text2 = new Text("Humidite actuelle: "); 
        Text text3 = new Text("30");       
        Text text4 = new Text("60"); 
        Button button1 = new Button("refresh");
        primaryStage.setTitle("My Interface");

 //Creating a Grid Pane 
      GridPane gridPane = new GridPane();    
      //Setting size for the pane 
      //gridPane.setMinSize(300, 200);
      
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
      gridPane.add(text2, 0, 1);       
      gridPane.add(text4, 1, 1); 
      gridPane.add(button1, 0, 2); 
       
      //Styling nodes  
      button1.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;"); 
       
      text1.setStyle("-fx-font: normal bold 20px 'serif' "); 
      text2.setStyle("-fx-font: normal bold 20px 'serif' "); 
      text3.setStyle("-fx-font: normal bold 20px 'serif' "); 
      text4.setStyle("-fx-font: normal bold 20px 'serif' "); 
   
      gridPane.setStyle("-fx-background-color: #f4f4f4;"); 
       

    //chart





        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
         xAxis.setLabel("time");
        final LineChart<String,Number> lineChart = 
                new LineChart<String,Number>(xAxis,yAxis);
       
        lineChart.setTitle("Valeur temperature, humidite pour le DHT11");
                          
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Temperatures");
        
        series1.getData().add(new XYChart.Data("12:00:00", 23));
        series1.getData().add(new XYChart.Data("12:00:05", 14));
        series1.getData().add(new XYChart.Data("12:00:10", 15));
        series1.getData().add(new XYChart.Data("12:00:15", 24));
        series1.getData().add(new XYChart.Data("12:00:20", 34));
        series1.getData().add(new XYChart.Data("12:00:25", 36));
        series1.getData().add(new XYChart.Data("12:00:30", 22));
        series1.getData().add(new XYChart.Data("12:00:35", 45));
        series1.getData().add(new XYChart.Data("12:00:40", 43));
        series1.getData().add(new XYChart.Data("12:00:45", 17));
        series1.getData().add(new XYChart.Data("12:00:50", 29));
        series1.getData().add(new XYChart.Data("12:00:55", 25));
        
        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Humidite");
        series2.getData().add(new XYChart.Data("12:00:00", 53));
        series2.getData().add(new XYChart.Data("12:00:05", 74));
        series2.getData().add(new XYChart.Data("12:00:10", 65));
        series2.getData().add(new XYChart.Data("12:00:15", 44));
        series2.getData().add(new XYChart.Data("12:00:20", 39));
        series2.getData().add(new XYChart.Data("12:00:25", 46));
        series2.getData().add(new XYChart.Data("12:00:30", 55));
        series2.getData().add(new XYChart.Data("12:00:35", 54));
        series2.getData().add(new XYChart.Data("12:00:40", 48));
        series2.getData().add(new XYChart.Data("12:00:45", 27));
        series2.getData().add(new XYChart.Data("12:00:50", 37));
        series2.getData().add(new XYChart.Data("12:00:55", 29));
        // Creating a scene object 
        lineChart.getData().addAll(series1, series2);
        SubScene scene = new SubScene(gridPane,300,100); 

        SubScene scene1  = new SubScene(lineChart,800,600);     
        VBox root = new VBox(10);  
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(scene1,scene);
        Scene mainScene = new Scene(root,850,750);
        primaryStage.setScene(mainScene);
        primaryStage.show();

    }
}



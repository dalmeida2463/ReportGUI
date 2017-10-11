/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportgui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Dave
 */
public class ReportGUI extends Application {

  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    GridPane pane = new GridPane();
    pane.setAlignment(Pos.TOP_LEFT);
    pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
    pane.setHgap(5.5);
    pane.setVgap(5.5);
    
    pane.add(new Label("Crime Reporting GUI"), 0, 0);
    pane.add(new Label("OFFENDER \n" + "FIRST NAME:"), 0, 1); 
    pane.add(new TextField(), 1, 1);
    pane.add(new Label("OFFENDER \n" + "LAST NAME:"), 0, 2);
    pane.add(new TextField(), 1, 2);
    pane.add(new Label("OFFICER \n" + "FIRST NAME:"), 0, 3); 
    pane.add(new TextField(), 1, 3);
    pane.add(new Label("OFFICER \n" + "LAST NAME:"), 0, 4);
    pane.add(new TextField(), 1, 4);
    pane.add(new Label("LOCATION OF \n" + "EVENT: ADDRESS"),0,5);
    pane.add(new TextField(),1,5);
    Button btAdd = new Button("Add Name");
    pane.add(btAdd, 1, 6);
    GridPane.setHalignment(btAdd, HPos.RIGHT);
    
    Scene scene = new Scene(pane, 400, 400);
    primaryStage.setTitle("ShowGridPane");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
  
  public static void main(String[] args) {
    launch(args);
  }
} 

/*+/+/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportgui;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author Dave
 */
public class ReportGUI extends Application {

  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    GridPane pane = new GridPane();
    StackPane base = new StackPane(pane);
    
    Rectangle rect = new Rectangle(550,650);
    rect.setFill(Color.LIGHTBLUE);
    base.setAlignment(rect, Pos.TOP_LEFT);
    base.getChildren().add(rect);
    rect.toBack();
    
    
    
    pane.setAlignment(Pos.TOP_LEFT);
    pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
    pane.setHgap(5.5);
    pane.setVgap(5.5);
    
    pane.add(new Label("Crime Reporting GUI"), 0, 0);
    pane.add(new Label("OFFENDER \n" + "FIRST NAME:"), 0, 1); 
    pane.add(new TextField(), 1, 1);
    pane.add(new Label("OFFENDER \n" + "LAST NAME:"), 0, 2);
    pane.add(new TextField(), 1, 2);
    Label officerFirst = new Label("OFFICER \n" + "FIRST NAME:");
    officerFirst.setAlignment(Pos.BOTTOM_RIGHT);
    pane.add(officerFirst, 0, 3);
    pane.add(new TextField(), 1, 3);
    pane.add(new Label("OFFICER \n" + "LAST NAME:"), 0, 4);
    pane.add(new TextField(), 1, 4);
    pane.add(new Label("LOCATION OF \n" + "EVENT: ADDRESS"),0,5);
    pane.add(new TextField(),1,5);
    
    ObservableList<String> offensesList =
            FXCollections.observableArrayList(
                "Crime1",
                "Crime2",
                "Crime3",
                "Crime4"
            );
    ComboBox offenses = new ComboBox(offensesList);
    
    pane.add(new Label("INCIDENT \nOFFENSE"),0,6);
    pane.setHalignment(offenses, HPos.RIGHT);
    pane.setValignment(offenses, VPos.BOTTOM);
    pane.add(offenses, 1, 6);
            
    
    Scene scene = new Scene(base, 500, 600);
    primaryStage.setTitle("ShowGridPane");
    primaryStage.setScene(scene);
    primaryStage.setResizable(false);
    primaryStage.show();
  }
  
  public static void main(String[] args) {
    launch(args);
  }
} 

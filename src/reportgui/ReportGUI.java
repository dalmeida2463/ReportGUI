package reportgui;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author Dave Almeida
 */
public class ReportGUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        GridPane pane = new GridPane();
        StackPane base = new StackPane(pane);

        Rectangle rect = new Rectangle(1550,650);
        rect.setFill(Color.LIGHTBLUE);
        base.setAlignment(rect, Pos.TOP_LEFT);
        base.getChildren().add(rect);
        rect.toBack();

        pane.setAlignment(Pos.TOP_LEFT);
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane.setHgap(5.5);
        pane.setVgap(5.5);

        Label guiLabel = new Label("Crime Reporting GUI");
        Label offFirst = new Label("OFFICER \n" + "FIRST NAME:");
        Label numRecords = new Label();
        TextField firstName = new TextField();
        TextField lastName = new TextField();
        TextField offenderAge = new TextField();
        TextField officerFirst = new TextField();
        TextField officerLast = new TextField();
        TextField location = new TextField();
        TextField offense = new TextField();
        Button btSaveReport = new Button("Save Report");
        Button btAddReport = new Button("Add Report");
        Button btNumOfReports = new Button("Count Reports");

        pane.add(guiLabel, 0, 0);
        pane.setColumnSpan(guiLabel, 2);
        pane.add(offFirst, 0, 1);
        offFirst.setPrefWidth(200);
        pane.add(officerFirst, 1, 1);
        officerFirst.setPrefWidth(200);
        pane.add(new Label("OFFICER \n" + "LAST NAME:"), 0, 2);
        pane.add(officerLast, 1, 2);
        pane.add(new Label("OFFENDER \n" + "FIRST NAME:"), 0, 3); 
        pane.add(firstName, 1, 3);
        pane.add(new Label("OFFENDER \n" + "LAST NAME:"), 0, 4);
        pane.add(lastName, 1, 4);
        pane.add(new Label("OFFENDER \n" + "AGE"), 0, 5);
        pane.add(offenderAge, 1, 5);
        pane.add(new Label("LOCATION OF \n" + "EVENT: ADDRESS"),0,6);
        pane.add(location,1,6);
        pane.add(new Label("INCIDENT \nOFFENSE"),0,7);
        pane.add(offense, 1, 7);

        pane.add(btSaveReport, 0, 8);
        btSaveReport.setPrefWidth(200);
        pane.add(btAddReport, 1, 8);
        btAddReport.setPrefWidth(200);
        pane.add(btNumOfReports, 0, 9);
        btAddReport.setPrefWidth(200);

        ReportFactory factory = new CSVReportReader("ReportData.csv");
        List<ReportData> data = factory.getData();
        ReportTableView tableView = new ReportTableView(
                FXCollections.observableList(data)
        );

        btSaveReport.setOnAction(e ->{
            ReportGUI.saveRecord(officerFirst.getText(), officerLast.getText(), 
                    firstName.getText(), lastName.getText(), 
                    Integer.parseInt(offenderAge.getText()), location.getText(), 
                    offense.getText());
            officerFirst.clear(); 
            officerLast.clear();
            firstName.clear(); 
            lastName.clear();
            offenderAge.clear(); 
            location.clear();
            offense.clear();     
        });
        
        btAddReport.setOnAction(e -> {
            tableView.getItems().add(new ReportData(officerFirst.getText(), officerLast.getText(), 
                    firstName.getText(), lastName.getText(), 
                    Integer.parseInt(offenderAge.getText()), location.getText(), 
                    offense.getText()));
        });
        
        btNumOfReports.setOnAction(e -> {
            int numOfRecords = 0;
            numOfRecords = tableView.getItems().size();
            numRecords.setText("");
            numRecords.setText("There are " + numOfRecords + " records.");
            pane.add(numRecords, 0, 10);
        });
    
        pane.add(tableView, 2, 0);
        pane.setRowSpan(tableView, 10);

        System.out.println(data);

        Scene scene = new Scene(base, 1200, 550);
        primaryStage.setTitle("Crime Report");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
  
    /**
     * Main Method, GUI launches from start
     * 
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }
  
    /**
     * saveRecord method
     * Takes input from text fields in GUI and assigns to file
     * Later, data is recalled by FXCollections.observableList
     * 
     * @param officerFirst officer first name
     * @param officerLast officer last name
     * @param firstName offender first name
     * @param lastName offender last name
     * @param offenderAge offender age
     * @param location offense location
     * @param offense offense committed
     */
    public static void saveRecord(String officerFirst, String officerLast,
            String firstName, String lastName, int offenderAge, 
            String location, String offense){
        try{
            FileWriter fw = new FileWriter("ReportData.csv",true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
        
            pw.println(officerFirst + "," + officerLast + "," + firstName + "," + 
                    lastName + "," + offenderAge + "," + location + "," +
                    offense);
            pw.flush();
            pw.close();
        
            System.out.println("Report Saved");
          
        }catch(Exception E){
            System.out.println("Report failed to save");
        }
    }
} 

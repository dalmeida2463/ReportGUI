package reportgui;

import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Dave
 */
public class ReportTableView extends TableView{
    
    /**
     * Basic Constructor
     */
    public ReportTableView(){
        
    }

    /**
     * Constructor. Sets Columns
     * 
     * @param items TableView items
     */
    public ReportTableView(ObservableList<ReportData>items){
        super(items);
        setColumns();
    }
    
    private void setColumns(){
        TableColumn officerFirstColumn = 
        new TableColumn("Officer First Name");
        officerFirstColumn.setMinWidth(150);
        officerFirstColumn.setCellValueFactory(
        new PropertyValueFactory<ReportData, String>("officerFirst"));
        
        TableColumn officerLastColumn = 
        new TableColumn("Officer Last Name");
        officerLastColumn.setMinWidth(150);
        officerLastColumn.setCellValueFactory(
        new PropertyValueFactory<ReportData, String>("officerLast"));
        
        TableColumn firstNameColumn = 
        new TableColumn("Offender First Name");
        firstNameColumn.setMinWidth(150);
        firstNameColumn.setCellValueFactory(
        new PropertyValueFactory<ReportData, String>("firstName"));
        
        TableColumn lastNameColumn = 
        new TableColumn("Offender Last Name");
        lastNameColumn.setMinWidth(150);
        lastNameColumn.setCellValueFactory(
        new PropertyValueFactory<ReportData, String>("lastName"));
        
        TableColumn offenderAgeColumn = 
        new TableColumn("Offender Age");
        offenderAgeColumn.setMinWidth(50);
        offenderAgeColumn.setCellValueFactory(
        new PropertyValueFactory<ReportData, String>("offenderAge"));
        
        TableColumn locationColumn = 
        new TableColumn("Offense Location");
        locationColumn.setMinWidth(200);
        locationColumn.setCellValueFactory(
        new PropertyValueFactory<ReportData, String>("location"));
        
        TableColumn offenseColumn = 
        new TableColumn("Offense");
        offenseColumn.setMinWidth(150);
        offenseColumn.setCellValueFactory(
        new PropertyValueFactory<ReportData, String>("offense"));
        
        this.getColumns().addAll(officerFirstColumn, officerLastColumn, 
                firstNameColumn, lastNameColumn, offenderAgeColumn,
                locationColumn, offenseColumn);
    }

}

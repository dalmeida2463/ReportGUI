package reportgui;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Dave
 */
public class CSVReportReader extends ReportFactory{
    
    String dataFile;
    
    public CSVReportReader(String dataFile){
        this.dataFile = dataFile;
    }

    /**
     * getData method
     * Overridden from ReportFactory
     * Gathers Data from CSV file, and places data into ArrayList
     * ArrayList contains Report objects (data)
     * 
     * @return list of data objects with Report Information inside
     */
    @Override
    public List<ReportData> getData() {
        ArrayList<ReportData> list = new ArrayList<>();
        
        dataFile = "ReportData.csv";
        File reportData = new File(dataFile);
        try(Scanner in = new Scanner(reportData);){
            
            String line;
            if(in.hasNext()){
                line = in.nextLine();
            }
            
            while(in.hasNext()){
                line = in.nextLine();
                String officerFirst, officerLast, 
                    firstName, lastName, location, offense;
                int offenderAge;
                
                
                int nextComma = 0; 
                int firstCharacter = 0;
                nextComma = line.indexOf(",", firstCharacter);
                officerFirst = line.substring(firstCharacter, nextComma);
                
                firstCharacter = nextComma + 1;
                nextComma = line.indexOf(",", firstCharacter);
                officerLast = line.substring(firstCharacter, nextComma);
                
                firstCharacter = nextComma + 1;
                nextComma = line.indexOf(",", firstCharacter);
                firstName = line.substring(firstCharacter, nextComma);
                
                firstCharacter = nextComma + 1;
                nextComma = line.indexOf(",", firstCharacter);
                lastName = line.substring(firstCharacter, nextComma);
                
                firstCharacter = nextComma + 1;
                nextComma = line.indexOf(",", firstCharacter);
                String age = line.substring(firstCharacter, nextComma);
                offenderAge = Integer.parseInt(age);
                
                firstCharacter = nextComma + 1;
                nextComma = line.indexOf(",", firstCharacter);
                location = line.substring(firstCharacter, nextComma);
                
                firstCharacter = nextComma + 1;
                int endChar = line.length();
                endChar--;
                offense = line.substring(firstCharacter, endChar);
                
                
                ReportData data = new ReportData(officerFirst, officerLast,
                        firstName, lastName, offenderAge, location);
                System.out.println("Adding " + data.toString());
                list.add(data);
            }
            
        }catch(Exception ex){
            System.err.println(ex.toString());
            ex.printStackTrace(System.err);
        }
        return list;
    }
    
    /**
     * Test Main
     * 
     * @param args
     */
    public static void main(String[] args){
        CSVReportReader factory = new CSVReportReader("ReportData.csv");
        List<ReportData> list = factory.getData();
        list.forEach((t) -> {
            System.out.println(t.toString());
        });
    }
    
}

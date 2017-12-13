/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportgui;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dave
 */
public class CSVReportReaderTest {
    
    public CSVReportReaderTest() {
    }

    /**
     * Test of getData method, of class CSVReportReader.
     */
    @Test
    public void testGetData() {
        System.out.println("getData");
        CSVReportReader instance = new CSVReportReader("ReportData.csv");
        List<ReportData> result = instance.getData();
        assertTrue(result.size() > 0);
        result.forEach((data) -> {
            assertTrue(null != data.getOfficerFirst());
            assertTrue(null != data.getOfficerLast());
            assertTrue(null != data.getFirstName());
            assertTrue(null != data.getLastName());
            assertTrue(null != data.getLocation());
            assertTrue(null != data.getOffense());
            assertTrue(data.getOffenderAge() < 200);
            assertTrue(data.getOffenderAge() > -1);
        });
    }
    
}

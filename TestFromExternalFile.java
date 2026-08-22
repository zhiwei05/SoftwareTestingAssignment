// ============================================================
// FILE: TestFromExternalFile.java
// OWNER: Member 4
// BRANCH: feature/member4
// PURPOSE: Tests that read input values from an external CSV file
//          instead of hardcoding them. Maps to Part C.4.
// TECHNIQUES: Data-driven testing, Parameterised testing
// FRAMEWORK: JUnit 4 + file I/O
// CSV FILE: testData_calculateCharge.csv (project root)
// CSV FORMAT: paperSize,printType,printingSide,pages,copies,binding,
//             lamination,express,customerType,previousOrders,expectedTotal
// ============================================================

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.mockito.Mockito;
import java.io.BufferedReader;
import java.io.FileReader;

// Note: @RunWith is not needed here if not using @Parameters
// We manually read the file in the test method instead
public class TestFromExternalFile {

    private calculatePrintingCharge cpc;

    @Before
    public void setUp() {
        // Mock printer — always available for data-driven tests
        printerAvailability mockPrinter = Mockito.mock(printerAvailability.class);
        when(mockPrinter.isPrinterAvailable(anyString(), anyString())).thenReturn(true);
        cpc = new calculatePrintingCharge(mockPrinter, new applyDiscount());
    }

    // ── C.4: Read test data from CSV and run each row as a test case ─
    // TC reference: TC_File_001 (covers all rows in the CSV)
    @Test
    public void testCalculateCharge_fromExternalCSVFile() throws Exception {
        // TODO [Member 4]: Implement this test.
        //
        //   Steps:
        //   1. Open "testData_calculateCharge.csv" with BufferedReader
        //   2. Skip lines starting with "#" (comments)
        //   3. Split each line by ","
        //   4. Parse all values from the CSV columns
        //   5. Construct a customer object and printOrder object from the values
        //   6. Call cpc.calculateTotalCharge(order)
        //   7. assertEquals(expectedTotal, result, 0.01)
        //      Include the line content in the fail message for easier debugging:
        //      assertEquals("Failed on: " + line, expected, result, 0.01)
        //   8. Close the reader after the loop
        //
        //   CSV column mapping:
        //     parts[0]  = paperSize       (String)
        //     parts[1]  = printType       (String)
        //     parts[2]  = printingSide    (String)
        //     parts[3]  = pages           (int)
        //     parts[4]  = copies          (int)
        //     parts[5]  = bindingOption   (String)
        //     parts[6]  = lamination      (boolean)
        //     parts[7]  = expressPrinting (boolean)
        //     parts[8]  = customerType    (String)
        //     parts[9]  = previousOrders  (int)
        //     parts[10] = expectedTotal   (double)

        BufferedReader br = new BufferedReader(
            new FileReader("testData_calculateCharge.csv"));
        String line;
        int lineNum = 0;

        while ((line = br.readLine()) != null) {
            if (line.trim().startsWith("#") || line.trim().isEmpty()) continue;

            String[] parts = line.split(",");
            lineNum++;

            // TODO [Member 4]: Parse each part and cast to the correct type
            // TODO [Member 4]: Build customer object
            // TODO [Member 4]: Build printOrder object
            // TODO [Member 4]: Call calculateTotalCharge and assertEquals
        }

        br.close();

        // Sanity check: make sure we actually read some rows
        assertTrue("CSV file appears empty — check testData_calculateCharge.csv", lineNum > 0);
    }

}

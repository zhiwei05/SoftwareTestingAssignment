// ============================================================
// FILE: readCustomer.java
// OWNER: Member 1
// BRANCH: feature/member1
// PURPOSE: Reads customer information from customer.txt and
//          returns a customer object matching the given ID.
// DEPENDENCY: customer.java (must be completed by Member 1 first)
// FILE FORMAT (customer.txt):
//   Each line: customerID,name,email,phone,customerType,previousOrders
//   Example:   C001,Ali Hassan,ali@email.com,0123456789,Student,5
// DO NOT EDIT: Members 2, 3, 4
// ============================================================

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class readCustomer {

    // ── FIELDS ──────────────────────────────────────────────
    // TODO [Member 1]: Declare a private String field for the file path.
    //   This allows the path to be injected — makes unit testing easier
    //   because tests can point to a test file instead of the real file.
    private String filePath;

    // ── CONSTRUCTOR ──────────────────────────────────────────
    // TODO [Member 1]: Accept filePath as a constructor parameter and assign it.
    public readCustomer(String filePath) {
        // TODO [Member 1]: Assign filePath
    }

    // ── METHOD: getCustomer ───────────────────────────────────
    // TODO [Member 1]: Implement this method.
    //
    //   Behaviour:
    //     1. Open customer.txt using BufferedReader
    //     2. Read line by line
    //     3. Split each line by comma ","
    //     4. Compare parts[0] (customerID) to the given customerID parameter
    //     5. If found: create and return a new customer object using the line data
    //     6. If not found after reading all lines: return null
    //     7. Always close the reader (use try-finally or try-with-resources)
    //
    //   NOTE TO MEMBER 3: calculatePrintingCharge.java does NOT call this directly.
    //   It receives a fully-built customer object via the printOrder constructor.
    //   This method is primarily used at the order-creation entry point.
    //
    //   NOTE TO MEMBER 1 (testing): Your unit test should verify:
    //     - Valid ID returns a non-null customer with correct fields
    //     - Non-existent ID returns null
    //     - File not found throws IOException
    public customer getCustomer(String customerID) throws IOException {
        // TODO [Member 1]: Implement file reading logic here
        return null;
    }

}

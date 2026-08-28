// ============================================================
// FILE: addNewCustomer.java
// OWNER: Member 1
// BRANCH: feature/member1
// PURPOSE: Appends a new customer's details to customer.txt.
//          Called when a new customer registers in the system.
// DEPENDENCY: customer.java (must be completed by Member 1 first)
// FILE FORMAT: Same as readCustomer.java
//   customerID,name,email,phone,customerType,previousOrders
// DO NOT EDIT: Members 2, 3, 4
// ============================================================

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class addNewCustomer {

    // ── FIELDS ──────────────────────────────────────────────
    // TODO [Member 1]: Declare a private String field for the file path.
    private String filePath;

    // ── CONSTRUCTOR ──────────────────────────────────────────
    // TODO [Member 1]: Accept filePath and assign it.
    public addNewCustomer(String filePath) {
        this.filePath = filePath;
    }

    // ── METHOD: addCustomer ───────────────────────────────────
    // TODO [Member 1]: Implement this method.
    //
    //   Behaviour:
    //     1. Open customer.txt in APPEND mode (FileWriter second arg = true)
    //     2. Format the customer as: "ID,name,email,phone,type,previousOrders"
    //     3. Write the formatted line followed by a newline
    //     4. Close the writer (use try-finally or try-with-resources)
    //
    //   IMPORTANT: New customers always start with 0 previous orders.
    //   The customerID must be generated before calling this method.
    //   A simple approach: pass the ID in via the customer object.
    //
    //   NOTE TO MEMBER 4 (TestIntegration): Your integration test
    //   TestIntegration_AddAndReadCustomer() will call this method,
    //   then call readCustomer.getCustomer() to verify the record was saved.
    //   Use a separate test file (e.g. "test_customers.txt") so you don't
    //   corrupt the real customer.txt during testing. Delete it after the test.
    public void addCustomer(customer c) throws IOException {
        if (c == null) {
            throw new IllegalArgumentException("Customer cannot be null");
        }
        validateCsvField("customerID", c.getCustomerID());
        validateCsvField("name", c.getName());
        validateCsvField("email", c.getEmail());
        validateCsvField("phone", c.getPhone());
        validateCsvField("customerType", c.getCustomerType());

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(c.getCustomerID() + ","
                    + c.getName() + ","
                    + c.getEmail() + ","
                    + c.getPhone() + ","
                    + c.getCustomerType() + ","
                    + c.getPreviousOrders());
            writer.newLine();
        }
    }

    private void validateCsvField(String fieldName, String value) {
        if (value == null) {
            throw new IllegalArgumentException(fieldName + " cannot be null");
        }
        if (value.contains(",")) {
            throw new IllegalArgumentException(fieldName + " cannot contain commas");
        }
    }

}

// ============================================================
// FILE: customer.java
// OWNER: Member 1
// BRANCH: feature/member1
// PURPOSE: Data model that stores all customer information.
//          Other classes (readCustomer, printOrder) depend on this.
// DO NOT EDIT: Members 2, 3, 4 — import this class, do not modify it.
// ============================================================

public class customer {

    // ── FIELDS ──────────────────────────────────────────────
    // TODO [Member 1]: Declare all private fields below.
    //   Required fields (do not remove any):
    //     - customerID    (String)  e.g. "C001"
    //     - name          (String)  e.g. "Ali Hassan"
    //     - email         (String)  e.g. "ali@email.com"
    //     - phone         (String)  e.g. "0123456789"
    //     - customerType  (String)  "Regular", "Student", or "Corporate"
    //     - previousOrders (int)    number of past orders (used for loyalty discount)
    private String customerID;
    private String name;
    private String email;
    private String phone;
    private String customerType;
    private int previousOrders;

    // ── CONSTRUCTOR ──────────────────────────────────────────
    // TODO [Member 1]: Implement the constructor below.
    //   It should accept all 6 fields as parameters and assign them.
    //   Add a basic validation: if customerType is not "Regular", "Student",
    //   or "Corporate", throw an IllegalArgumentException.
    public customer(String customerID, String name, String email,
                    String phone, String customerType, int previousOrders) {
        // TODO [Member 1]: Validate customerType here
        // TODO [Member 1]: Assign all fields here
        if (!"Regular".equals(customerType) && !"Student".equals(customerType)
                && !"Corporate".equals(customerType)) {
            throw new IllegalArgumentException("Invalid customer type");
    }
        this.customerID = customerID;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.customerType = customerType;
        this.previousOrders = previousOrders;
 }

    // ── GETTERS ──────────────────────────────────────────────
    // TODO [Member 1]: Implement a getter for every field.
    //   These getters are used by: applyDiscount.java, printOrder.java,
    //   calculatePrintingCharge.java, and generateInvoice.java.
    //   Do NOT skip any getter — other members depend on all of them.

    public String getCustomerID() {
        // TODO [Member 1]: return customerID
        return customerID;
    }

    public String getName() {
        // TODO [Member 1]: return name
        return name;
    }

    public String getEmail() {
        // TODO [Member 1]: return email
        return email;
    }

    public String getPhone() {
        // TODO [Member 1]: return phone
        return phone;
    }

    public String getCustomerType() {
        // TODO [Member 1]: return customerType
        // NOTE TO MEMBER 2: applyDiscount.java reads this value to determine
        // which discount to apply. It expects exactly: "Regular", "Student", "Corporate"
        return customerType;
    }

    public int getPreviousOrders() {
        // TODO [Member 1]: return previousOrders
        // NOTE TO MEMBER 4 (TestIntegration): this value drives the loyalty discount.
        // A value > 20 triggers an additional 5% discount.
        return previoussOrders;
    }

    // ── toString (optional but useful for debugging) ─────────
    // TODO [Member 1]: Override toString() to print all customer fields.
    //   Format: "Customer[ID=C001, Name=Ali Hassan, Type=Student, Orders=5]"
    @Override
    public String toString() {
        // TODO [Member 1]: Implement this
        return "Customer[ID=" + customerID + ", Name=" + name+ ", Type=" + customerType + ", Orders=" + previousOrders + "]";
    }

}

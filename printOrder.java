// ============================================================
// FILE: printOrder.java
// OWNER: Member 3
// BRANCH: feature/member3
// PURPOSE: Data model for a print order. Stores all order inputs
//          and the computed charges. Also enforces business rule
//          constraints (pages 1–500, copies 1–1000, one binding only).
// DEPENDENCY: customer.java (Member 1) — must compile first
// USED BY: calculatePrintingCharge.java, generateInvoice.java
// DO NOT EDIT: Members 1, 2, 4
// ============================================================

public class printOrder {

    // ── INPUT FIELDS ─────────────────────────────────────────
    // TODO [Member 3]: Declare all private input fields.
    //   - customer       (customer)  the customer placing this order
    //   - printType      (String)    "Black & White" or "Colour"
    //   - paperSize      (String)    "A3", "A4", or "A5"
    //   - printingSide   (String)    "Single-sided" or "Double-sided"
    //   - numberOfPages  (int)       1 to 500
    //   - numberOfCopies (int)       1 to 1000
    //   - bindingOption  (String)    "None", "Staple", "Comb", or "Spiral"
    //   - lamination     (boolean)   true if lamination is selected
    //   - expressPrinting (boolean)  true if express printing is selected
    private customer customer;
    private String printType;
    private String paperSize;
    private String printingSide;
    private int numberOfPages;
    private int numberOfCopies;
    private String bindingOption;
    private boolean lamination;
    private boolean expressPrinting;

    // ── OUTPUT FIELDS ────────────────────────────────────────
    // TODO [Member 3]: Declare fields to store computed charge breakdown.
    //   These are set AFTER calculatePrintingCharge runs.
    //   - baseCharge             (double)
    //   - optionalServiceCharge  (double)
    //   - discountAmount         (double)
    //   - totalCharge            (double)
    //   - orderStatus            (String)  "Pending", "Completed", "Pending Payment"
    private double baseCharge;
    private double optionalServiceCharge;
    private double discountAmount;
    private double totalCharge;
    private String orderStatus;

    // ── CONSTRUCTOR ──────────────────────────────────────────
    // TODO [Member 3]: Implement the constructor with all 9 input fields.
    //
    //   VALIDATION RULES (business rules 6–9):
    //     - numberOfPages  must be >= 1 and <= 500   → throw IllegalArgumentException if not
    //     - numberOfCopies must be >= 1 and <= 1000  → throw IllegalArgumentException if not
    //     - printType      must be "Black & White" or "Colour"
    //     - paperSize      must be "A3", "A4", or "A5"
    //     - printingSide   must be "Single-sided" or "Double-sided"
    //     - bindingOption  must be "None", "Staple", "Comb", or "Spiral"
    //
    //   NOTE TO MEMBER 4 (invalid tests): Your C.2 tests will trigger these
    //   IllegalArgumentExceptions by passing invalid values (0 pages, 1001 copies, etc.)
    //   via the printOrder constructor — not via calculatePrintingCharge directly.
    //   Use @Test(expected = IllegalArgumentException.class) for those tests.
    public printOrder(customer customer, String printType, String paperSize,
                      String printingSide, int numberOfPages, int numberOfCopies,
                      String bindingOption, boolean lamination, boolean expressPrinting)
                      throws IllegalArgumentException {
        // TODO [Member 3]: Validate all inputs, then assign all fields
        // TODO [Member 3]: Set orderStatus = "Pending" by default
    }

    // ── GETTERS (for all input fields) ───────────────────────
    // TODO [Member 3]: Implement getters for all 9 input fields.
    //   NOTE: Member 4's generateInvoice.java calls all of these.
    //   Do NOT change method names — Member 4 will code against these signatures.

    public customer getCustomer()      { /* TODO [Member 3] */ return null; }
    public String getPrintType()       { /* TODO [Member 3] */ return null; }
    public String getPaperSize()       { /* TODO [Member 3] */ return null; }
    public String getPrintingSide()    { /* TODO [Member 3] */ return null; }
    public int getNumberOfPages()      { /* TODO [Member 3] */ return 0; }
    public int getNumberOfCopies()     { /* TODO [Member 3] */ return 0; }
    public String getBindingOption()   { /* TODO [Member 3] */ return null; }
    public boolean isLamination()      { /* TODO [Member 3] */ return false; }
    public boolean isExpressPrinting() { /* TODO [Member 3] */ return false; }

    // ── GETTERS & SETTERS (for computed output fields) ───────
    // TODO [Member 3]: Implement getters AND setters for all output fields.
    //   Setters are called by calculatePrintingCharge.java (Member 3)
    //   and the values are read by generateInvoice.java (Member 4).

    public double getBaseCharge()             { /* TODO [Member 3] */ return 0.0; }
    public void   setBaseCharge(double v)     { /* TODO [Member 3] */ }

    public double getOptionalServiceCharge()          { /* TODO [Member 3] */ return 0.0; }
    public void   setOptionalServiceCharge(double v)  { /* TODO [Member 3] */ }

    public double getDiscountAmount()          { /* TODO [Member 3] */ return 0.0; }
    public void   setDiscountAmount(double v)  { /* TODO [Member 3] */ }

    public double getTotalCharge()          { /* TODO [Member 3] */ return 0.0; }
    public void   setTotalCharge(double v)  { /* TODO [Member 3] */ }

    public String getOrderStatus()           { /* TODO [Member 3] */ return null; }
    public void   setOrderStatus(String s)   { /* TODO [Member 3] */ }

}

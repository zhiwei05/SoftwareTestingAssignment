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
        if (customer == null) {
            throw new IllegalArgumentException("Customer cannot be null");
        }
        if (numberOfPages < 1 || numberOfPages > 500) {
            throw new IllegalArgumentException("Number of pages must be from 1 to 500");
        }
        if (numberOfCopies < 1 || numberOfCopies > 1000) {
            throw new IllegalArgumentException("Number of copies must be from 1 to 1000");
        }
        if (!"Black & White".equals(printType) && !"Colour".equals(printType)) {
            throw new IllegalArgumentException("Invalid print type: " + printType);
        }
        if (!"A3".equals(paperSize) && !"A4".equals(paperSize) && !"A5".equals(paperSize)) {
            throw new IllegalArgumentException("Invalid paper size: " + paperSize);
        }
        if (!"Single-sided".equals(printingSide) && !"Double-sided".equals(printingSide)) {
            throw new IllegalArgumentException("Invalid printing side: " + printingSide);
        }
        if (!"None".equals(bindingOption) && !"Staple".equals(bindingOption)
                && !"Comb".equals(bindingOption) && !"Spiral".equals(bindingOption)) {
            throw new IllegalArgumentException("Invalid binding option: " + bindingOption);
        }

        this.customer = customer;
        this.printType = printType;
        this.paperSize = paperSize;
        this.printingSide = printingSide;
        this.numberOfPages = numberOfPages;
        this.numberOfCopies = numberOfCopies;
        this.bindingOption = bindingOption;
        this.lamination = lamination;
        this.expressPrinting = expressPrinting;
        this.orderStatus = "Pending";
    }

    // ── GETTERS (for all input fields) ───────────────────────
    // TODO [Member 3]: Implement getters for all 9 input fields.
    //   NOTE: Member 4's generateInvoice.java calls all of these.
    //   Do NOT change method names — Member 4 will code against these signatures.

    public customer getCustomer()      { return customer; }
    public String getPrintType()       { return printType; }
    public String getPaperSize()       { return paperSize; }
    public String getPrintingSide()    { return printingSide; }
    public int getNumberOfPages()      { return numberOfPages; }
    public int getNumberOfCopies()     { return numberOfCopies; }
    public String getBindingOption()   { return bindingOption; }
    public boolean isLamination()      { return lamination; }
    public boolean isExpressPrinting() { return expressPrinting; }

    // ── GETTERS & SETTERS (for computed output fields) ───────
    // TODO [Member 3]: Implement getters AND setters for all output fields.
    //   Setters are called by calculatePrintingCharge.java (Member 3)
    //   and the values are read by generateInvoice.java (Member 4).

    public double getBaseCharge()             { return baseCharge; }
    public void   setBaseCharge(double v)     { baseCharge = v; }

    public double getOptionalServiceCharge()          { return optionalServiceCharge; }
    public void   setOptionalServiceCharge(double v)  { optionalServiceCharge = v; }

    public double getDiscountAmount()          { return discountAmount; }
    public void   setDiscountAmount(double v)  { discountAmount = v; }

    public double getTotalCharge()          { return totalCharge; }
    public void   setTotalCharge(double v)  { totalCharge = v; }

    public String getOrderStatus()           { return orderStatus; }
    public void   setOrderStatus(String s)   { orderStatus = s; }

}

// ============================================================
// FILE: calculatePrintingCharge.java
// OWNER: Member 3
// BRANCH: feature/member3
// PURPOSE: Core charge calculation engine. Orchestrates the full
//          calculation: base charge → optional services → discounts.
//          Also checks printer availability before calculating.
// DEPENDENCIES:
//   - printerAvailability.java (Member 3) — injected via constructor
//   - applyDiscount.java       (Member 2) — injected via constructor
//   - printOrder.java          (Member 3)
//   - customer.java            (Member 1)
// DO NOT EDIT: Members 1, 2, 4
// ============================================================

public class calculatePrintingCharge {

    // ── FIELDS ──────────────────────────────────────────────
    // TODO [Member 3]: Declare the two dependency fields below.
    //
    //   IMPORTANT — WHY CONSTRUCTOR INJECTION:
    //   Member 4 needs to MOCK printerAvailability in their Mockito tests.
    //   If you use "new printerAvailability()" inside the methods, Mockito
    //   cannot replace it. By accepting it as a constructor parameter,
    //   Member 4 can pass in a mock object instead.
    //   NEVER use "new printerAvailability()" inside any method here.
    private printerAvailability printerService;
    private applyDiscount discountService;

    // ── CONSTRUCTOR ──────────────────────────────────────────
    // TODO [Member 3]: Accept both dependencies as constructor parameters.
    //   Assign them to the fields above.
    //
    //   NOTE TO MEMBER 4: In your tests, you will call:
    //     printerAvailability mockPrinter = Mockito.mock(printerAvailability.class);
    //     applyDiscount realDiscount = new applyDiscount();
    //     calculatePrintingCharge cpc = new calculatePrintingCharge(mockPrinter, realDiscount);
    public calculatePrintingCharge(printerAvailability printerService,
                                    applyDiscount discountService) {
        // TODO [Member 3]: Assign both fields
    }

    // ── METHOD: calculateBaseCharge ───────────────────────────
    // TODO [Member 3]: Implement base charge calculation.
    //
    //   Formula: Base Rate × numberOfPages × numberOfCopies
    //
    //   Base rates (from Table 2):
    //     A4 B&W  Single=0.20  Double=0.18
    //     A4 Col  Single=0.80  Double=0.75
    //     A3 B&W  Single=0.40  Double=0.35
    //     A3 Col  Single=1.50  Double=1.40
    //     A5 B&W  Single=0.15  Double=0.13
    //     A5 Col  Single=0.60  Double=0.55
    //
    //   Throw IllegalArgumentException for unrecognised paperSize or printType.
    //
    //   NOTE TO MEMBER 3 (valid tests): TestCalculatePrintingChargeValid.java
    //   tests this method directly with all 12 paper/type/side combinations.
    //
    //   NOTE TO MEMBER 4 (invalid tests): TestCalculatePrintingChargeInvalid.java
    //   tests this via the printOrder constructor (invalid pages/copies)
    //   AND directly (invalid paperSize strings).
    public double calculateBaseCharge(String paperSize, String printType,
                                       String printingSide, int pages, int copies) {
        // TODO [Member 3]: Look up the correct base rate
        // TODO [Member 3]: Return rate × pages × copies
        return 0.0;
    }

    // ── METHOD: calculateOptionalServiceCharge ────────────────
    // TODO [Member 3]: Implement optional service charge calculation.
    //
    //   Charges (from Table 3):
    //     Staple Binding  → RM 2.00 (flat per order)
    //     Comb Binding    → RM 5.00 (flat per order)
    //     Spiral Binding  → RM 8.00 (flat per order)
    //     None            → RM 0.00
    //     Lamination      → RM 1.50 × pages × copies  (total printed pages)
    //     Express Printing → RM 20.00 (flat per order)
    //
    //   Throw IllegalArgumentException for unrecognised bindingOption.
    //
    //   BUSINESS RULE 10: Lamination is charged per TOTAL printed pages
    //   (pages × copies), NOT per unique page.
    public double calculateOptionalServiceCharge(String bindingOption,
                                                  boolean lamination,
                                                  boolean expressPrinting,
                                                  int pages, int copies) {
        // TODO [Member 3]: Add binding charge
        // TODO [Member 3]: Add lamination charge (if applicable)
        // TODO [Member 3]: Add express printing charge (if applicable)
        return 0.0;
    }

    // ── METHOD: calculateTotalCharge ──────────────────────────
    // TODO [Member 3]: Implement the full calculation pipeline.
    //
    //   Steps (in this exact order — from Business Rules 1–5):
    //     1. Call printerService.isPrinterAvailable(paperSize, printType)
    //        - If false: print "Selected printer is currently unavailable."
    //                    and return -1.0 as a sentinel value
    //     2. Call calculateBaseCharge(...)
    //     3. Call calculateOptionalServiceCharge(...)
    //     4. Compute subtotal = baseCharge + optionalServiceCharge
    //     5. Determine discount flags:
    //          orderExceedsRM300    = (subtotal > 300.0)
    //          existingOver20Orders = (order.getCustomer().getPreviousOrders() > 20)
    //     6. Call discountService.applyDiscount(customerType, subtotal, ...)
    //     7. Compute discountAmount = subtotal - discountedAmount
    //     8. Round finalCharge to 2 decimal places
    //     9. Update the printOrder object with all computed values:
    //          order.setBaseCharge(baseCharge)
    //          order.setOptionalServiceCharge(optionalServiceCharge)
    //          order.setDiscountAmount(discountAmount)
    //          order.setTotalCharge(finalCharge)
    //    10. Return the finalCharge
    //
    //   NOTE TO MEMBER 4 (C.3 Mockito tests): You will stub:
    //     Mockito.when(mockPrinter.isPrinterAvailable("A4","Colour")).thenReturn(true/false)
    //   and then verify the return value of this method matches your expectation.
    public double calculateTotalCharge(printOrder order) {
        // TODO [Member 3]: Implement full pipeline here
        return 0.0;
    }

}

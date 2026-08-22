// ============================================================
// FILE: generateInvoice.java
// OWNER: Member 4
// BRANCH: feature/member4
// PURPOSE: Generates a formatted invoice string from a completed
//          printOrder object. The printOrder must already have its
//          totalCharge, baseCharge, discountAmount etc. set by
//          calculatePrintingCharge before this is called.
// DEPENDENCY: printOrder.java (Member 3), customer.java (Member 1)
// DO NOT EDIT: Members 1, 2, 3
// ============================================================

public class generateInvoice {

    // ── METHOD: generate ─────────────────────────────────────
    // TODO [Member 4]: Implement this method.
    //
    //   Input: a printOrder object with all charge fields already populated.
    //
    //   Output: a single String containing the full invoice.
    //           Use "\n" for line breaks.
    //
    //   Required invoice content (must include ALL of these):
    //     - Header:           "===== PRINTMASTER INVOICE ====="
    //     - Customer ID:      from order.getCustomer().getCustomerID()
    //     - Customer Name:    from order.getCustomer().getName()
    //     - Customer Phone:   from order.getCustomer().getPhone()
    //     - Customer Email:   from order.getCustomer().getEmail()
    //     - Print Type:       from order.getPrintType()
    //     - Paper Size:       from order.getPaperSize()
    //     - Printing Side:    from order.getPrintingSide()
    //     - Pages:            from order.getNumberOfPages()
    //     - Copies:           from order.getNumberOfCopies()
    //     - Binding:          from order.getBindingOption()
    //     - Lamination:       "Yes" or "No" from order.isLamination()
    //     - Express Printing: "Yes" or "No" from order.isExpressPrinting()
    //     - Base Charge:      "RM X.XX" from order.getBaseCharge()
    //     - Optional Charges: "RM X.XX" from order.getOptionalServiceCharge()
    //     - Discount:         "RM X.XX" from order.getDiscountAmount()
    //     - TOTAL:            "RM X.XX" from order.getTotalCharge()
    //     - Footer:           "==============================="
    //
    //   Formatting tip: Use String.format("%.2f", value) for monetary values.
    //
    //   NOTE TO MEMBER 4 (integration test): TestIntegration.java will call
    //   this method and use assertTrue(invoice.contains("CustomerName")) etc.
    //   to verify the invoice contains the expected content.
    //
    //   Throw IllegalArgumentException if order is null.
    public String generate(printOrder order) {
        // TODO [Member 4]: Validate that order is not null

        // TODO [Member 4]: Build the invoice string using StringBuilder
        //   Example structure:
        //   sb.append("===== PRINTMASTER INVOICE =====\n");
        //   sb.append("Customer: ").append(order.getCustomer().getName()).append("\n");
        //   ... (continue for all required fields)

        // TODO [Member 4]: Return the completed invoice string
        return "";
    }

}

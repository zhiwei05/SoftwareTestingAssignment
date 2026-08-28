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
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null");
        }

        customer c = order.getCustomer();
        StringBuilder sb = new StringBuilder();
        sb.append("===== PRINTMASTER INVOICE =====\n");
        sb.append("Customer ID: ").append(c.getCustomerID()).append("\n");
        sb.append("Customer Name: ").append(c.getName()).append("\n");
        sb.append("Customer Phone: ").append(c.getPhone()).append("\n");
        sb.append("Customer Email: ").append(c.getEmail()).append("\n");
        sb.append("Print Type: ").append(order.getPrintType()).append("\n");
        sb.append("Paper Size: ").append(order.getPaperSize()).append("\n");
        sb.append("Printing Side: ").append(order.getPrintingSide()).append("\n");
        sb.append("Pages: ").append(order.getNumberOfPages()).append("\n");
        sb.append("Copies: ").append(order.getNumberOfCopies()).append("\n");
        sb.append("Binding: ").append(order.getBindingOption()).append("\n");
        sb.append("Lamination: ").append(order.isLamination() ? "Yes" : "No").append("\n");
        sb.append("Express Printing: ").append(order.isExpressPrinting() ? "Yes" : "No").append("\n");
        sb.append("Base Charge: RM ").append(String.format("%.2f", order.getBaseCharge())).append("\n");
        sb.append("Optional Charges: RM ").append(String.format("%.2f", order.getOptionalServiceCharge())).append("\n");
        sb.append("Discount: RM ").append(String.format("%.2f", order.getDiscountAmount())).append("\n");
        sb.append("TOTAL: RM ").append(String.format("%.2f", order.getTotalCharge())).append("\n");
        sb.append("===============================");
        return sb.toString();
    }

}

// ============================================================
// FILE: payment.java
// OWNER: Member 4
// BRANCH: feature/member4
// PURPOSE: Payment processing module — NOT implemented.
//          Only method signatures are required.
//          This class will be used as a test double (stub/mock)
//          by other tests if needed.
// DO NOT EDIT: Members 1, 2, 3
// ============================================================

public class payment {

    // ── FIELDS (declare but do not implement logic) ──────────
    // TODO [Member 4]: Declare these fields (no logic needed):
    //   - paymentMethod  (String)  "eWallet", "CreditCard", "OnlineBanking"
    //   - paymentAmount  (double)
    //   - paymentStatus  (String)  "Success", "Failed"
    private String paymentMethod;
    private double paymentAmount;
    private String paymentStatus;

    // ── METHOD SIGNATURES ONLY ───────────────────────────────
    // TODO [Member 4]: Define the method signatures below.
    //   Do NOT implement any logic. Just define the signature and
    //   throw UnsupportedOperationException (same pattern as printerAvailability).
    //
    //   Required method signatures:
    //
    //   1. processPayment(double amount, String method) → boolean
    //      Called to initiate a payment. Returns true if successful.
    //
    //   2. getPaymentStatus() → String
    //      Returns the current payment status.
    //
    //   3. updateOrderStatus(printOrder order, boolean paymentSuccess) → void
    //      Sets order status to "Completed" if success, "Pending Payment" if failed.

    public boolean processPayment(double amount, String method) {
        // NOT IMPLEMENTED — test double only
        throw new UnsupportedOperationException("payment.processPayment() is not implemented.");
    }

    public String getPaymentStatus() {
        // NOT IMPLEMENTED — test double only
        throw new UnsupportedOperationException("payment.getPaymentStatus() is not implemented.");
    }

    public void updateOrderStatus(printOrder order, boolean paymentSuccess) {
        // NOT IMPLEMENTED — test double only
        throw new UnsupportedOperationException("payment.updateOrderStatus() is not implemented.");
    }

}

// ============================================================
// FILE: applyDiscount.java
// OWNER: Member 2
// BRANCH: feature/member2
// PURPOSE: Calculates and applies all applicable discounts
//          to the order subtotal, sequentially and cumulatively.
// CALLED BY: calculatePrintingCharge.java (Member 3)
// DO NOT EDIT: Members 1, 3, 4
// ============================================================

public class applyDiscount {

    // ── METHOD: applyDiscount ─────────────────────────────────
    // TODO [Member 2]: Implement this method.
    //
    //   Parameters:
    //     - customerType         (String)  "Regular", "Student", or "Corporate"
    //     - subtotal             (double)  base charge + optional service charges
    //     - orderExceedsRM300    (boolean) true if subtotal > RM300 (before discounts)
    //     - existingOver20Orders (boolean) true if customer.getPreviousOrders() > 20
    //
    //   Discount Rules (from Table 4 — apply IN THIS ORDER, SEQUENTIALLY):
    //     1. Student  → 10% off current amount
    //     2. Corporate → 15% off current amount
    //     3. Order > RM300 → additional 5% off current amount
    //     4. Existing customer with >20 orders → additional 5% off current amount
    //
    //   CRITICAL: Discounts are SEQUENTIAL, not simultaneous.
    //     WRONG:  finalAmount = subtotal × (1 - 0.10 - 0.05) = subtotal × 0.85
    //     CORRECT: step1 = subtotal × 0.90
    //              step2 = step1 × 0.95
    //
    //   Returns: the final discounted amount, rounded to 2 decimal places.
    //
    //   Validation:
    //     - If customerType is null or unrecognised, throw IllegalArgumentException
    //     - If subtotal < 0, throw IllegalArgumentException
    //
    //   NOTE TO MEMBER 3: calculatePrintingCharge.java calls this method after
    //   computing the subtotal. It passes:
    //     customerType  = order.getCustomer().getCustomerType()
    //     subtotal      = baseCharge + optionalServiceCharge
    //     orderExceedsRM300 = (subtotal > 300.0)
    //     existingOver20Orders = (order.getCustomer().getPreviousOrders() > 20)
    //
    //   NOTE TO MEMBER 2 (testing): TestApplyDiscount.java must cover:
    //     - No discount (Regular, subtotal <= 300, no loyalty)
    //     - Student only
    //     - Corporate only
    //     - Student + order > RM300 (sequential)
    //     - Corporate + loyalty (sequential)
    //     - All 4 discounts at once (sequential)
    //     - BVA: subtotal exactly RM300 (no extra discount)
    //     - BVA: subtotal RM300.01 (extra discount applies)
    //     - Invalid: null customerType → IllegalArgumentException
    //     - Invalid: negative subtotal → IllegalArgumentException
    public double applyDiscount(String customerType, double subtotal,
                                 boolean orderExceedsRM300,
                                 boolean existingOver20Orders) {
        // TODO [Member 2]: Validate inputs here

        // TODO [Member 2]: Apply customer type discount (Student or Corporate)

        // TODO [Member 2]: Apply order value discount if orderExceedsRM300

        // TODO [Member 2]: Apply loyalty discount if existingOver20Orders

        // TODO [Member 2]: Round to 2 decimal places and return
        return 0.0;
    }

}

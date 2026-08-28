// ============================================================
// FILE: TestApplyDiscount.java
// OWNER: Member 2
// BRANCH: feature/member2
// PURPOSE: Unit tests for applyDiscount.java.
// TECHNIQUES: Equivalence Partitioning (EP), Boundary Value Analysis (BVA),
//             Decision Table (DT)
// FRAMEWORK: JUnit 4 + JUnitParams
// ============================================================

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class TestApplyDiscount {

    private applyDiscount ad;

    @Before
    public void setUp() {
        // TODO [Member 2]: Initialise applyDiscount object
        ad = new applyDiscount();
    }

    // ── DT Rule: No discount (Regular, subtotal <= 300, no loyalty) ──
    // TC reference: TC_Discount_001
    @Test
    @Parameters({
        "Regular, 100.00, false, false, 100.00",
        "Regular, 200.00, false, false, 200.00",
        "Regular, 300.00, false, false, 300.00"
    })
    public void testNoDiscount_regularCustomerBelowRM300(
            String type, double subtotal, boolean over300, boolean loyal, double expected) {
        // EP: Valid — Regular customer, no discount conditions met
        assertEquals(expected, ad.applyDiscount(type, subtotal, over300, loyal), 0.01);
    }

    // ── DT Rule: Student discount only (10%) ─────────────────
    // TC reference: TC_Discount_002
    @Test
    public void testStudentDiscount_only_10percent() {
        // EP: Valid — Student, subtotal <= 300, no loyalty
        // 100.00 × 0.90 = 90.00
        assertEquals(90.00, ad.applyDiscount("Student", 100.00, false, false), 0.01);
    }

    // ── DT Rule: Corporate discount only (15%) ───────────────
    // TC reference: TC_Discount_003
    @Test
    public void testCorporateDiscount_only_15percent() {
        // EP: Valid — Corporate, subtotal <= 300, no loyalty
        // 200.00 × 0.85 = 170.00
        assertEquals(170.00, ad.applyDiscount("Corporate", 200.00, false, false), 0.01);
    }

    // ── DT Rule: Order > RM300 additional discount (5%) ──────
    // TC reference: TC_Discount_004
    @Test
    public void testOrderOver300Discount_regularCustomer() {
        // EP: Valid — Regular, subtotal > 300, no loyalty
        // 400.00 × 0.95 = 380.00
        assertEquals(380.00, ad.applyDiscount("Regular", 400.00, true, false), 0.01);
    }

    // ── DT Rule: Student + Order > RM300 (sequential) ────────
    // TC reference: TC_Discount_005
    @Test
    public void testStudentAndOver300_sequential() {
        // DT: Student AND subtotal > RM300 — discounts applied one at a time
        // 350.00 × 0.90 = 315.00 → 315.00 × 0.95 = 299.25
        assertEquals(299.25, ad.applyDiscount("Student", 350.00, true, false), 0.01);
    }

    // ── DT Rule: Corporate + Loyalty (sequential) ────────────
    // TC reference: TC_Discount_006
    @Test
    public void testCorporateAndLoyalty_sequential() {
        // DT: Corporate AND loyal — applied one at a time
        // 200.00 × 0.85 = 170.00 → 170.00 × 0.95 = 161.50
        assertEquals(161.50, ad.applyDiscount("Corporate", 200.00, false, true), 0.01);
    }

    // ── DT Rule: All 4 discounts (Student + over300 + loyalty) ─
    // TC reference: TC_Discount_007
    @Test
    public void testAllDiscounts_sequential() {
        // DT: Student, >RM300, loyalty — all three applied sequentially
        // 400.00 × 0.90 = 360.00 → × 0.95 = 342.00 → × 0.95 = 324.90
        assertEquals(324.90, ad.applyDiscount("Student", 400.00, true, true), 0.01);
    }

    // ── BVA: Subtotal exactly RM300 — no extra discount ──────
    // TC reference: TC_Discount_008
    @Test
    public void testBVA_subtotalExactlyRM300_noExtraDiscount() {
        // BVA: Lower boundary of "over RM300" — should NOT trigger 5% discount
        // 300.00, no discount applied → 300.00
        assertEquals(300.00, ad.applyDiscount("Regular", 300.00, false, false), 0.01);
    }

    // ── BVA: Subtotal RM300.01 — extra discount applies ──────
    // TC reference: TC_Discount_009
    @Test
    public void testBVA_subtotalRM300Point01_extraDiscountApplies() {
        // BVA: Just above boundary — SHOULD trigger 5% discount
        // 300.01 × 0.95 = 285.0095 → rounded = 285.01
        assertEquals(285.01, ad.applyDiscount("Regular", 300.01, true, false), 0.01);
    }

    // ── Parameterised: All valid customer types ───────────────
    // TC reference: TC_Discount_010
    @Test
    @Parameters({
        "Student,  100.00, false, false, 90.00",
        "Corporate, 100.00, false, false, 85.00",
        "Regular,  100.00, false, false, 100.00"
    })
    public void testAllCustomerTypes_parameterised(
            String type, double subtotal, boolean over300, boolean loyal, double expected) {
        // EP: One test per valid partition (student / corporate / regular)
        assertEquals(expected, ad.applyDiscount(type, subtotal, over300, loyal), 0.01);
    }

    // ── EP Invalid: null customer type ───────────────────────
    // TC reference: TC_Discount_011
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidCustomerType_null_throwsException() {
        // EP: Invalid partition — null is not a valid customer type
        ad.applyDiscount(null, 100.00, false, false);
    }

    // ── EP Invalid: unrecognised customer type ────────────────
    // TC reference: TC_Discount_012
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidCustomerType_unrecognised_throwsException() {
        // EP: Invalid partition — "VIP" is not a valid customer type
        ad.applyDiscount("VIP", 100.00, false, false);
    }

    // ── EP Invalid: negative subtotal ────────────────────────
    // TC reference: TC_Discount_013
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidSubtotal_negative_throwsException() {
        // BVA: Negative subtotal is invalid input
        ad.applyDiscount("Regular", -1.00, false, false);
    }

}

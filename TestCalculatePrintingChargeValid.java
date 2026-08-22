// ============================================================
// FILE: TestCalculatePrintingChargeValid.java
// OWNER: Member 3
// BRANCH: feature/member3
// PURPOSE: Unit tests for VALID inputs to calculatePrintingCharge.java.
//          Maps to Part C.1 of the assignment.
// TECHNIQUES: Equivalence Partitioning (EP), Boundary Value Analysis (BVA)
// FRAMEWORK: JUnit 4 + JUnitParams + Mockito (for printerAvailability)
// ============================================================

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.mockito.Mockito;

@RunWith(JUnitParamsRunner.class)
public class TestCalculatePrintingChargeValid {

    private calculatePrintingCharge cpc;
    private printerAvailability mockPrinter;

    @Before
    public void setUp() {
        // Mock the printer — always returns available for valid-case tests
        // This isolates calculatePrintingCharge from the external dependency
        mockPrinter = Mockito.mock(printerAvailability.class);
        when(mockPrinter.isPrinterAvailable(anyString(), anyString())).thenReturn(true);
        cpc = new calculatePrintingCharge(mockPrinter, new applyDiscount());
    }

    // ── BVA: Minimum valid pages (1) and copies (1) ──────────
    // TC reference: TC_Valid_001
    @Test
    public void testBVA_minimumPagesAndCopies() {
        // A4, B&W, Single, 1 page, 1 copy → 1 × 1 × 0.20 = 0.20
        // TODO [Member 3]: assertEquals(0.20, cpc.calculateBaseCharge("A4","Black & White","Single-sided",1,1), 0.001)
    }

    // ── BVA: Maximum valid pages (500) and copies (1000) ─────
    // TC reference: TC_Valid_002
    @Test
    public void testBVA_maximumPagesAndCopies() {
        // A4, B&W, Single, 500 pages, 1000 copies → 500 × 1000 × 0.20 = 100000.00
        // TODO [Member 3]: assertEquals(100000.00, cpc.calculateBaseCharge("A4","Black & White","Single-sided",500,1000), 0.001)
    }

    // ── EP Valid: All B&W single-sided paper sizes ────────────
    // TC reference: TC_Valid_003, 004, 005
    @Test
    @Parameters({
        "A4, Black & White, Single-sided, 10, 1, 2.00",
        "A3, Black & White, Single-sided, 10, 1, 4.00",
        "A5, Black & White, Single-sided, 10, 1, 1.50"
    })
    public void testEP_allPaperSizes_BWsingleSided(
            String paper, String type, String side, int pages, int copies, double expected) {
        // EP: One test per valid paper size (A3, A4, A5)
        // TODO [Member 3]: assertEquals(expected, cpc.calculateBaseCharge(paper, type, side, pages, copies), 0.001)
    }

    // ── EP Valid: All Colour double-sided paper sizes ─────────
    // TC reference: TC_Valid_006, 007, 008
    @Test
    @Parameters({
        "A4, Colour, Double-sided, 10, 1, 7.50",
        "A3, Colour, Double-sided, 10, 1, 14.00",
        "A5, Colour, Double-sided, 10, 1, 5.50"
    })
    public void testEP_allPaperSizes_colourDoubleSided(
            String paper, String type, String side, int pages, int copies, double expected) {
        // EP: One test per valid paper size for Colour double-sided
        // TODO [Member 3]: assertEquals(expected, cpc.calculateBaseCharge(paper, type, side, pages, copies), 0.001)
    }

    // ── EP Valid: All binding options ─────────────────────────
    // TC reference: TC_Valid_009, 010, 011, 012
    @Test
    @Parameters({
        "None,   false, false, 10, 1, 0.00",
        "Staple, false, false, 10, 1, 2.00",
        "Comb,   false, false, 10, 1, 5.00",
        "Spiral, false, false, 10, 1, 8.00"
    })
    public void testEP_allBindingOptions(
            String binding, boolean lam, boolean express, int pages, int copies, double expected) {
        // EP: One test per valid binding option
        // TODO [Member 3]: assertEquals(expected, cpc.calculateOptionalServiceCharge(binding, lam, express, pages, copies), 0.001)
    }

    // ── EP Valid: Lamination charge calculation ───────────────
    // TC reference: TC_Valid_013
    @Test
    public void testEP_laminationCharge_basedOnTotalPages() {
        // Business Rule 10: Lamination = RM1.50 × pages × copies
        // 10 pages × 2 copies × 1.50 = 30.00
        // TODO [Member 3]: assertEquals(30.00, cpc.calculateOptionalServiceCharge("None", true, false, 10, 2), 0.001)
    }

    // ── EP Valid: Express printing charge ─────────────────────
    // TC reference: TC_Valid_014
    @Test
    public void testEP_expressPrintingCharge_flatRM20() {
        // Express printing adds flat RM20.00 regardless of pages/copies
        // TODO [Member 3]: assertEquals(20.00, cpc.calculateOptionalServiceCharge("None", false, true, 10, 1), 0.001)
    }

    // ── EP Valid: Full pipeline — Regular customer, no discounts ─
    // TC reference: TC_Valid_015
    @Test
    public void testFullPipeline_regularCustomer_noDiscounts() {
        // A4, B&W, Single, 20 pages, 2 copies, no services, Regular
        // Base: 20 × 2 × 0.20 = 8.00. No discounts. Total = 8.00
        // TODO [Member 3]:
        //   customer c = new customer("C001","Test","t@t.com","012","Regular",0);
        //   printOrder order = new printOrder(c, "Black & White", "A4", "Single-sided", 20, 2, "None", false, false);
        //   assertEquals(8.00, cpc.calculateTotalCharge(order), 0.01)
    }

    // ── EP Valid: Full pipeline — Student with all services ───
    // TC reference: TC_Valid_016
    @Test
    public void testFullPipeline_studentWithServicesAndDiscount() {
        // Colour A3 Double 50 pages 2 copies + Spiral + Lamination, Student
        // Base: 50×2×1.40=140.00, Spiral=8.00, Lam=50×2×1.50=150.00
        // Subtotal=298.00, Student 10%: 298×0.90=268.20
        // TODO [Member 3]: assertEquals(268.20, ..., 0.01)
    }

}

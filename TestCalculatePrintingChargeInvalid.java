// ============================================================
// FILE: TestCalculatePrintingChargeInvalid.java
// OWNER: Member 4
// BRANCH: feature/member4
// PURPOSE: Unit tests for INVALID inputs. Maps to Part C.2.
// TECHNIQUES: Equivalence Partitioning (EP), Boundary Value Analysis (BVA)
// FRAMEWORK: JUnit 4 + JUnitParams + Mockito
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
public class TestCalculatePrintingChargeInvalid {

    private calculatePrintingCharge cpc;

    @Before
    public void setUp() {
        // Mock printer — always available so invalid inputs are the only failure path
        printerAvailability mockPrinter = Mockito.mock(printerAvailability.class);
        when(mockPrinter.isPrinterAvailable(anyString(), anyString())).thenReturn(true);
        cpc = new calculatePrintingCharge(mockPrinter, new applyDiscount());
    }

    // ── BVA: 0 pages — below minimum ─────────────────────────
    // TC reference: TC_Invalid_001
    @Test(expected = IllegalArgumentException.class)
    public void testBVA_zeroPagesInConstructor_throwsException() {
        // BVA: Just below minimum (1). printOrder constructor validates this.
        // TODO [Member 4]:
        //   customer c = new customer("C001","T","t@t.com","012","Regular",0);
        //   new printOrder(c, "Black & White", "A4", "Single-sided", 0, 1, "None", false, false);
    }

    // ── BVA: 501 pages — above maximum ───────────────────────
    // TC reference: TC_Invalid_002
    @Test(expected = IllegalArgumentException.class)
    public void testBVA_501PagesInConstructor_throwsException() {
        // BVA: Just above maximum (500).
        // TODO [Member 4]: new printOrder(... 501 pages ...)
    }

    // ── EP Invalid: Negative pages ───────────────────────────
    // TC reference: TC_Invalid_003
    @Test(expected = IllegalArgumentException.class)
    public void testEP_negativePages_throwsException() {
        // EP: Invalid low partition (< 1)
        // TODO [Member 4]: new printOrder(... -1 pages ...)
    }

    // ── BVA: 0 copies — below minimum ────────────────────────
    // TC reference: TC_Invalid_004
    @Test(expected = IllegalArgumentException.class)
    public void testBVA_zeroCopies_throwsException() {
        // BVA: Just below minimum (1)
        // TODO [Member 4]: new printOrder(... 0 copies ...)
    }

    // ── BVA: 1001 copies — above maximum ─────────────────────
    // TC reference: TC_Invalid_005
    @Test(expected = IllegalArgumentException.class)
    public void testBVA_1001Copies_throwsException() {
        // BVA: Just above maximum (1000)
        // TODO [Member 4]: new printOrder(... 1001 copies ...)
    }

    // ── EP Invalid: Unrecognised paper size ──────────────────
    // TC reference: TC_Invalid_006
    @Test(expected = IllegalArgumentException.class)
    public void testEP_invalidPaperSize_throwsException() {
        // EP: Invalid partition — "A2" is not a valid paper size
        // TODO [Member 4]: cpc.calculateBaseCharge("A2", "Black & White", "Single-sided", 10, 1)
    }

    // ── EP Invalid: Unrecognised print type ──────────────────
    // TC reference: TC_Invalid_007
    @Test(expected = IllegalArgumentException.class)
    public void testEP_invalidPrintType_throwsException() {
        // EP: Invalid partition — "Sepia" is not a valid print type
        // TODO [Member 4]: cpc.calculateBaseCharge("A4", "Sepia", "Single-sided", 10, 1)
    }

    // ── EP Invalid: Unrecognised binding option ───────────────
    // TC reference: TC_Invalid_008
    @Test(expected = IllegalArgumentException.class)
    public void testEP_invalidBindingOption_throwsException() {
        // EP: "Hot Glue" is not a valid binding option
        // TODO [Member 4]: cpc.calculateOptionalServiceCharge("Hot Glue", false, false, 10, 1)
    }

    // ── Parameterised: Multiple invalid page/copy combinations ─
    // TC reference: TC_Invalid_009
    @Test
    @Parameters({
        "0,   1",
        "-10, 1",
        "501, 1",
        "10,  0",
        "10, -5",
        "10, 1001"
    })
    public void testInvalidPagesAndCopies_parameterised(int pages, int copies) {
        // BVA + EP: All invalid page/copy boundary values
        // TODO [Member 4]:
        //   try {
        //     customer c = new customer("C001","T","t@t.com","012","Regular",0);
        //     new printOrder(c, "Black & White", "A4", "Single-sided", pages, copies, "None", false, false);
        //     fail("Expected IllegalArgumentException");
        //   } catch (IllegalArgumentException e) { /* expected */ }
    }

}

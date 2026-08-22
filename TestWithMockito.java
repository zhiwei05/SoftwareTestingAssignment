// ============================================================
// FILE: TestWithMockito.java
// OWNER: Member 4
// BRANCH: feature/member4
// PURPOSE: Tests for printerAvailability mock (test doubles).
//          Maps to Part C.3 of the assignment.
// TECHNIQUES: Mocking (Mockito), Stubbing, Verification
// FRAMEWORK: JUnit 4 + JUnitParams + Mockito
// ============================================================

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

@RunWith(JUnitParamsRunner.class)
public class TestWithMockito {

    // Declare mock using @Mock annotation
    @Mock
    private printerAvailability mockPrinter;

    private calculatePrintingCharge cpc;

    @Before
    public void setUp() {
        // REQUIRED: initialise all @Mock annotated fields
        MockitoAnnotations.initMocks(this);
        // Use real applyDiscount — only printerAvailability is mocked
        cpc = new calculatePrintingCharge(mockPrinter, new applyDiscount());
    }

    // ── Test: Printer AVAILABLE → charge is calculated ───────
    // TC reference: TC_Mock_001
    @Test
    public void testMock_printerAvailable_chargeCalculatedCorrectly() {
        // Stub: printer returns true for A4, B&W
        // when(mockPrinter.isPrinterAvailable("A4", "Black & White")).thenReturn(true);
        //
        // TODO [Member 4]:
        //   1. Stub the mock
        //   2. Create customer and printOrder
        //   3. Call cpc.calculateTotalCharge(order)
        //   4. assertEquals(expected, result, 0.01)
        //   5. verify(mockPrinter).isPrinterAvailable("A4", "Black & White")
        //      ↑ This confirms the method was actually called during execution
    }

    // ── Test: Printer UNAVAILABLE → returns -1, no charge ────
    // TC reference: TC_Mock_002
    @Test
    public void testMock_printerUnavailable_returnsNegativeOne() {
        // Stub: printer returns false for A3, Colour
        // when(mockPrinter.isPrinterAvailable("A3", "Colour")).thenReturn(false);
        //
        // TODO [Member 4]:
        //   1. Stub the mock to return false
        //   2. Create order with A3, Colour
        //   3. Call calculateTotalCharge
        //   4. assertEquals(-1.0, result, 0.001)
        //      ↑ -1.0 is the sentinel value indicating printer is unavailable
    }

    // ── Test: Verify mock is called with correct arguments ────
    // TC reference: TC_Mock_003
    @Test
    public void testMock_verifyCorrectArgumentsPassedToPrinter() {
        // This test verifies that calculatePrintingCharge passes the
        // correct paperSize and printType to printerAvailability
        //
        // TODO [Member 4]:
        //   when(mockPrinter.isPrinterAvailable("A5", "Colour")).thenReturn(true);
        //   ... create order with A5, Colour ...
        //   cpc.calculateTotalCharge(order);
        //   verify(mockPrinter, times(1)).isPrinterAvailable("A5", "Colour");
        //   ↑ Confirm the mock was called EXACTLY ONCE with the right arguments
    }

    // ── Parameterised: Different paper/type combinations ──────
    // TC reference: TC_Mock_004
    @Test
    @Parameters({
        "A4, Black & White, true",
        "A4, Colour,        true",
        "A3, Black & White, false",
        "A5, Colour,        true"
    })
    public void testMock_differentPrinterResponses_parameterised(
            String paper, String type, boolean available) {
        // EP: Test mock behavior for each paper/type combination
        // TODO [Member 4]:
        //   when(mockPrinter.isPrinterAvailable(paper, type)).thenReturn(available);
        //   ... create order ...
        //   double result = cpc.calculateTotalCharge(order);
        //   if (available) { assertTrue(result > 0); }
        //   else           { assertEquals(-1.0, result, 0.001); }
    }

}

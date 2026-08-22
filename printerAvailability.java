// ============================================================
// FILE: printerAvailability.java
// OWNER: Member 3
// BRANCH: feature/member3
// PURPOSE: External service stub. This class represents a printer
//          availability checker that is NOT implemented by this team.
//          It MUST be mocked in all tests — never call the real method.
// USED BY: calculatePrintingCharge.java (injected via constructor)
// MOCKED BY: Member 4 in TestWithMockito.java using Mockito
// DO NOT EDIT: Members 1, 2, 4
// ============================================================

public class printerAvailability {

    // ── METHOD: isPrinterAvailable ────────────────────────────
    // TODO [Member 3]: Define this method signature exactly as shown.
    //   Do NOT implement any real logic inside.
    //   This method represents an external dependency — it will always
    //   be replaced by a Mockito mock in tests.
    //
    //   Method signature (from Appendix A of assignment):
    //     boolean isPrinterAvailable(String paperSize, String printType)
    //
    //   Parameters:
    //     - paperSize  "A3", "A4", or "A5"
    //     - printType  "Black & White" or "Colour"
    //
    //   Returns:
    //     - true  if a printer is available
    //     - false if no printer is available
    //
    //   NOTE TO MEMBER 4: In TestWithMockito.java, you will do:
    //     printerAvailability mockPrinter = Mockito.mock(printerAvailability.class);
    //     Mockito.when(mockPrinter.isPrinterAvailable("A4", "Colour")).thenReturn(true);
    //   This replaces this entire method with a fake response.
    public boolean isPrinterAvailable(String paperSize, String printType) {
        // This method is intentionally unimplemented.
        // It will always be mocked during testing.
        throw new UnsupportedOperationException(
            "printerAvailability is an external service and must be mocked in tests."
        );
    }

}

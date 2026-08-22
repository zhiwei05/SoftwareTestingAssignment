// ============================================================
// FILE: TestIntegration.java
// OWNER: Member 4
// BRANCH: feature/member4
// PURPOSE: Integration tests verifying multiple real classes
//          working together. Maps to Part C.5.
//          printerAvailability is still mocked (external dependency).
//          All other classes use REAL instances, not mocks.
// FRAMEWORK: JUnit 4 + Mockito
// ============================================================

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.mockito.Mockito;
import java.io.File;

public class TestIntegration {

    // ── INTEGRATION TEST 1 ────────────────────────────────────
    // Components: calculatePrintingCharge (real) + applyDiscount (real)
    //             printerAvailability (mocked — external)
    // TC reference: TC_Int_001
    @Test
    public void testIntegration_calculateCharge_with_realApplyDiscount() {
        // This tests that the charge calculation and discount application
        // work together correctly end-to-end.
        //
        // Setup: Student customer, Colour A3 Double-sided, 50 pages, 2 copies
        //        + Spiral Binding + Lamination, no express
        //
        // Expected calculation:
        //   Base:       50 × 2 × 1.40 = 140.00
        //   Spiral:     8.00
        //   Lamination: 50 × 2 × 1.50 = 150.00
        //   Subtotal:   298.00
        //   Student 10%: 298.00 × 0.90 = 268.20
        //   Final:      268.20

        // TODO [Member 4]:
        //   printerAvailability mockPrinter = Mockito.mock(printerAvailability.class);
        //   when(mockPrinter.isPrinterAvailable(anyString(), anyString())).thenReturn(true);
        //   applyDiscount realDiscount = new applyDiscount();          ← REAL, not mocked
        //   calculatePrintingCharge cpc = new calculatePrintingCharge(mockPrinter, realDiscount);
        //
        //   customer c = new customer("C001","Ali","ali@t.com","012","Student",5);
        //   printOrder order = new printOrder(c,"Colour","A3","Double-sided",50,2,"Spiral",true,false);
        //
        //   double result = cpc.calculateTotalCharge(order);
        //   assertEquals(268.20, result, 0.01);
    }

    // ── INTEGRATION TEST 2 ────────────────────────────────────
    // Components: addNewCustomer (real) + readCustomer (real)
    // Tests the write-then-read cycle using a real temporary file
    // TC reference: TC_Int_002
    private static final String INT_TEST_FILE = "test_integration_customers.txt";

    @After
    public void cleanUpIntegrationFile() {
        // Always delete the test file after this test runs
        new File(INT_TEST_FILE).delete();
    }

    @Test
    public void testIntegration_addNewCustomer_thenReadBack() throws Exception {
        // This tests that writing a customer to file and reading it back
        // produces an identical customer object.
        //
        // TODO [Member 4]:
        //   addNewCustomer adder   = new addNewCustomer(INT_TEST_FILE);  ← REAL
        //   readCustomer   reader  = new readCustomer(INT_TEST_FILE);    ← REAL
        //
        //   customer original = new customer("C100","Siti","siti@t.com","019","Corporate",10);
        //   adder.addCustomer(original);
        //
        //   customer retrieved = reader.getCustomer("C100");
        //   assertNotNull(retrieved);
        //   assertEquals("Siti",      retrieved.getName());
        //   assertEquals("Corporate", retrieved.getCustomerType());
        //   assertEquals(10,           retrieved.getPreviousOrders());
    }

    // ── INTEGRATION TEST 3 ────────────────────────────────────
    // Components: calculatePrintingCharge (real) + generateInvoice (real)
    // Tests that a calculated order can be turned into a valid invoice
    // TC reference: TC_Int_003
    @Test
    public void testIntegration_calculateCharge_thenGenerateInvoice() {
        // This tests the full order processing pipeline:
        // calculate charge → store results in printOrder → generate invoice

        // TODO [Member 4]:
        //   printerAvailability mockPrinter = Mockito.mock(printerAvailability.class);
        //   when(mockPrinter.isPrinterAvailable(anyString(), anyString())).thenReturn(true);
        //   calculatePrintingCharge cpc = new calculatePrintingCharge(mockPrinter, new applyDiscount());
        //   generateInvoice gen = new generateInvoice();   ← REAL
        //
        //   customer c = new customer("C002","Raj","raj@t.com","011","Regular",0);
        //   printOrder order = new printOrder(c,"Black & White","A4","Single-sided",10,1,"None",false,false);
        //
        //   cpc.calculateTotalCharge(order);   // populates order's charge fields
        //   String invoice = gen.generate(order);
        //
        //   // Verify invoice contains key content
        //   assertNotNull(invoice);
        //   assertTrue(invoice.contains("Raj"));
        //   assertTrue(invoice.contains("C002"));
        //   assertTrue(invoice.contains("A4"));
        //   assertTrue(invoice.contains("RM2.00"));   // 10 × 1 × 0.20 = 2.00
    }

    // ── INTEGRATION TEST 4 (optional bonus) ───────────────────
    // Components: calculatePrintingCharge with loyalty discount
    // Tests that previousOrders > 20 correctly triggers additional 5% discount
    // TC reference: TC_Int_004
    @Test
    public void testIntegration_loyaltyDiscount_appliedForOver20Orders() {
        // TODO [Member 4]:
        //   Create a Regular customer with previousOrders = 21 (> 20)
        //   Use an order where subtotal <= 300 (only loyalty discount applies)
        //   Verify total = subtotal × 0.95
    }

}

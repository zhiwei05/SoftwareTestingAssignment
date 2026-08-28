// ============================================================
// FILE: TestCustomerFileIO.java
// OWNER: Member 1
// BRANCH: feature/member1
// PURPOSE: Unit tests for customer.java, readCustomer.java,
//          and addNewCustomer.java.
// TECHNIQUES: Equivalence Partitioning (EP), Boundary Value Analysis (BVA)
// FRAMEWORK: JUnit 4 + JUnitParams
// ============================================================

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;

@RunWith(JUnitParamsRunner.class)
public class TestCustomerFileIO {

    private readCustomer reader;
    private addNewCustomer adder;

    // Use a separate test file — never read/write the real customer.txt in tests
    private static final String TEST_FILE = "test_customer_fileio.txt";

    @Before
    public void setUp() throws Exception {
        // TODO [Member 1]: Initialise reader and adder with TEST_FILE path
        reader = new readCustomer(TEST_FILE);
        adder  = new addNewCustomer(TEST_FILE);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TEST_FILE))) {
            writer.write("C001,Ali,ali@test.com,012345,Student,5");
            writer.newLine();
            writer.write("C002,Lim,lim@test.com,0133333333,Regular,20");
            writer.newLine();
        }
    }

    @After
    public void tearDown() {
        // TODO [Member 1]: Delete TEST_FILE after each test to ensure isolation
        new File(TEST_FILE).delete();
    }

    // ── EP: Valid partition — customer ID exists ─────────────
    // TC reference: TC_FileIO_001
    @Test
    public void testReadExistingCustomer_returnsCorrectObject() throws Exception {
        customer result = reader.getCustomer("C001");
        assertNotNull(result);
        assertEquals("C001", result.getCustomerID());
        assertEquals("Student", result.getCustomerType());
    }

    // ── EP: Invalid partition — customer ID does not exist ───
    // TC reference: TC_FileIO_002
    @Test
    public void testReadNonExistentCustomer_returnsNull() throws Exception {
        assertNull(reader.getCustomer("C999"));
    }

    // ── BVA: Empty string customer ID ────────────────────────
    // TC reference: TC_FileIO_003
    @Test
    public void testReadEmptyCustomerID_returnsNull() throws Exception {
        assertNull(reader.getCustomer(""));
    }

    // ── EP: Valid — add a new customer and verify it can be read back ──
    // TC reference: TC_FileIO_004
    @Test
    public void testAddAndReadCustomer_roundTrip() throws Exception {
        customer newCustomer = new customer("C003", "Siti", "siti@test.com",
                "0199999999", "Corporate", 10);
        adder.addCustomer(newCustomer);

        customer result = reader.getCustomer(newCustomer.getCustomerID());
        assertNotNull(result);
        assertEquals(newCustomer.getName(), result.getName());
    }

    // ── EP: Invalid customer type in constructor ──────────────
    // TC reference: TC_FileIO_005
    @Test(expected = IllegalArgumentException.class)
    public void testCustomerConstructor_invalidType_throwsException() {
        // TODO [Member 1]: Create customer with type "VIP" (invalid)
        new customer("C999", "Test", "t@t.com", "0100000000", "VIP", 0);
        // Should throw IllegalArgumentException
    }

    // ── EP Invalid: comma in field would corrupt CSV format ───
    // TC reference: TC_FileIO_006
    @Test(expected = IllegalArgumentException.class)
    public void testAddCustomer_commaInName_throwsException() throws Exception {
        customer c = new customer("C999", "Test, User", "t@t.com", "0100000000", "Regular", 0);
        adder.addCustomer(c);
    }

    // ── BVA: previousOrders boundary — exactly 20 (no loyalty discount) ─
    // TC reference: TC_FileIO_007
    @Test
    public void testCustomerPreviousOrders_exactly20_noLoyaltyDiscount() {
        customer c = new customer("C020", "Test", "t@t.com", "0100000000", "Regular", 20);
        assertEquals(20, c.getPreviousOrders());
        // Note: loyalty discount applies only if previousOrders > 20
    }

    // ── Parameterised: Multiple valid customer types ──────────
    // EP: All valid customer types should be accepted
    // TC reference: TC_FileIO_008
    @Test
    @Parameters({"Regular", "Student", "Corporate"})
    public void testCustomerConstructor_validTypes_noException(String customerType) {
        customer result = new customer("C001", "Test", "t@t.com", "0100000000", customerType, 0);
        assertNotNull(result);
        assertEquals(customerType, result.getCustomerType());
    }

}

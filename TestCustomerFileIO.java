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

@RunWith(JUnitParamsRunner.class)
public class TestCustomerFileIO {

    private readCustomer reader;
    private addNewCustomer adder;

    // Use a separate test file — never read/write the real customer.txt in tests
    private static final String TEST_FILE = "test_customer_fileio.txt";

    @Before
    public void setUp() {
        // TODO [Member 1]: Initialise reader and adder with TEST_FILE path
        reader = new readCustomer(TEST_FILE);
        adder  = new addNewCustomer(TEST_FILE);
        // TODO [Member 1]: Pre-populate TEST_FILE with known test data
        // e.g. write "C001,Ali,ali@test.com,012345,Student,5" to TEST_FILE

        BufferedWriter writer = new BufferedWriter(new FileWriter(TEST_FILE, false));
        writer.write("C001,Yi Xiao,yixiao@test.com,012345,Student,7");
        writer.newLine();
        writer.write("C002,Ali Lim,alilim@test.com,016789,Regular,21");
        writer.newLine();
        writer.close();
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
        // TODO [Member 1]: Call reader.getCustomer("C001")
        // assertNotNull(result)
        // assertEquals("C001", result.getCustomerID())
        // assertEquals("Student", result.getCustomerType())
        customer result = reader.getCustomer("C001");

        assertNotNull(result);
        assertEquals("C001", result.getCustomerID());
        assertEquals("Yi Xiao", result.getName());
        assertEquals("Student", result.getCustomerType());
        assertEquals(7, result.getPreviousOrders());
    }

    // ── EP: Invalid partition — customer ID does not exist ───
    // TC reference: TC_FileIO_002
    @Test
    public void testReadNonExistentCustomer_returnsNull() throws Exception {
        // TODO [Member 1]: Call reader.getCustomer("C999")
        // assertNull(result)
        customer result = reader.getCustomer("C999");

        assertNull(result);
    }

    // ── BVA: Empty string customer ID ────────────────────────
    // TC reference: TC_FileIO_003
    @Test
    public void testReadEmptyCustomerID_returnsNull() throws Exception {
        // TODO [Member 1]: Call reader.getCustomer("")
        // Decide: does it return null or throw? Document your assumption in the report.
        // assertNull(result) OR @Test(expected = Exception.class)
        customer result = reader.getCustomer("");

        assertNull(result);
    }

    // ── EP: Valid — add a new customer and verify it can be read back ──
    // TC reference: TC_FileIO_004
    @Test
    public void testAddAndReadCustomer_roundTrip() throws Exception {
        // TODO [Member 1]:
        // 1. Create a new customer object
        // 2. Call adder.addCustomer(newCustomer)
        // 3. Call reader.getCustomer(newCustomer.getCustomerID())
        // 4. assertNotNull(result)
        // 5. assertEquals(newCustomer.getName(), result.getName())
        customer newCustomer = new customer("C006", "Bell", "bell@corp.com", "012468", "Corporate", 0);

        adder.addCustomer(newCustomer);
        customer result = reader.getCustomer("C006");

        assertNotNull(result);
        assertEquals("C006", result.getCustomerID());
        assertEquals("Bell", result.getName());
        assertEquals("bell@corp.com", result.getEmail());
        assertEquals("012468", result.getPhone());
        assertEquals("Corporate", result.getCustomerType());
        assertEquals(0, result.getPreviousOrders());
    }

    // ── EP: Invalid customer type in constructor ──────────────
    // TC reference: TC_FileIO_005
    @Test(expected = IllegalArgumentException.class)
    public void testCustomerConstructor_invalidType_throwsException() {
        // TODO [Member 1]: Create customer with type "VIP" (invalid)
        // new customer("C999", "Test", "t@t.com", "0100000000", "VIP", 0)
        // Should throw IllegalArgumentException
        new customer("C999", "David", "david@test.com", "017654", "VIP", 0);
    }

    // ── BVA: previousOrders boundary — exactly 20 (no loyalty discount) ─
    // TC reference: TC_FileIO_006
    @Test
    public void testCustomerPreviousOrders_exactly20_noLoyaltyDiscount() {
        // TODO [Member 1]: Create customer with previousOrders = 20
        // assertEquals(20, customer.getPreviousOrders())
        // Note: loyalty discount applies only if previousOrders > 20
        customer result = new customer("C020", "Tira", "tira@test.com", "0113579", "Regular", 20);
        assertEquals(20, result.getPreviousOrders());
    }

    // ── Parameterised: Multiple valid customer types ──────────
    // EP: All valid customer types should be accepted
    // TC reference: TC_FileIO_007
    @Test
    @Parameters({"Regular", "Student", "Corporate"})
    public void testCustomerConstructor_validTypes_noException(String customerType) {
        // TODO [Member 1]: Create customer with each valid type
        // assertNotNull(result)
        // assertEquals(customerType, result.getCustomerType())
        customer result = new customer("C100", "Kelvin Tan", "kelvintan@test.com", "019876", customerType, 0);
        assertNotNull(result);
        assertEquals(customerType, result.getCustomerType());
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package poe.p1;

import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author RC_Student_lab
 */
public class RegistrationNGTest {
    
    public RegistrationNGTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * Test of Username method, of class Registration.
     */
    @Test
    public void testUsername() {
        System.out.println("Username");
        String Username = "Siz_e";
        Registration instance = new Registration();
        boolean expResult = true;
        boolean result = instance.Username(Username);
        assertEquals(result, expResult);
      
        
    }

    /**
     * Test of Password method, of class Registration.
     */
    @Test
    public void testPassword() {
        System.out.println("Password");
        String Password = "Mntam@89";
        Registration instance = new Registration();
        boolean expResult = true;
        boolean result = instance.Password(Password);
        assertEquals(result, expResult);
       
        
    }

    /**
     * Test of CellphoneNumber method, of class Registration.
     */
    @Test
    public void testCellphoneNumber() {
        System.out.println("CellphoneNumber");
        String CellphoneNumber = "069898457";
        Registration instance = new Registration();
        boolean expResult = true;
        boolean result = instance.CellphoneNumber(CellphoneNumber);
        assertEquals(result, expResult);
       
        
    }

    /**
     * Test of RegisterUser method, of class Registration.
     */
    @Test
    public void testRegisterUser() {
        System.out.println("RegisterUser");
        Registration instance = new Registration();
        instance.RegisterUser();
      
       
    }

    /**
     * Test of signin method, of class Registration.
     */
    @Test
    public void testSignin() {
        System.out.println("signin");
        Registration instance = new Registration();
        instance.signin();
       
      
    }

    /**
     * Test of sendMessage method, of class Registration.
     */
    @Test
    public void testSendMessage() {
        System.out.println("sendMessage");
        Registration instance = new Registration();
        instance.sendMessage();
        
   
    }

    /**
     * Test of checkMessageID method, of class Registration.
     */
    @Test
    public void testCheckMessageID() {
        System.out.println("checkMessageID");
        Registration instance = new Registration();
        String expResult = "";
        String result = instance.checkMessageID();
        assertEquals(result, expResult);
       
    }

    /**
     * Test of createMessageHash method, of class Registration.
     */
    @Test
    public void testCreateMessageHash() {
        System.out.println("createMessageHash");
        String checkMessageID = "";
        int messageNumber = 0;
        String messageText = "";
        Registration instance = new Registration();
        String expResult = "";
        String result = instance.createMessageHash(checkMessageID, messageNumber, messageText);
        assertEquals(result, expResult);
        
       
    }

    /**
     * Test of returnTotalMessages method, of class Registration.
     */
    @Test
    public void testReturnTotalMessages() {
        System.out.println("returnTotalMessages");
        Registration instance = new Registration();
        int expResult = 0;
        int result = instance.returnTotalMessages();
        assertEquals(result, expResult);
      
        
    }

    /**
     * Test of printMessages method, of class Registration.
     */
    @Test
    public void testPrintMessages() {
        System.out.println("printMessages");
        Registration instance = new Registration();
        instance.printMessages();
       
    }

    @Test
    public void testMessageManagement() {
        System.out.println("messageManagement");
        Registration instance = new Registration();
        instance.messageManagement();
        
    }

    @Test
    public void testSearchByID() {
        System.out.println("searchByID");
        Registration instance = new Registration();
        instance.searchByID();
       
    }

    @Test
    public void testDeleteByHash() {
        System.out.println("deleteByHash");
        Registration instance = new Registration();
        instance.deleteByHash();
     
    }
    
}

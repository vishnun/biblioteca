import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class testCustomerList {
    @Test
    public void testGetCustomer(){
        ArrayList<Customer> customersRegistered=CustomerList.customerList;
        CustomerList customerList=new CustomerList();
        Customer vishnu=customerList.GetCustomer(1);
        Customer customer=customersRegistered.get(0);
        Assert.assertEquals(vishnu, customer);
    }
    @Test
    public void testVerifyUserBasedOnName(){
        String userName="Vishnu Narang";
        Assert.assertEquals("Your Customer Id is: 1",CustomerList.VerifyExistence(userName));
    }
    @Test
    public void testVerifyUserBasedOnNameFails(){
        String userName="Manali Latkar";
        Assert.assertFalse("Your Customer Id is: 1".equals(CustomerList.VerifyExistence(userName)));
    }
    @Test
    public void testVerifyUserNotExists(){
        String userName="Tom Riddle";
        Assert.assertTrue("You are not a registered Member.Talk To the Admin".equals(CustomerList.VerifyExistence(userName)));
    }
}
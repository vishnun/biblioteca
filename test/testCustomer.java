import junit.framework.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

public class testCustomer {
    ArrayList<Customer> customerList= Customer.CUSTOMERLIST;

    @Test
    public void testCustomerEquality(){
        Customer vishnu = customerList.get(0);
        Assert.assertEquals(vishnu, vishnu);
    }
    @Test
    public void testCustomerNotEqual(){
        Customer vishnu = customerList.get(0);
        Customer manali=customerList.get(1);
        Assert.assertFalse(vishnu.equals(manali));
    }

    @Test
    public void testVerifyCustomer(){
        Customer customer=customerList.get(1);
        Assert.assertTrue(customer.IsCustomer(2));
    }
    @Test
    public void testGetBookNameFromCustomer() throws IOException {
        ConsoleStub consolestub=new ConsoleStub();
        Customer customer=customerList.get(1);
        String bookname=customer.GetBookName(consolestub);
        Assert.assertTrue((consolestub.getLine(1)).equals("Enter Book Name: "));
        Assert.assertTrue((consolestub.getLine(2)).equals("Head First Java"));
        Assert.assertEquals("Head First Java",bookname);
    }

}

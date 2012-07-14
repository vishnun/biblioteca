import junit.framework.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

public class testCustomer {
    ArrayList<Customer> customerList= CustomerList.customerList;

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
    public void testVerifyCustomerBasedOnId(){
        Customer customer=customerList.get(0);
        Assert.assertTrue(customer.IsCustomer(1));
    }
    @Test
    public void testVerifyCustomerBasedOnIdFails(){
        Customer customer=customerList.get(0);
        Assert.assertFalse(customer.IsCustomer(2));
    }
    @Test
    public void testGetBookNameFromCustomer() throws IOException {
        ArrayList<String> InputListOrder=new ArrayList<String>();
        InputListOrder.add("Head First Java");
        ConsoleStub consolestub=new ConsoleStub();
        consolestub.InitializeInputSequence(InputListOrder);

        Customer customer=customerList.get(1);
        String bookname=customer.GetBookName(consolestub);

        Assert.assertEquals("Head First Java",bookname);
    }
    @Test
    public void testCustomerExists(){
        String userName="Vishnu Narang";
        Customer customer=CustomerList.customerList.get(0);
        Assert.assertEquals(1,customer.GetCustomerId(userName));
    }
    @Test
    public void testCustomerNotExists(){
        String userName="Tom Riddle";
        Customer customer=CustomerList.customerList.get(0);
        Assert.assertEquals(-1,customer.GetCustomerId(userName));
    }

}

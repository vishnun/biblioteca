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
}

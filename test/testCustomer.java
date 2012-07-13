import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: vishnun
 * Date: 7/13/12
 * Time: 11:03 AM
 * To change this template use File | Settings | File Templates.
 */
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

}

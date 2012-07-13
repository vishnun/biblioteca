import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: vishnun
 * Date: 7/13/12
 * Time: 10:06 AM
 * To change this template use File | Settings | File Templates.
 */
public class CustomerList {
    public static ArrayList<Customer> CustomerList=Customer.CUSTOMERLIST;

    public Customer GetCustomer(int CustomerId){
        for(Customer customer:CustomerList){
            if(!customer.IsCustomer(CustomerId)) continue; //Based on CustomerId Customer verifies if it has that matching Id
            return customer;
        }
        throw new RuntimeException("Book not found in Repository");
    }
}

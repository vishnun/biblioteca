import java.util.ArrayList;

public class CustomerList {
    public static ArrayList<Customer> customerList =Customer.CUSTOMERLIST;

    public Customer GetCustomer(int CustomerId){
        for(Customer customer: customerList){
            if(!customer.IsCustomer(CustomerId)) continue; //Based on CustomerId Customer verifies if it has that matching Id
            return customer;
        }
        throw new RuntimeException("You need to be a registered customer of the Library");
    }
}

import java.util.ArrayList;

public class CustomerList {
    public static ArrayList<Customer> customerList =new ArrayList<Customer>();;
    static {
        customerList.add(new Customer(1, "Vishnu Narang"));
        customerList.add(new Customer(2,"Manali Latkar"));
        customerList.add(new Customer(3, "Aman King"));
    }

    public Customer GetCustomer(int CustomerId){
        for(Customer customer: customerList){
            if(!customer.IsCustomer(CustomerId)) continue; //Based on CustomerId Customer verifies if it has that matching Id
            return customer;
        }
        throw new RuntimeException("You need to be a registered customer of the Library.");
    }

    public static String VerifyExistence(String userName) {
        int exists=-1;
        for (Customer customer : customerList) {
            exists=customer.GetCustomerId(userName);
            if (exists>0) {
                return "Your Customer Id is: "+exists;
            }
        }
        return "You are not a registered Member.Talk To the Admin";
    }
}

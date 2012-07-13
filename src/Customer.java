import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: vishnun
 * Date: 7/13/12
 * Time: 12:04 AM
 * To change this template use File | Settings | File Templates.
 */
public class Customer {
    private int id;
    private String Name;
    public static final ArrayList<Customer> CUSTOMERLIST = new ArrayList<Customer>();

    public Customer(int CustomerId, String CustomerName) {
        this.id=CustomerId;
        this.Name=CustomerName;
    }

    static {
        CUSTOMERLIST.add(new Customer(1,"Vishnu Narang"));
        CUSTOMERLIST.add(new Customer(2,"Manali Latkar"));
        CUSTOMERLIST.add(new Customer(3,"Aman King"));
    }

    public String GetBookIdFromUser() throws IOException {
        BufferedReader ReadId=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the Book Id: ");
        String BookId=ReadId.readLine();
        return BookId;
    }

    @Override
    public boolean equals(Object otherCustomer) {
        if (this == otherCustomer) return true;
        if (otherCustomer == null || getClass() != otherCustomer.getClass()) return false;
        Customer customer = (Customer) otherCustomer;
        if (id != customer.id) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (Name != null ? Name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                '}';
    }

    public boolean IsCustomer(int CustomerId) {
        if(this.id!=CustomerId) return false;
        return true;
    }
}

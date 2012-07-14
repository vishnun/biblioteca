import java.io.IOException;
import java.util.ArrayList;

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

    public String GetBookName(Console console) throws IOException {
        String msg="Enter Book Name: ";
        String b="Head First Java";
        console.println(msg);
        console.println(b);
        return "Head First Java";
    }

    @Override
    public boolean equals(Object otherCustomer) {
        if (this == otherCustomer) return true;
        if (otherCustomer == null || getClass() != otherCustomer.getClass()) return false;
        Customer customer = (Customer) otherCustomer;
        return id == customer.id;
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
        return this.id == CustomerId;
    }
}

import java.util.ArrayList;
public class Register {
    Book book;                //Book and customer define an entry in Register
    Customer customer;

    private static ArrayList<Register> ReservedBooks=new ArrayList<Register>();

    public Register(Book bookAsked, Customer borrower) {   //private
        book=bookAsked;
        customer=borrower;
    }

    public static String ReserveBook(Book bookAsked,Customer borrower){
        for(Register register: ReservedBooks){
            if (register.IsBooked(bookAsked)){
                return "Book Not available at this moment.";
            }
        }
        ReservedBooks.add(new Register(bookAsked,borrower));
        return "Your book has been Reserved Successfully";
    }
    private boolean IsBooked(Book bookAsked){
        return this.book.equals(bookAsked);
    }
}

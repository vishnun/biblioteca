import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: vishnun
 * Date: 7/12/12
 * Time: 11:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class Register {
    Book book;                //Book and customer define an entry in Register
    Customer customer;

    private static String NotAvailableMessage="Book Not available at this moment.";
    private static String BookReservedSuccessfully="Your book has been Reserved Successfully";

    private ArrayList<Register> ReservedBooks=new ArrayList<Register>();

    public Register(Book bookAsked, Customer borrower) {
        book=bookAsked;
        customer=borrower;
    }

    public String ReserveBook(Book bookAsked,Customer borrower){
        for(Register register: ReservedBooks){
            if (register.IsBooked(bookAsked)){
                return NotAvailableMessage;
            }
        }
        ReservedBooks.add(new Register(bookAsked,borrower));
        return BookReservedSuccessfully;
    }
    private boolean IsBooked(Book bookAsked){
        if(! this.book.equals(bookAsked))return false;
        return true;
    }
}

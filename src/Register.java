import java.util.ArrayList;
public class Register {
    Book book;
    private static ArrayList<Register> ReservedBooks=new ArrayList<Register>();

    private Register(Book bookAsked) {
        book=bookAsked;
    }

    public static String ReserveBook(Book bookAsked){
        for(Register register: ReservedBooks){
            if (register.IsBooked(bookAsked)){
                return "Sorry we don't have that book yet.";
            }
        }
        ReservedBooks.add(new Register(bookAsked));
        return "Thank You! Enjoy the book.";
    }
    private boolean IsBooked(Book bookAsked){
        return this.book.equals(bookAsked);
    }
}

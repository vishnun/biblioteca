import java.util.ArrayList;
public class BookRepository {
    public static ArrayList<Book> BookList=new ArrayList<Book>();
    static {
        BookList.add(0, new Book("j1", "Head First Java", "Kethy Sieria"));
        BookList.add(0, new Book("p1", "Let Us C", "Dennis Richie"));
    }

    public ArrayList<String> DisplayAllBooks(){
        ArrayList<String> books=new ArrayList<String>();
        for(Book book:BookList){
            books.add(book.Display());
        }
        return books;
    }
    public Book GetBook(String name){
        for(Book book:BookList){
            if(!book.IsBook(name)) continue; //Based on book name the book verifies that its NAME is 'name'
            return book;
        }
        throw new RuntimeException("Book not found in Repository");
    }
}

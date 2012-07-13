import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: vishnun
 * Date: 7/12/12
 * Time: 7:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class BookRepository {
    public static ArrayList<Book> BookList=Book.BOOKLIST;

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

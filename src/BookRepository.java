import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: vishnun
 * Date: 7/12/12
 * Time: 7:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class BookRepository {
    ArrayList<Book> BookList=Book.BOOKLIST;
    public ArrayList<String> DisplayAllBooks(){
        ArrayList<String> books=new ArrayList<String>();
        for(Book book:BookList){
            books.add(book.Display());
        }
        return books;
    }
}

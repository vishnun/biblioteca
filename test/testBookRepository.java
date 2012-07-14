import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class testBookRepository {
    @Test
    public void testDisplayAllBooks(){
        BookRepository bookRepository=new BookRepository();
        ArrayList<String> booksDiaplayed=new ArrayList<String>();
        booksDiaplayed.add("p1"+" Let Us C"+" Dennis Richie");
        booksDiaplayed.add("j1"+" Head First Java"+" Kethy Sieria");
        Assert.assertEquals(booksDiaplayed,bookRepository.DisplayAllBooks());
    }
    @Test
    public void testGetBook(){
        ArrayList<Book> booksAvailable=BookRepository.BookList;
        BookRepository bookRepository=new BookRepository();
        Book bookReturned=bookRepository.GetBook("Head First Java");
        Book ActualBook=booksAvailable.get(1);
        Assert.assertEquals(ActualBook, bookReturned);
    }
}

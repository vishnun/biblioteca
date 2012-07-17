import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class testBookRepository {
    @Test
    public void testDisplayAllBooks(){
        BookRepository bookRepository=new BookRepository();
        ArrayList<String> booksDiaplayed=new ArrayList<String>();
        booksDiaplayed.add("1 \"Let Us C\""+" -by- "+"\"Dennis Richie\"");
        booksDiaplayed.add("2 \"Head First Java\""+" -by- "+"\"Kethy Sieria\"");
        booksDiaplayed.add("3 \"Harry Potter\""+" -by- "+"\"J K Rowling\"");
        Assert.assertEquals(booksDiaplayed, bookRepository.DisplayAllBooks());
    }
    @Test
    public void testGetBook(){
        BookRepository bookRepository=new BookRepository();
        Book bookReturned=bookRepository.GetBook(1);
        Book ActualBook=BookRepository.BookList.get(0);
        Assert.assertEquals(ActualBook, bookReturned);
    }
}

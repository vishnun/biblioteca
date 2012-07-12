import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: vishnun
 * Date: 7/12/12
 * Time: 7:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class testBookRepository {
    @Test
    public void testDisplay(){
        BookRepository bookRepository=new BookRepository();
        ArrayList<String> booksDiaplayed=new ArrayList<String>();
        booksDiaplayed.add("p1"+" Let Us C"+" Dennis Richie");
        booksDiaplayed.add("j1"+" Head First Java"+" Kethy Sieria");
        Assert.assertEquals(booksDiaplayed,bookRepository.DisplayAllBooks());
    }
}

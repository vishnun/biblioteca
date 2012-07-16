import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class testBook {
    ArrayList BookList= BookRepository.BookList;
    @Test
    public void testBookEqual(){
        Book java1 = (Book) BookList.get(0);
        Assert.assertEquals(java1, java1);
    }
    @Test
    public void testBookNotEqual(){
        Book java1 = (Book) BookList.get(0);
        Book c1 =(Book) BookList.get(1);
        Assert.assertFalse(java1.equals(c1));
    }
    @Test
    public void testDisplay(){
        Book J1= (Book) BookList.get(1);
        String ExpectedOutput="\"Head First Java\""+" -by- "+"\"Kethy Sieria\"";
        String BookDisplayed= J1.Display();
        Assert.assertEquals(ExpectedOutput,BookDisplayed);
    }
}

import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class testBook {
    ArrayList BookList= Book.bookList;
    @Test
    public void testBookEqual(){
        Book java1 = (Book) BookList.get(0);
        Book c1 =(Book) BookList.get(1);
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
        ArrayList<String> ExpectedOutput=new ArrayList<String>();
            ExpectedOutput.add("j1");
            ExpectedOutput.add("Head First Java");
            ExpectedOutput.add("Kethy Sieria");
        ArrayList<String> BookDisplayed= J1.Display();
        Assert.assertEquals(ExpectedOutput,BookDisplayed);
    }
}

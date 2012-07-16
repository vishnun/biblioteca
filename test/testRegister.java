import junit.framework.Assert;
import org.junit.Test;
public class testRegister {
    @Test
    public void testReserveBookSuccessfulMessage(){
        Book Java1=BookRepository.BookList.get(0);
        Assert.assertEquals("Thank You! Enjoy the book.",Register.ReserveBook(Java1));
    }
    @Test
    public void testReserveBookUnSuccessfulMessage(){
        Book Java1=BookRepository.BookList.get(0);
        Register.ReserveBook(Java1);
        Assert.assertEquals("Sorry we don't have that book yet.",Register.ReserveBook(Java1));
    }
}

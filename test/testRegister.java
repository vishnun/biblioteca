import junit.framework.Assert;
import org.junit.Test;
public class testRegister {
    @Test
    public void testReserveBookSuccessfulMessage(){
        Book Java1=Book.BOOKLIST.get(0);
        Customer vishnu=Customer.CUSTOMERLIST.get(0);
        Assert.assertEquals("Your book has been Reserved Successfully",Register.ReserveBook(Java1, vishnu));
    }
    @Test
    public void testReserveBookUnSuccessfulMessage(){
        Book Java1=Book.BOOKLIST.get(0);
        Customer vishnu=Customer.CUSTOMERLIST.get(0);
        Register.ReserveBook(Java1, vishnu);
        Customer manali=Customer.CUSTOMERLIST.get(1);
        Assert.assertEquals("Book Not available at this moment.",Register.ReserveBook(Java1, manali));
    }
}

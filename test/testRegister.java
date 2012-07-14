import junit.framework.Assert;
import org.junit.Test;
public class testRegister {
    @Test
    public void testReserveBookSuccessfulMessage(){
        Book Java1=BookRepository.BookList.get(0);
        Customer vishnu=CustomerList.customerList.get(0);
        Assert.assertEquals("Your book has been Reserved Successfully",Register.ReserveBook(Java1, vishnu));
    }
    @Test
    public void testReserveBookUnSuccessfulMessage(){
        Book Java1=BookRepository.BookList.get(0);
        Customer vishnu=CustomerList.customerList.get(0);
        Register.ReserveBook(Java1, vishnu);
        Customer manali=CustomerList.customerList.get(1);
        Assert.assertEquals("Book Not available at this moment.",Register.ReserveBook(Java1, manali));
    }
}

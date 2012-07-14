import junit.framework.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

public class testLibrary {

    @Test
    public void testWelcomeMessage(){
        ConsoleStub consolestub=new ConsoleStub();
        Library library=new Library();
        library.showWelcomeMessage(consolestub);
        Assert.assertTrue(consolestub.getLine(1).equals("Welcome to the Library"));
    }
    @Test
    public void testMenuDisplay(){
        ConsoleStub consolestub=new ConsoleStub();
        Library library=new Library();
        library.DisplayMenu(consolestub);
        Assert.assertTrue(consolestub.getLine(1).equals("1. Show All Books"));
        Assert.assertTrue(consolestub.getLine(2).equals("2. Reserve a Book"));
        Assert.assertTrue(consolestub.getLine(3).equals("3. Verify Library number"));
        Assert.assertTrue(consolestub.getLine(4).equals("4. Exit"));
    }

    @Test
    public void testValidOptionSelectionMessage() throws IOException {
        Library library=new Library();
        ConsoleStub consolestub=new ConsoleStub();
        int OPTION_INVALID = 5;
        library.selectOption(OPTION_INVALID,consolestub);
        Assert.assertTrue(consolestub.getLine(1).equals("Please select a Valid Option"));
    }
    @Test
    public void testOptionOneDisplayAllBooks() throws IOException {
        Library library=new Library();
        ConsoleStub consolestub=new ConsoleStub();
        int OPTION_SHOWALLBOOKS = 1;
        library.selectOption(OPTION_SHOWALLBOOKS,consolestub);
        Assert.assertTrue(consolestub.getLine(1).equals("p1"+" Let Us C"+" Dennis Richie"));
        Assert.assertTrue(consolestub.getLine(2).equals("j1"+" Head First Java"+" Kethy Sieria"));
    }

    @Test
    public void testReserveBookSuccessfullyOption()  {
        int OPTION_RESERVEBOOK=2;
        Library library=new Library();
        ArrayList<String> InputListOrder=new ArrayList<String>();
        InputListOrder.add("Head First Java");
        InputListOrder.add("1");
        ConsoleStub consolestub=new ConsoleStub();
        consolestub.InitializeInputSequence(InputListOrder);
        String BookReservedSuccessfully="Your book has been Reserved Successfully";
        library.selectOption(OPTION_RESERVEBOOK,consolestub);
        Assert.assertTrue(consolestub.getLine(3).equals(BookReservedSuccessfully));
    }
    @Test
    public void testReserveBookFailedOption() {
        int OPTION_RESERVEBOOK=2;
        Library library=new Library();
        ArrayList<String> InputListOrder=new ArrayList<String>();
        InputListOrder.add("Head First Java");
        InputListOrder.add("1");
        InputListOrder.add("Head First Java");
        InputListOrder.add("1");
        ConsoleStub consolestub=new ConsoleStub();
        consolestub.InitializeInputSequence(InputListOrder);
        String NotAvailableMessage="Book Not available at this moment.";
        library.selectOption(OPTION_RESERVEBOOK,consolestub);//Reserve Book
        library.selectOption(OPTION_RESERVEBOOK,consolestub);//Again Reserve It : Should say already reserved
        Assert.assertEquals(NotAvailableMessage,consolestub.getLine(6));
    }
    @Test
    public void testVerifyLibraryNumberSuccess(){
        Library library=new Library();
        ArrayList<String> InputListOrder=new ArrayList<String>();
        InputListOrder.add("Vishnu Narang");
        ConsoleStub consolestub=new ConsoleStub();
        consolestub.InitializeInputSequence(InputListOrder);
        int OPTION_VERIFYLIBRARYNUMBER = 3;
        library.selectOption(OPTION_VERIFYLIBRARYNUMBER,consolestub);
        String YourIdReturned="Your Customer Id is: 1";
        Assert.assertEquals(YourIdReturned,consolestub.getLine(2));
    }
    @Test
    public void testExitMessage(){
        Library library=new Library();
        ConsoleStub consolestub=new ConsoleStub();
        int OPTION_EXIT = 4;
        library.selectOption(OPTION_EXIT,consolestub);
        Assert.assertEquals("Thank you. Visit again soon.",consolestub.getLine(1));
    }
}

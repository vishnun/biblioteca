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
        Assert.assertTrue(consolestub.getLine(1).equals("1. View All Books"));
        Assert.assertTrue(consolestub.getLine(2).equals("2. Reserve a Book"));
        Assert.assertTrue(consolestub.getLine(3).equals("3. Check Library number"));
        Assert.assertTrue(consolestub.getLine(4).equals("4. Exit"));
    }

    @Test
    public void testValidOptionSelectionMessage() throws IOException {
        Library library=new Library();
        ConsoleStub consolestub=new ConsoleStub();
        int OPTION_INVALID = 5;
        library.selectOption(OPTION_INVALID,consolestub);
        Assert.assertTrue(consolestub.getLine(1).equals("Select a valid option!!"));
    }
    @Test
    public void testOptionOneDisplayAllBooks() throws IOException {
        Library library=new Library();
        ConsoleStub consolestub=new ConsoleStub();
        int OPTION_SHOWALLBOOKS = 1;
        library.selectOption(OPTION_SHOWALLBOOKS,consolestub);
        Assert.assertTrue(consolestub.getLine(1).equals("Books Available:"));
        Assert.assertTrue(consolestub.getLine(2).equals("1 \"Let Us C\""+" -by- "+"\"Dennis Richie\""));
        Assert.assertTrue(consolestub.getLine(3).equals("2 \"Head First Java\""+" -by- "+"\"Kethy Sieria\""));
    }

    @Test
    public void testReserveBookSuccessfullyOption()  {
        int OPTION_RESERVEBOOK=2;
        Library library=new Library();
        ArrayList<String> InputListOrder=new ArrayList<String>();
        InputListOrder.add("2");
        ConsoleStub consolestub=new ConsoleStub();
        consolestub.InitializeInputSequence(InputListOrder);
        String BookReservedSuccessfully="Thank You! Enjoy the book.";
        library.selectOption(OPTION_RESERVEBOOK,consolestub);
        Assert.assertEquals(consolestub.getLine(2),(BookReservedSuccessfully));
    }
    @Test
    public void testReserveBookFailedOption() {
        int OPTION_RESERVEBOOK=2;
        Library library=new Library();
        ArrayList<String> InputListOrder=new ArrayList<String>();
        InputListOrder.add("1");
        InputListOrder.add("1");
        ConsoleStub consolestub=new ConsoleStub();
        consolestub.InitializeInputSequence(InputListOrder);
        String NotAvailableMessage="Sorry we don't have that book yet.";
        library.selectOption(OPTION_RESERVEBOOK,consolestub);//Reserve Book
        library.selectOption(OPTION_RESERVEBOOK,consolestub);//Again Reserve It : Should say already reserved
        Assert.assertEquals(NotAvailableMessage,consolestub.getLine(4));
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

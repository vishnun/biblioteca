import junit.framework.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

public class testLibrary {
    private int OPTION_SHOWALLBOOKS=1;
    private int OPTION_RESERVEBOOK=2;
    private int OPTION_VERIFYLIBRARYCARD=3;
    private int OPTION_EXIT=4;
    private int OPTION_INVALID=5;
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
        library.selectOption(OPTION_INVALID,consolestub);
        Assert.assertTrue(consolestub.getLine(1).equals("Please select a Valid Option"));
    }
    @Test
    public void testOptionOneDisplayAllBooks() throws IOException {
        Library library=new Library();
        ConsoleStub consolestub=new ConsoleStub();
        library.selectOption(OPTION_SHOWALLBOOKS,consolestub);
        Assert.assertTrue(consolestub.getLine(1).equals("p1"+" Let Us C"+" Dennis Richie"));
        Assert.assertTrue(consolestub.getLine(2).equals("j1"+" Head First Java"+" Kethy Sieria"));
    }

    @Test
    public void testReserveBookSuccessfullyOption()  {
        Library library=new Library();
        ArrayList<String> InputListOrder=new ArrayList<String>();
        InputListOrder.add("Head First Java");
        InputListOrder.add("1");
        ConsoleStub consolestub=new ConsoleStub();
        consolestub.InitializeInputSequence(InputListOrder);
        String BookReservedSuccessfully="Your book has been Reserved Successfully";
        try {
            library.selectOption(OPTION_RESERVEBOOK,consolestub);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(consolestub.getLine(3).equals(BookReservedSuccessfully));
    }
    @Test
    public void testReserveBookFailedOption() {
        Library library=new Library();
        ArrayList<String> InputListOrder=new ArrayList<String>();
        InputListOrder.add("Head First Java");
        InputListOrder.add("1");
        ConsoleStub consolestub=new ConsoleStub();
        consolestub.InitializeInputSequence(InputListOrder);

        String NotAvailableMessage="Book Not available at this moment.";
        try {
            library.selectOption(OPTION_RESERVEBOOK,consolestub);//Reserve Book
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            library.selectOption(OPTION_RESERVEBOOK,consolestub);//Again Reserve It : Should say already reserved
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(consolestub.getLine(6).equals(NotAvailableMessage));
    }
}

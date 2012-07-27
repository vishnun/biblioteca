package com.twu28.biblioteca;

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
        library.displayMenu(consolestub);
        AssertMenu(consolestub);
    }

    private void AssertMenu(ConsoleStub consolestub) {
        Assert.assertTrue(consolestub.getLine(1).equals("1. Login"));
        Assert.assertTrue(consolestub.getLine(2).equals("2. View All Books"));
        Assert.assertTrue(consolestub.getLine(3).equals("3. Reserve a Book"));
        Assert.assertTrue(consolestub.getLine(4).equals("4. Check Library number"));
        Assert.assertTrue(consolestub.getLine(5).equals("5. View All Movies"));
        Assert.assertTrue(consolestub.getLine(6).equals("6. Exit"));
        Assert.assertTrue(consolestub.getLine(7).equals("7. Logout"));
    }

    @Test
    public void testValidOptionSelectionMessage() throws IOException {
        Library library=new Library();
        ConsoleStub consolestub=new ConsoleStub();
        int invalidOption = 0;
        library.selectOption(invalidOption,consolestub);
        Assert.assertTrue(consolestub.getLine(1).equals("Select a valid option!!"));
    }
    @Test
    public void testOptionOneDisplayAllBooks() throws IOException {
        Library library=new Library();
        ConsoleStub consolestub=new ConsoleStub();
        int showAllBooks = 2;
        library.selectOption(showAllBooks,consolestub);
        AssertBooks(consolestub);
    }

    private void AssertBooks(ConsoleStub consolestub) {
        Assert.assertTrue(consolestub.getLine(1).equals("Books Available:"));
        Assert.assertTrue(consolestub.getLine(2).equals("1 \"Let Us C\""+" -by- "+"\"Dennis Richie\""));
        Assert.assertTrue(consolestub.getLine(3).equals("2 \"Head First Java\""+" -by- "+"\"Kethy Sieria\""));
    }

    @Test
    public void testReserveBookSuccessfullyOption()  {
        int reserveBook=3;
        Library library=new Library();
        ArrayList<String> InputListOrder=new ArrayList<String>();
        InputListOrder.add("2");
        ConsoleStub consolestub=new ConsoleStub();
        consolestub.initializeInputSequence(InputListOrder);
        String BookReservedSuccessfully="Thank You! Enjoy the book.";
        library.selectOption(reserveBook,consolestub);
        Assert.assertEquals(consolestub.getLine(2), (BookReservedSuccessfully));
    }
    @Test
    public void testReserveBookFailedOption() {
        int reserveBook=3;
        Library library=new Library();
        ArrayList<String> InputListOrder=new ArrayList<String>();
        InputListOrder.add("1");
        InputListOrder.add("1");
        ConsoleStub consolestub=new ConsoleStub();
        consolestub.initializeInputSequence(InputListOrder);
        String NotAvailableMessage="Sorry we don't have that book yet.";
        library.selectOption(reserveBook,consolestub);//Reserve Book
        library.selectOption(reserveBook,consolestub);//Again Reserve It : Should say already reserved
        Assert.assertEquals(NotAvailableMessage,consolestub.getLine(4));
    }

    @Test
    public void testViewMovies(){
        Library library=new Library();
        ConsoleStub consoleStub=new ConsoleStub();
        int viewMovies=5;
        library.selectOption(viewMovies,consoleStub);
        AssertMovies(consoleStub);
    }

    private void AssertMovies(ConsoleStub consoleStub) {
        Assert.assertTrue(consoleStub.getLine(1).equals("The Shawshank Redemption" + "\t" + "Frank Darabont" + "\t" + "9/10"));
        Assert.assertTrue(consoleStub.getLine(2).equals("The Dark Knight"+"\t"+"Christopher Nolan"+"\t"+"8/10"));
    }

    @Test
    public void testExitMessage(){
        Library library=new Library();
        ConsoleStub consolestub=new ConsoleStub();
        int exit = 6;
        library.selectOption(exit,consolestub);
        Assert.assertEquals("Thank you. Visit again soon.",consolestub.getLine(1));
    }
    @Test
    public void testSuccessfulLogin(){
        Library library=new Library();
        ConsoleStub consoleStub=new ConsoleStub();
        consoleStub = executeLogin(library,consoleStub);
        Assert.assertEquals("Login Successful",consoleStub.getLine(3));
    }

    private ConsoleStub executeLogin(Library library, ConsoleStub consoleStub) {
        ArrayList<String> InputListOrder=new ArrayList<String>();
        InputListOrder.add("222-2222");
        InputListOrder.add("222-2222");
        consoleStub.initializeInputSequence(InputListOrder);
        int login=1;
        library.selectOption(login,consoleStub);
        return consoleStub;
    }

    @Test
    public void testLibrarianSuccessfulLogin(){
        Library library=new Library();
        ConsoleStub consoleStub=new ConsoleStub();
        consoleStub = executeLibrarianLogin(library,consoleStub);
        Assert.assertEquals("Welcome Librarian.",consoleStub.getLine(3));
    }
    private ConsoleStub executeLibrarianLogin(Library library, ConsoleStub consoleStub) {
        ArrayList<String> InputListOrder=new ArrayList<String>();
        InputListOrder.add("111-1111");
        InputListOrder.add("111-1111");
        consoleStub.initializeInputSequence(InputListOrder);
        int login=1;
        library.selectOption(login,consoleStub);
        return consoleStub;
    }

    @Test
    public void testUnsuccessfulLogin(){
        Library library=new Library();
        ConsoleStub consoleStub=new ConsoleStub();
        ArrayList<String> InputListOrder=new ArrayList<String>();
        InputListOrder.add("111-1111");
        InputListOrder.add("Vishnu");
        consoleStub.initializeInputSequence(InputListOrder);
        int login=1;
        library.selectOption(login,consoleStub);
        Assert.assertEquals("Login Un-Successful",consoleStub.getLine(3));
    }
    @Test
    public void testGetLibraryNumberSuccessful(){
        int login=1;
        int GetLibraryNumber=4;
        Library library=new Library();
        ConsoleStub consoleStub=new ConsoleStub();
        ArrayList<String> InputListOrder=new ArrayList<String>();
        InputListOrder.add("111-1111");
        InputListOrder.add("111-1111");
        consoleStub.initializeInputSequence(InputListOrder);
        library.selectOption(login,consoleStub);
        library.selectOption(GetLibraryNumber,consoleStub);
        Assert.assertEquals("Your Library Number is: 111-1111",consoleStub.getLine(4));
    }
    @Test
    public void testLogout(){
        Library library=new Library();
        ConsoleStub consoleStub=new ConsoleStub();
        consoleStub = executeLogin(library, consoleStub);
        int logout=7;
        library.selectOption(logout,consoleStub);
        Assert.assertEquals("Logged Out",consoleStub.getLine(4));
    }
}

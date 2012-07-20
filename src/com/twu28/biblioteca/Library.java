package com.twu28.biblioteca;
import java.util.ArrayList;

public class Library {

    private CustomerMenu menu=new CustomerMenu();
    private BookRepository bookRepository=new BookRepository();
    private String currentUser="";
    private String librarian="111-1111";

    public void showWelcomeMessage(Console console) {
        console.println("Welcome to the Library");
    }

    public void DisplayMenu(Console console) {
        menu.Display(console);
    }

    public void selectOption(int option, Console console) {
        switch (option){
            case 1:
                initiateLoginProcess(console);
                break;
            case 2:
                displayAllBooks(console);
                break;
            case 3:
                bookReservation(console);
                break;
            case 4:
                getLibraryNumber(console);
                break;
            case 5:
                displayAllMovies(console);
                break;
            case 6:
                console.println("Thank you. Visit again soon.");
                break;
            case 7:
                logout(console);
                break;
            default:
                console.println("Select a valid option!!");
        }
    }

    private void logout(Console console) {
        if(currentUser.isEmpty()){
            console.println("You need to login first.");
            return;
        }
        console.println("Logged Out");
        currentUser="";
    }

    private void displayAllMovies(Console console) {
        MovieCollection movieCollection= new MovieCollection();
        ArrayList<String> movies = movieCollection.viewAll();
        for (String movie : movies) {
            console.println(movie);
        }
    }

    private void getLibraryNumber(Console console) {
        String librarianMessage="Please talk to Librarian. Thank you.";
        if(!currentUser.isEmpty()){
            console.println("Your Library Number is: "+currentUser);
            return;
        }
        console.println(librarianMessage);
    }

    private void displayAllBooks(Console console) {
        console.println("Books Available:");
        ArrayList<String> listOfBooks=bookRepository.DisplayAllBooks();
        for (String listOfBook : listOfBooks)
            console.println(listOfBook);
    }

    private void initiateLoginProcess(Console console) {
        console.println("Enter Your username: ");
        String username=console.readInput();
        console.println("Enter Your password: ");
        String password = console.readPassword();
        try{
            currentUser= User.authenticate(username, password);
            if(currentUser.equals(librarian)){
                console.println("Welcome Librarian.");
                return;
            }
            console.println("Login Successful");
        }catch (Exception UnsuccessfulLogin){
            console.println(UnsuccessfulLogin.getMessage());
        }
    }

    private void bookReservation(Console console) {
        console.println("Enter the Serial Number of the Book: ");
        int bookSrNo = 0;
        try{
            bookSrNo = Integer.parseInt(console.readInput());
        }catch (Exception wrongInput){
            console.println("Please Enter a number");
            return;
        }
        try{
            String message=bookRepository.reserveBook(bookSrNo);
            console.println(message);
        }catch (Exception bookNotFound){
            console.println(bookNotFound.getMessage());
        }

    }
}
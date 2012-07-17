package com.twu28.biblioteca;
import java.util.ArrayList;

public class Library {

    private CustomerMenu menu=new CustomerMenu();
    private BookRepository bookRepository=new BookRepository();
    public void showWelcomeMessage(Console console) {
        console.println("Welcome to the Library");
    }

    public void DisplayMenu(Console console) {
        menu.Display(console);
    }

    public void selectOption(int option, Console console) {
        switch (option){
            case 1:
                console.println("Books Available:");
                ArrayList <String> listOfBooks=bookRepository.DisplayAllBooks();
                for (String listOfBook : listOfBooks)
                    console.println(listOfBook);
                break;
            case 2:
                bookReservation(console);
                break;
            case 3:
                String librarianMessage="Please talk to Librarian. Thank you.";
                console.println(librarianMessage);
                break;
            case 4:
                console.println("Thank you. Visit again soon.");
                break;
            default:
                console.println("Select a valid option!!");
        }
    }

    private void bookReservation(Console console) {
        console.println("Enter the Serial Number of the Book: ");
        int bookSrNo = 0;
        try{
            bookSrNo = Integer.parseInt(console.GetUserInput());
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
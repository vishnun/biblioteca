package com.twu28.biblioteca;

public class BookReservationCommand implements Command {
    private BookRepository bookRepository;

    public BookReservationCommand(BookRepository bookRepository) {
        this.bookRepository=bookRepository;
    }

    @Override
    public void execute(Console console) {
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

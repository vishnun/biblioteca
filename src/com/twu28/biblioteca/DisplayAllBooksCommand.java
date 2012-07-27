package com.twu28.biblioteca;

import java.util.ArrayList;

public class DisplayAllBooksCommand implements Command {
    private BookRepository bookRepository;

    public DisplayAllBooksCommand(BookRepository bookRepository) {
        this.bookRepository=bookRepository;
    }

    @Override
    public void execute(Console console) {
        console.println("Books Available:");
        ArrayList<String> listOfBooks=bookRepository.displayAllBooks();
        for (String listOfBook : listOfBooks)
            console.println(listOfBook);
    }
}

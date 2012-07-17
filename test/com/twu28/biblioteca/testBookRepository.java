package com.twu28.biblioteca;

import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class testBookRepository {
    @Test
    public void testDisplayAllBooks(){
        BookRepository bookRepository=new BookRepository();
        ArrayList<String> booksDiaplayed=new ArrayList<String>();
        booksDiaplayed.add("1 \"Let Us C\""+" -by- "+"\"Dennis Richie\"");
        booksDiaplayed.add("2 \"Head First Java\""+" -by- "+"\"Kethy Sieria\"");
        booksDiaplayed.add("3 \"Harry Potter\""+" -by- "+"\"J K Rowling\"");
        Assert.assertEquals(booksDiaplayed, bookRepository.DisplayAllBooks());
    }
    @Test
    public void testGetBook(){
        BookRepository bookRepository=new BookRepository();
        com.twu28.biblioteca.Book bookReturned=bookRepository.GetBook(1);
        com.twu28.biblioteca.Book ActualBook= BookRepository.BookList.get(0);
        Assert.assertEquals(ActualBook, bookReturned);
    }
    @Test
    public void testReserveBookSuccessfulMessage(){
        BookRepository bookRepository=new BookRepository();
        Assert.assertEquals("Thank You! Enjoy the book.",bookRepository.reserveBook(1));
    }
    @Test
    public void testReserveBookUnSuccessfulMessage(){
        BookRepository bookRepository=new BookRepository();
        bookRepository.reserveBook(1);
        Assert.assertEquals("Sorry we don't have that book yet.", bookRepository.reserveBook(1));
    }
    @Test (expected = RuntimeException.class)
    public void testReserveBookOutOfRangeSerialNumber(){
        BookRepository bookRepository=new BookRepository();
        bookRepository.reserveBook(5);
    }
}

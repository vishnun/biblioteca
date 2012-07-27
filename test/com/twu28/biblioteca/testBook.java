package com.twu28.biblioteca;

import junit.framework.Assert;
import org.junit.Test;

public class testBook {
    //ArrayList BookList= BookRepository.BookList;
    @Test
    public void testBookEqual(){
        BookRepository bookRepository=new BookRepository();
        Book java1=bookRepository.getBook(1);
        Assert.assertEquals(java1, java1);
    }
    @Test
    public void testBookNotEqual(){
        BookRepository bookRepository=new BookRepository();
        Book java1 = bookRepository.getBook(2);
        Book c1 =bookRepository.getBook(3);
        Assert.assertFalse(java1.equals(c1));
    }
    @Test
    public void testDisplay(){
        BookRepository bookRepository=new BookRepository();
        Book J1=bookRepository.getBook(2);
        String ExpectedOutput="\"Head First Java\""+" -by- "+"\"Kethy Sieria\"";
        String BookDisplayed= J1.display();
        Assert.assertEquals(ExpectedOutput,BookDisplayed);
    }
}

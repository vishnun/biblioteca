package com.twu28.biblioteca;

import junit.framework.Assert;
import org.junit.Test;

public class testCustomerMenu {
    @Test
    public void testMenuDisplay(){
        ConsoleStub consolestub=new ConsoleStub();
        CustomerMenu menu=new CustomerMenu();
        menu.Display(consolestub);
        Assert.assertTrue(consolestub.getLine(1).equals("1. View All Books"));
        Assert.assertTrue(consolestub.getLine(2).equals("2. Reserve a Book"));
        Assert.assertTrue(consolestub.getLine(3).equals("3. Check Library number"));
        Assert.assertTrue(consolestub.getLine(4).equals("4. Exit"));
    }
}

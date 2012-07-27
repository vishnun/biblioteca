package com.twu28.biblioteca;

import junit.framework.Assert;
import org.junit.Test;

public class testCustomerMenu {
    @Test
    public void testMenuDisplay(){
        ConsoleStub consolestub=new ConsoleStub();
        CustomerMenu menu=new CustomerMenu();
        menu.display(consolestub);
        Assert.assertTrue(consolestub.getLine(1).equals("1. Login"));
        Assert.assertTrue(consolestub.getLine(2).equals("2. View All Books"));
        Assert.assertTrue(consolestub.getLine(3).equals("3. Reserve a Book"));
        Assert.assertTrue(consolestub.getLine(4).equals("4. Check Library number"));
        Assert.assertTrue(consolestub.getLine(5).equals("5. View All Movies"));
        Assert.assertTrue(consolestub.getLine(6).equals("6. Exit"));
        Assert.assertTrue(consolestub.getLine(7).equals("7. Logout"));
    }
}

package com.twu28.biblioteca;

import junit.framework.Assert;
import org.junit.Test;

public class testUser {
    @Test
    public void testAuthenticateUser(){
        Assert.assertEquals("111-1111",User.authenticate("111-1111","111-1111"));
    }
    @Test(expected = RuntimeException.class)
    public void testAuthenticateUserUnsuccessful(){
        User.authenticate("999-9999","999-9999");
    }
    @Test(expected = RuntimeException.class)
    public void testAuthenticateUserUnsuccessfulForWrongPassword(){
        User.authenticate("111-1111","wrongPassword");
    }
}

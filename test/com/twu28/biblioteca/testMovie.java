package com.twu28.biblioteca;

import junit.framework.Assert;
import org.junit.Test;

public class testMovie {
    @Test
    public void testMovieEquals(){
        Movie matrix=new Movie("The Matrix","Andy Wachowski",7);
        //Movie sholay=new Movie("Sholay","Ramesh Shippy",8);
        Assert.assertTrue(matrix.equals(new Movie("The Matrix","Andy Wachowski",7)));
    }
    @Test
    public void testMovieNotEquals(){
        Movie matrix=new Movie("The Matrix","Andy Wachowski",7);
        Movie sholay=new Movie("Sholay","Ramesh Shippy",8);
        Assert.assertFalse(matrix.equals(sholay));
    }
    @Test
    public void testMovieDisplay(){
        Movie movie=new Movie("The Shawshank Redemption","Frank Darabont",9);
        String movieDetials="The Shawshank Redemption"+"\t"+"Frank Darabont"+"\t"+"9/10";
        Assert.assertTrue(movie.display().equals(movieDetials));
    }
    @Test
    public void testUnratedMovieDisplay(){
        int UNRATED=-1;
        Movie movie=new Movie("The Shawshank Redemption","Frank Darabont",UNRATED);
        String movieDetials="The Shawshank Redemption"+"\t"+"Frank Darabont"+"\t"+"N/A";
        Assert.assertTrue(movie.display().equals(movieDetials));
    }
}

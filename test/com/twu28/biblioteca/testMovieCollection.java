package com.twu28.biblioteca;

import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class testMovieCollection {
    @Test
    public void testDisplayAllMovies(){
        MovieCollection movieCollection=new MovieCollection();
        ArrayList<String> moviesDisplayed=new ArrayList<String>();
        moviesDisplayed.add("The Shawshank Redemption"+"\t"+"Frank Darabont"+"\t"+"9/10");
        moviesDisplayed.add("The Dark Knight"+"\t"+"Christopher Nolan"+"\t"+"8/10");
        moviesDisplayed.add("Sholay"+"\t"+"Ramesh Sippy"+"\t"+"N/A");
        moviesDisplayed.add("James Cameron"+"\t"+"Titanic"+"\t"+"8/10");
        moviesDisplayed.add("Gladiator"+"\t"+"Ridley Scott"+"\t"+"7/10");
        moviesDisplayed.add("Schindler's List"+"\t"+"Steven Spielberg"+"\t"+"9/10");
        moviesDisplayed.add("Seven"+"\t"+"David Fincher"+"\t"+"7/10");
        moviesDisplayed.add("Star Wars"+"\t"+"George Lucas"+"\t"+"6/10");
        moviesDisplayed.add("The Exorcist"+"\t"+"William Friedkin"+"\t"+"8/10");
        moviesDisplayed.add("Lord Of The Rings"+"\t"+"Peter Jackson"+"\t"+"9/10");
        moviesDisplayed.add("Apollo 13"+"\t"+"Ron Howard"+"\t"+"8/10");
        moviesDisplayed.add("300"+"\t"+"Zack Snyder"+"\t"+"N/A");
        moviesDisplayed.add("The Shining"+"\t"+"Stanley Kubrick"+"\t"+"6/10");
        moviesDisplayed.add("Jurassic Park"+"\t"+"Steven Speilberg"+"\t"+"9/10");
        moviesDisplayed.add("Catch Me If You Can"+"\t"+"Steven Speilberg"+"\t"+"8/10");

        Assert.assertEquals(moviesDisplayed, movieCollection.viewAll());
    }
}

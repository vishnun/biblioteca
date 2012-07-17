package com.twu28.biblioteca;
import java.util.ArrayList;
public class MovieCollection {
    public static ArrayList<Movie> movieList=new ArrayList<Movie>();
    private static int UNRATED=-1;
    static {
        movieList.add(new Movie("The Shawshank Redemption","Frank Darabont",9));
        movieList.add(new Movie("The Dark Knight","Christopher Nolan",8));
        movieList.add(new Movie("Sholay","Ramesh Sippy",UNRATED));
        movieList.add(new Movie("James Cameron","Titanic",8));
        movieList.add(new Movie("Gladiator","Ridley Scott",7));
        movieList.add(new Movie("Schindler's List","Steven Spielberg",9));
        movieList.add(new Movie("Seven","David Fincher",7));
        movieList.add(new Movie("Star Wars","George Lucas",6));
        movieList.add(new Movie("The Exorcist","William Friedkin",8));
        movieList.add(new Movie("Lord Of The Rings","Peter Jackson",9));
        movieList.add(new Movie("Apollo 13","Ron Howard",8));
        movieList.add(new Movie("300","Zack Snyder",UNRATED));
        movieList.add(new Movie("The Shining","Stanley Kubrick",6));
        movieList.add(new Movie("Jurassic Park","Steven Speilberg",9));
        movieList.add(new Movie("Catch Me If You Can","Steven Speilberg",8));
    }

    public ArrayList<String> viewAll() {
        ArrayList<String> movies=new ArrayList<String>();
        for(Movie movie: movieList){
            movies.add(movie.display());
        }
        return movies;
    }
}

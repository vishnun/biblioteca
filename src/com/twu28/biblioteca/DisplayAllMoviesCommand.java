package com.twu28.biblioteca;

import java.util.List;

public class DisplayAllMoviesCommand implements Command {
    private MovieCollection movieCollection;

    public DisplayAllMoviesCommand(MovieCollection movieCollection) {
        this.movieCollection=movieCollection;
    }

    @Override
    public void execute(Console console) {
        List<String> movies = movieCollection.viewAll();
        for (String movie : movies) {
            console.println(movie);
        }
    }
}

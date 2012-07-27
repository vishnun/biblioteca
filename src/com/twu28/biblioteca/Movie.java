package com.twu28.biblioteca;

public class Movie {
    private String name;
    private String director;
    private int rating;

    public Movie(String name, String director, int rating) {
        this.name=name;
        this.director=director;
        this.rating=rating;
    }

    @Override
    public boolean equals(Object otherMovie){
        if(! (otherMovie instanceof Movie))return false;
        if(otherMovie.getClass()!=this.getClass()) return false;
        return (((Movie) otherMovie).name.equals(this.name) && ((Movie) otherMovie).director.equals(this.director));
    }
    public String display() {
        String rate;
        rate = rated();
        return this.name+"\t"+this.director+"\t"+rate;
    }

    private String rated() {
        if(this.rating>=0)
            return ""+this.rating+"/10";
        return "N/A";
    }
}

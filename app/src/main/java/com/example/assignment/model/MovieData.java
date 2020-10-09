package com.example.assignment.model;


import com.example.assignment.interFaces.IMovieData;

import java.util.ArrayList;

public class MovieData implements IMovieData {
    private static ArrayList<Movie> movies = new ArrayList<>();
    public static ArrayList<String> genre = new ArrayList<>();

    public static ArrayList<String> getGenre() {
        return genre;
    }

    public MovieData() {
        movies.add(new Movie("Home Alone2", 2002, "Action"));
        movies.add(new Movie("Ride Along", 2016, "Comedy"));
        movies.add(new Movie("Sijjin", 2015, "Horror"));
        movies.add(new Movie("Skyscrapper", 2018, "Action"));
        movies.add(new Movie("Sniper", 2014, "Action"));
        movies.add(new Movie("pablo Escobar", 2012, "Crime"));
        genre.add("ALL");
        find();

    }

    public static ArrayList<Movie> searchNum(int num2, String spin) {
        ArrayList<Movie> movies2 = new ArrayList<>();
        if (spin.toLowerCase().equals("all")) {
            for (int i = 0; i < movies.size(); i++) {
                if (movies.get(i).getYear() == num2 ) {
                    movies2.add(movies.get(i));
                }
            }

        } else {
            for (int i = 0; i < movies.size(); i++) {
                if (movies.get(i).getYear() == num2 && movies.get(i).getGenre().equals(spin)) {
                    movies2.add(movies.get(i));
                }

            }

        }
        return movies2;

    }
        public static ArrayList<Movie> searchTitle (String tittle ,String spin){
            ArrayList<Movie> movies2 = new ArrayList<>();
            String s = "";
            if (spin.toLowerCase().equals("all")) {
            for (int i = 0; i < movies.size(); i++) {
                s = movies.get(i).getTittle().toLowerCase();
                if (s.contains(tittle.toLowerCase())) {
                    movies2.add(movies.get(i));
                }
            }
            }
            else{
                for (int i = 0; i < movies.size(); i++) {
                    s = movies.get(i).getTittle().toLowerCase();
                    if (s.contains(tittle.toLowerCase())&&movies.get(i).getGenre().toLowerCase().equals(spin.toLowerCase()))
                        movies2.add(movies.get(i));

                }

            }
            return movies2;
        }

        public void find () {
            String s = "";
            for (int i = 0; i < movies.size(); i++) {
                s = movies.get(i).getGenre();
                if (genre.contains(s) == false)
                    genre.add(s);
            }
        }
    public static ArrayList<Movie> searchSpin(String spin){
        ArrayList<Movie> movies2 = new ArrayList<>();
        if (spin.toLowerCase().equals("all"))
            movies2=movies;
        else{
            for(int i =0 ; i<movies.size();i++){
                if(movies.get(i).getGenre().toLowerCase().equals(spin.toLowerCase()))
                    movies2.add(movies.get(i));
        }

    }
return  movies2;
    }

        public ArrayList<String> getMovies () {
            new MovieData();
            return genre;
        }

}


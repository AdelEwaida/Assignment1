package com.example.assignment.controller;

import com.example.assignment.model.IMovieData;
import com.example.assignment.model.MovieData;
public class MovieFactory {

    public IMovieData getModel(){
        return new MovieData();

    }
}

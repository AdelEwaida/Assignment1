//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.example.assignment.model;

 public class Movie {
    private String tittle;
    private int year;
    private String genre;

    public Movie(String tittle, int year, String genre) {
        this.tittle = tittle;
        this.year = year;
        this.genre = genre;
    }

    public String getTittle() {
        return this.tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGenre() {
        return this.genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String toString() {
        return "Movie : tittle: '" + this.tittle + ' ' + ", year=" + this.year + ", genre:'" + this.genre ;
    }
}

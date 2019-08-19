package com.twu.biblioteca.models;

import java.util.ArrayList;

public class MovieCopies {
    private static final ArrayList<MovieCopy> movie_copies = new ArrayList<>();

    public static void add(MovieCopy bookCopy) {
        movie_copies.add(bookCopy);
    }

    public static void clear() {
        movie_copies.clear();
    }

    public static ArrayList<MovieCopy> selectAllBooksWhereCheckedOutIsFalse() {
        ArrayList<MovieCopy> allBooksWhereCheckedOutIsFalse = new ArrayList<>();
        for(MovieCopy movie : movie_copies){
            if (!movie.isCheckedOut()){
                allBooksWhereCheckedOutIsFalse.add(movie);
            }
        }
        return allBooksWhereCheckedOutIsFalse;
    }

    public static ArrayList<MovieCopy> selectAllBooksWhereCheckedOutIsTrue() {
        ArrayList<MovieCopy> allBooksWhereCheckedOutIsFalse = new ArrayList<>();
        for(MovieCopy movie : movie_copies){
            if (movie.isCheckedOut()){
                allBooksWhereCheckedOutIsFalse.add(movie);
            }
        }
        return allBooksWhereCheckedOutIsFalse;
    }
}

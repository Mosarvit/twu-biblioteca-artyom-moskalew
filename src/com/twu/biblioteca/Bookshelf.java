package com.twu.biblioteca;

import java.util.ArrayList;

public class Bookshelf {
    private static final ArrayList<BibliotecaBook> bibliotecaBooks = new ArrayList<BibliotecaBook>();

    public static void add(BibliotecaBook bibliotecaBook) {
        bibliotecaBooks.add(bibliotecaBook);
    }

    public static boolean isEmpty() {
        return bibliotecaBooks.isEmpty();
    }

    public static ArrayList<BibliotecaBook> getAllBooks() {
        return bibliotecaBooks;
    }

    public static void clear() {
        bibliotecaBooks.clear();
    }
}

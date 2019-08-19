package com.twu.biblioteca.models;

import java.util.ArrayList;

public class BookCopies {
    private static final ArrayList<BookCopy> book_entries = new ArrayList<BookCopy>();

    public static void add(BookCopy bookCopy) {
        book_entries.add(bookCopy);
    }

    public static void clear() {
        book_entries.clear();
    }

    public static ArrayList<BookCopy> selectAllBooksWhereCheckedOutIsFalse() {
        ArrayList<BookCopy> allBooksWhereCheckedOutIsFalse = new ArrayList<>();
        for(BookCopy book : book_entries){
            if (!book.isCheckedOut()){
                allBooksWhereCheckedOutIsFalse.add(book);
            }
        }
        return allBooksWhereCheckedOutIsFalse;
    }

    public static ArrayList<BookCopy> selectAllBooksWhereCheckedOutIsTrue() {
        ArrayList<BookCopy> allBooksWhereCheckedOutIsFalse = new ArrayList<>();
        for(BookCopy book : book_entries){
            if (book.isCheckedOut()){
                allBooksWhereCheckedOutIsFalse.add(book);
            }
        }
        return allBooksWhereCheckedOutIsFalse;
    }
}

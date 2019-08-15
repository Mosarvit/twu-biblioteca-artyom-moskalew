package com.twu.biblioteca.models;

import java.util.ArrayList;

public class BookEntries {
    private static final ArrayList<BookEntry> BOOK_ENTRIES = new ArrayList<BookEntry>();

    public static void add(BookEntry bookEntry) {
        BOOK_ENTRIES.add(bookEntry);
    }

    public static boolean isEmpty() {
        return BOOK_ENTRIES.isEmpty();
    }

    public static ArrayList<BookEntry> getAllBooks() {
        return BOOK_ENTRIES;
    }

    public static void clear() {
        BOOK_ENTRIES.clear();
    }

    public static ArrayList<BookEntry> selectAllBooksWhereCheckedOutIsFalse() {
        ArrayList<BookEntry> allBooksWhereCheckedOutIsFalse = new ArrayList<>();
        for(BookEntry book : BOOK_ENTRIES){
            if (!book.isCheckedOut()){
                allBooksWhereCheckedOutIsFalse.add(book);
            }
        }
        return allBooksWhereCheckedOutIsFalse;
    }

    public static ArrayList<BookEntry> selectAllBooksWhereCheckedOutIsTrue() {
        ArrayList<BookEntry> allBooksWhereCheckedOutIsFalse = new ArrayList<>();
        for(BookEntry book : BOOK_ENTRIES){
            if (book.isCheckedOut()){
                allBooksWhereCheckedOutIsFalse.add(book);
            }
        }
        return allBooksWhereCheckedOutIsFalse;
    }
}

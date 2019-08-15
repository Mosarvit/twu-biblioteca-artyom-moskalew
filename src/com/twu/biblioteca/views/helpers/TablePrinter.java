package com.twu.biblioteca.views.helpers;

import com.twu.biblioteca.IOHandler;
import com.twu.biblioteca.models.BookEntry;

import java.util.ArrayList;

public class TablePrinter {

    public static void printListOfBooks(IOHandler ioHandler, ArrayList<BookEntry> books) {
        ioHandler.println("[INDEX] | Title | Author | Year Published");
        int indexCounter = 1;
        for (BookEntry book : books) {
            ioHandler.println("[" + indexCounter + "]" + " | " + book.getTitle() + " | " + book.getAuthor() +
                    " | " + book.getYearPublished());
            indexCounter++;
        }
        ioHandler.println("");
    }
}

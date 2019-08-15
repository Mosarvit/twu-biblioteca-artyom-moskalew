package com.twu.biblioteca;

import java.util.ArrayList;

public class TablePrinter {

    public static void printListOfBooks(IOHandler ioHandler, ArrayList<BibliotecaBook> books) {
        ioHandler.printOutput("[INDEX] | Title | Author | Year Published");
        int indexCounter = 1;
        for (BibliotecaBook book : books) {
            ioHandler.printOutput("[" + indexCounter + "]" + " | " + book.getTitle() + " | " + book.getAuthor() +
                    " | " + book.getYearPublished());
            indexCounter++;
        }
        ioHandler.printOutput("");
    }
}

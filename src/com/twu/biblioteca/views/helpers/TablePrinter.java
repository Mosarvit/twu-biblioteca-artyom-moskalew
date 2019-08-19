package com.twu.biblioteca.views.helpers;

import com.twu.biblioteca.models.BookCopy;

import java.util.ArrayList;

public class TablePrinter {
    public static String getTableAsString(ArrayList<BookCopy> books) {
        String tableString = "";
        tableString += "[INDEX] | Title | Author | Year Published\n";
        int indexCounter = 1;
        for (BookCopy book : books) {
            tableString += "[" + indexCounter + "]" + " | " + book.getTitle() + " | " + book.getAuthor() +
                    " | " + book.getYearReleased() + "\n";
            indexCounter++;
        }
        return tableString;
    }
}

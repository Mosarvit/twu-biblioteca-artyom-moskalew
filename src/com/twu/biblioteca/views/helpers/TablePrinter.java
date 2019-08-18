package com.twu.biblioteca.views.helpers;

import com.twu.biblioteca.IOHandler;
import com.twu.biblioteca.models.BookEntry;

import java.util.ArrayList;

public class TablePrinter {
    public static String getTableAsString(ArrayList<BookEntry> books) {
        String tableString = "";
        tableString += "[INDEX] | Title | Author | Year Published\n";
        int indexCounter = 1;
        for (BookEntry book : books) {
            tableString += "[" + indexCounter + "]" + " | " + book.getTitle() + " | " + book.getAuthor() +
                    " | " + book.getYearPublished() + "\n";
            indexCounter++;
        }
        return tableString;
    }
}

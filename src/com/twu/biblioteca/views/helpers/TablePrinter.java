package com.twu.biblioteca.views.helpers;

import com.twu.biblioteca.UI_GLOBALS;
import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.Model;
import com.twu.biblioteca.models.Movie;

import java.util.ArrayList;

public class TablePrinter {
    public static String getTableAsString(ArrayList<Model> books) {
        String tableString = "";

        if(books.get(0).getClass() == Book.class){
            tableString += "[INDEX] | Title | Author | " + UI_GLOBALS.MEDIA_TABLE_HEAD_BOOK_RELEASE_YEAR + "\n";
        }else if(books.get(0).getClass() == Movie.class){
            tableString += "[INDEX] | Title | Director | " + UI_GLOBALS.MEDIA_TABLE_HEAD_BOOK_RELEASE_YEAR + "\n";
        }

        int indexCounter = 1;
        for (Model model : books) {
            tableString += "[" + indexCounter + "]";
            tableString += " | ";
            tableString += model.getTitle();
            tableString += " | ";

            if(books.get(0).getClass() == Book.class){
                tableString += ((Book)model).getAuthor();
            }else if(books.get(0).getClass() == Movie.class){
                tableString += ((Movie)model).getDirector();
            }

            tableString += " | ";
            tableString += model.getYearReleased();
            tableString += "\n";
            indexCounter++;
        }
        return tableString;
    }
}

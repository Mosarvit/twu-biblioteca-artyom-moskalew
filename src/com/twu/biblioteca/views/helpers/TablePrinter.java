package com.twu.biblioteca.views.helpers;

import com.twu.biblioteca.views.UI_GLOBALS;
import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.Media;
import com.twu.biblioteca.models.Movie;

import java.util.ArrayList;

public class TablePrinter {
    public static String getTableForUser(ArrayList<Media> medias) {
        String tableString = "";

        if(medias.get(0).getClass() == Book.class){
            tableString += "[INDEX] | Title | Author | " + UI_GLOBALS.MEDIA_TABLE_HEAD_BOOK_RELEASE_YEAR + "\n";
        }else if(medias.get(0).getClass() == Movie.class){
            tableString += "[INDEX] | Title | Director | " + UI_GLOBALS.MEDIA_TABLE_HEAD_BOOK_RELEASE_YEAR + "\n";
        }

        int indexCounter = 1;
        for (Media media : medias) {
            tableString += "[" + indexCounter + "]";
            tableString += " | ";
            tableString += media.getTitle();
            tableString += " | ";

            if(medias.get(0).getClass() == Book.class){
                tableString += ((Book) media).getAuthor();
            }else if(medias.get(0).getClass() == Movie.class){
                tableString += ((Movie) media).getDirector();
            }

            tableString += " | ";
            tableString += media.getYearReleased();
            tableString += UI_GLOBALS.LINE_BREAK;
            indexCounter++;
        }
        return tableString;
    }

    public static String getTableForAdminReturn(ArrayList<Media> books) {
        String tableString = "";

        if(books.get(0).getClass() == Book.class){
            tableString += "[INDEX] | Title | Author | " + UI_GLOBALS.MEDIA_TABLE_HEAD_BOOK_RELEASE_YEAR + " | Holder Library Number\n";
        }else if(books.get(0).getClass() == Movie.class){
            tableString += "[INDEX] | Title | Director | " + UI_GLOBALS.MEDIA_TABLE_HEAD_BOOK_RELEASE_YEAR + " | Holder Library Number\n";
        }

        int indexCounter = 1;
        for (Media media : books) {
            tableString += "[" + indexCounter + "]";
            tableString += " | ";
            tableString += media.getTitle();
            tableString += " | ";

            if(books.get(0).getClass() == Book.class){
                tableString += ((Book) media).getAuthor();
            }else if(books.get(0).getClass() == Movie.class){
                tableString += ((Movie) media).getDirector();
            }

            tableString += " | ";
            tableString += media.getYearReleased();
            tableString += " | ";
            tableString += media.getHodlder().getLibraryName();
            tableString += UI_GLOBALS.LINE_BREAK;
            indexCounter++;
        }
        return tableString;
    }

    public static String getTableForAdminBrowse(ArrayList<Media> books) {
        String tableString = "";

        if(books.get(0).getClass() == Book.class){
            tableString += "[INDEX] | Title | Author | " + UI_GLOBALS.MEDIA_TABLE_HEAD_BOOK_RELEASE_YEAR + "\n";
        }else if(books.get(0).getClass() == Movie.class){
            tableString += "[INDEX] | Title | Director | " + UI_GLOBALS.MEDIA_TABLE_HEAD_BOOK_RELEASE_YEAR + "\n";
        }

        int indexCounter = 1;
        for (Media media : books) {
            tableString += "[" + indexCounter + "]";
            tableString += " | ";
            tableString += media.getTitle();
            tableString += " | ";

            if(books.get(0).getClass() == Book.class){
                tableString += ((Book) media).getAuthor();
            }else if(books.get(0).getClass() == Movie.class){
                tableString += ((Movie) media).getDirector();
            }

            tableString += " | ";
            tableString += media.getYearReleased();
            tableString += UI_GLOBALS.LINE_BREAK;
            indexCounter++;
        }
        return tableString;
    }
}

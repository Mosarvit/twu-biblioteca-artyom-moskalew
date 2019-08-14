package com.twu.biblioteca;

import java.awt.print.Book;
import java.util.ArrayList;

public class CommandLineApp {
    private final IOHandler iOHandler;

    public CommandLineApp(IOHandler iOHandler) {
        this.iOHandler = iOHandler;
    }

    public void start() {
        this.iOHandler.printOutput("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
        if (Bookshelf.isEmpty()){
            this.iOHandler.printOutput("There are currently no books in the library. Please try later!");
        }else{
            this.iOHandler.printOutput("Here are the books in our library:");
            viewListOfBooks();
        }
    }

    private void viewListOfBooks() {
        this.iOHandler.printOutput("[INDEX] | Title | Author | Year Published");
        ArrayList<BibliotecaBook> allBooks = Bookshelf.getAllBooks();
        int indexCounter = 1;
        for (BibliotecaBook bibliotecaBook : allBooks){
            this.iOHandler.printOutput("[" + indexCounter + "]" + " | " + bibliotecaBook.getTitle() + " | " + bibliotecaBook.getAuthor() +
             " | " + bibliotecaBook.getYearPublished());
            indexCounter++;
        }
    }
}

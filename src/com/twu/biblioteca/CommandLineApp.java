package com.twu.biblioteca;

import java.awt.print.Book;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class CommandLineApp {
    private final IOHandler iOHandler;

    public CommandLineApp(IOHandler iOHandler) {
        this.iOHandler = iOHandler;
    }

    public void start() {
        this.iOHandler.printOutput("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
        this.iOHandler.printOutput("This is the Main Menu. Here are your options:");
        this.iOHandler.printOutput("[1] View the list of all books.");
        this.iOHandler.printOutput("Please type the number of your option then hit Enter:");

        Scanner myObj = new Scanner(System.in);
        String userSelectedOptionString = myObj.nextLine();
        
        int userSelectedOption = Integer.parseInt(userSelectedOptionString);

        if (userSelectedOption == 1) {
            this.iOHandler.printOutput("You selected option [1] to view the list of all Books.");
            if (Bookshelf.isEmpty()) {
                this.iOHandler.printOutput("There are currently no books in the library. Please try later!");
            } else {
                this.iOHandler.printOutput("Here are the books in our library:");
                viewListOfBooks();
            }
        }

    }

    private void viewListOfBooks() {
        this.iOHandler.printOutput("[INDEX] | Title | Author | Year Published");
        ArrayList<BibliotecaBook> allBooks = Bookshelf.getAllBooks();
        int indexCounter = 1;
        for (BibliotecaBook bibliotecaBook : allBooks) {
            this.iOHandler.printOutput("[" + indexCounter + "]" + " | " + bibliotecaBook.getTitle() + " | " + bibliotecaBook.getAuthor() +
                    " | " + bibliotecaBook.getYearPublished());
            indexCounter++;
        }
    }
}

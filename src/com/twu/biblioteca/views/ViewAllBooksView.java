package com.twu.biblioteca.views;

import com.twu.biblioteca.BibliotecaBook;
import com.twu.biblioteca.Bookshelf;
import com.twu.biblioteca.IOHandler;

import java.util.ArrayList;

public class ViewAllBooksView extends View {
    private static ViewAllBooksView viewAllBooksView_singleton = new ViewAllBooksView();

    private ViewAllBooksView() {
    }

    public static ViewAllBooksView getInstance() {
        return viewAllBooksView_singleton;
    }

    public View enter(IOHandler ioHandler){

        if (Bookshelf.isEmpty()) {
            ioHandler.printOutput("There are currently no books in the library. Please try later.");
        } else {
            ioHandler.printOutput("Here are the books in our library:");
            viewListOfBooks(ioHandler);
        }

        NavigationBar navigationBar = NavigationBar.getInstance();
        navigationBar.printNavigationBar(ioHandler);

        ioHandler.printOutput("Please type the number of your option then hit Enter:");


        while (true) {
            String userSelectedOptionString = ioHandler.getNextInputLine();

            if (navigationBar.hasOption(userSelectedOptionString)) {
                ioHandler.printOutput("You selected option [" + userSelectedOptionString + "].");
                View view = navigationBar.getView(userSelectedOptionString);
                return view;
            } else {
                ioHandler.printOutput("You typed \"" + userSelectedOptionString + "\". This is not a valid menu option. Please try again.");
            }
        }
    }

    private void viewListOfBooks(IOHandler ioHandler) {
        ioHandler.printOutput("[INDEX] | Title | Author | Year Published");
        ArrayList<BibliotecaBook> allBooks = Bookshelf.getAllBooks();
        int indexCounter = 1;
        for (BibliotecaBook bibliotecaBook : allBooks) {
            ioHandler.printOutput("[" + indexCounter + "]" + " | " + bibliotecaBook.getTitle() + " | " + bibliotecaBook.getAuthor() +
                    " | " + bibliotecaBook.getYearPublished());
            indexCounter++;
        }
    }
}

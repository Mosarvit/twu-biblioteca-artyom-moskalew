package com.twu.biblioteca;

import java.util.ArrayList;

public class ViewAllBooksView implements MenuOption {
    private IOHandler ioHandler;
    public ViewAllBooksView(IOHandler ioHandler){
        this.ioHandler = ioHandler;
    }
    public void enter(){
        this.ioHandler.printOutput("You selected option [1] to view the list of all Books.");
        if (Bookshelf.isEmpty()) {
            this.ioHandler.printOutput("There are currently no books in the library. Please try later.");
        } else {
            this.ioHandler.printOutput("Here are the books in our library:");
            viewListOfBooks();
        }
    }

    private void viewListOfBooks() {
        this.ioHandler.printOutput("[INDEX] | Title | Author | Year Published");
        ArrayList<BibliotecaBook> allBooks = Bookshelf.getAllBooks();
        int indexCounter = 1;
        for (BibliotecaBook bibliotecaBook : allBooks) {
            this.ioHandler.printOutput("[" + indexCounter + "]" + " | " + bibliotecaBook.getTitle() + " | " + bibliotecaBook.getAuthor() +
                    " | " + bibliotecaBook.getYearPublished());
            indexCounter++;
        }
    }
}

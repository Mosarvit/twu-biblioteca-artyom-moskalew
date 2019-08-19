package com.twu.biblioteca;

import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.Database;

public class BibliotecaApp {

    public static void main(String[] args) {
        IOHandler ioHandler = new IOHandler();
        CommandLineApp commandLineApp = new CommandLineApp(ioHandler);

        Book bookAnnaKarenina = new Book("Anna Karenina", "Leo Tolstoy", 1877);
        Book bookWalden = new Book("Walden", "Henry David Thoreau", 1854);
        Book bookAgileSoftwareDevelopment = new Book("Agile Software Development", "Robert Cecil Martin", 2003);

        Database.add(bookAnnaKarenina);
        Database.add(bookWalden);
        Database.add(bookAgileSoftwareDevelopment);

        commandLineApp.start();
    }
}

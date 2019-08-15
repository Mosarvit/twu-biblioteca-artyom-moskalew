package com.twu.biblioteca;

import com.twu.biblioteca.models.BookEntry;
import com.twu.biblioteca.models.BookEntries;

public class BibliotecaApp {

    public static void main(String[] args) {
        IOHandler ioHandler = new IOHandler();
        CommandLineApp commandLineApp = new CommandLineApp(ioHandler);

        BookEntry bookAnnaKarenina = new BookEntry("Anna Karenina", "Leo Tolstoy", 1877);
        BookEntry bookWalden = new BookEntry("Walden", "Henry David Thoreau", 1854);
        BookEntry bookAgileSoftwareDevelopment = new BookEntry("Agile Software Development", "Robert Cecil Martin", 2003);

        BookEntries.add(bookAnnaKarenina);
        BookEntries.add(bookWalden);
        BookEntries.add(bookAgileSoftwareDevelopment);

        commandLineApp.start();
    }
}

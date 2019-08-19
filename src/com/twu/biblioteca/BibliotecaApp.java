package com.twu.biblioteca;

import com.twu.biblioteca.models.BookCopy;
import com.twu.biblioteca.models.BookCopies;

public class BibliotecaApp {

    public static void main(String[] args) {
        IOHandler ioHandler = new IOHandler();
        CommandLineApp commandLineApp = new CommandLineApp(ioHandler);

        BookCopy bookAnnaKarenina = new BookCopy("Anna Karenina", "Leo Tolstoy", 1877);
        BookCopy bookWalden = new BookCopy("Walden", "Henry David Thoreau", 1854);
        BookCopy bookAgileSoftwareDevelopment = new BookCopy("Agile Software Development", "Robert Cecil Martin", 2003);

        BookCopies.add(bookAnnaKarenina);
        BookCopies.add(bookWalden);
        BookCopies.add(bookAgileSoftwareDevelopment);

        commandLineApp.start();
    }
}

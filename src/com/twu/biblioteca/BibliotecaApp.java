package com.twu.biblioteca;

import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.Database;
import com.twu.biblioteca.models.User;

public class BibliotecaApp {

    public static void main(String[] args) {
        IOHandler ioHandler = new IOHandler();
        CommandLineApp commandLineApp = new CommandLineApp(ioHandler);

        User user1 = new User("123-4567", "password1");
        User user2 = new User("123-4568", "password1");

        Database.add(user1);
        Database.add(user2);

        Book bookAnnaKarenina = new Book("Anna Karenina", "Leo Tolstoy", 1877);
        Book bookWalden = new Book("Walden", "Henry David Thoreau", 1854);
        Book bookAgileSoftwareDevelopment = new Book("Agile Software Development", "Robert Cecil Martin", 2003);

        Database.add(bookAnnaKarenina);
        Database.add(bookWalden);
        Database.add(bookAgileSoftwareDevelopment);



        commandLineApp.start();
    }
}

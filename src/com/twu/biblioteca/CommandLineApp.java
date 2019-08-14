package com.twu.biblioteca;

import javax.swing.*;
import java.util.HashMap;
import java.util.Scanner;

public class CommandLineApp {
    private final IOHandler ioHandler;

    public CommandLineApp(IOHandler ioHandler) {
        this.ioHandler = ioHandler;
    }

    public void start() {
        this.ioHandler.printOutput("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
        this.ioHandler.printOutput("This is the Main Menu.");

        Scanner scanner = new Scanner(System.in);

        boolean exitMenuLoop = false;

        ViewAllBooksView viewAllBooksView = new ViewAllBooksView(this.ioHandler);

        HashMap<String, MenuOption> menuOptionsHM = new HashMap<String, MenuOption>();
        menuOptionsHM.put("1", viewAllBooksView);


        while (!exitMenuLoop) {

            this.ioHandler.printOutput("Here are your options:");
            this.ioHandler.printOutput("[1] View the list of all books.");
            this.ioHandler.printOutput("Please type the number of your option then hit Enter:");

            String userSelectedOptionString = scanner.nextLine();

            if (menuOptionsHM.containsKey(userSelectedOptionString)){
                MenuOption menuOption = menuOptionsHM.get(userSelectedOptionString);
                menuOption.enter();
                exitMenuLoop = true;
            } else {
                this.ioHandler.printOutput("You typed \""+userSelectedOptionString+"\". This is not a valid menu option. Please try again.");
            }
        }
    }


}

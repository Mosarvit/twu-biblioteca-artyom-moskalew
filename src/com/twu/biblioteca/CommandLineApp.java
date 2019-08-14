package com.twu.biblioteca;

public class CommandLineApp {
    private final IOHandler iOHandler;

    public CommandLineApp(IOHandler iOHandler) {
        this.iOHandler = iOHandler;
    }

    public void start() {
        this.iOHandler.printOutput("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }
}

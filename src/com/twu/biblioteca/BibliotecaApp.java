package com.twu.biblioteca;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class BibliotecaApp {

    public static void main(String[] args) {
        IOHandler ioHandler = new IOHandler();
        CommandLineApp commandLineApp = new CommandLineApp(ioHandler);
        commandLineApp.start();
    }
}

package com.twu.biblioteca;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class IOHandler {
    private Scanner scanner;
    public IOHandler(){

        this.scanner = new Scanner(System.in);
    }
    public void printOutput(String output) {
        System.out.println(output);
    }

    public String getNextInputLine() {
        return this.scanner.nextLine();
    }
}

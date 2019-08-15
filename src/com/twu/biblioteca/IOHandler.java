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
    public void println(String output) {
        System.out.println(output);
    }
    public void print(String output) {
        System.out.print(output);
    }

    public String getNextInputLine() {
        return this.scanner.nextLine();
    }
}

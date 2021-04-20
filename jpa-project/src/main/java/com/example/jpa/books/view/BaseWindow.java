package com.example.jpa.books.view;

import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Scanner;

public class BaseWindow implements AutoCloseable {

    private final Terminal terminal;
    private final PrintWriter writer;
    private final Scanner scanner;

    public BaseWindow() throws IOException {
        terminal = TerminalBuilder.builder()
                .system(true)
                .streams(System.in, System.out)
                .build();

        writer = terminal.writer();
        scanner = new Scanner(terminal.input());
    }

    public void displayFormatted(String text, Object... args) {
        writer.printf(text, args);
    }

    public void displayLine(String text) {
        writer.write(text + "\n");
        writer.flush();
    }

    private void displayCursor() {
        writer.write( "> ");
        writer.flush();
    }

    @Override
    public void close() throws IOException {
        terminal.close();
    }

    protected boolean readBool() {
        while (true) {
            displayCursor();
            String line = scanner.nextLine().trim().toLowerCase();
            if(line.equals("yes")) {
                return true;
            } else if(line.equals("no")) {
                return false;
            } else {
                displayLine("ERR, expected yes or no");
            }
        }
    }

    protected int readInt() {
        while (true) {
            displayCursor();
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                displayLine("ERR, expected an int");
            }
        }
    }

    protected double readDouble() {
        while (true) {
            displayCursor();
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                displayLine("ERR, expected a double (5.05)");
            }
        }
    }

    protected BigDecimal readBigDecimal() {
        while (true) {
            displayCursor();
            try {
                return new BigDecimal(scanner.nextLine());
            } catch (NumberFormatException e) {
                displayLine("ERR, expected a decimal value (5.05)");
            }
        }
    }
}

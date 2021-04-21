package com.example.office.view.util;

import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BaseWindow implements AutoCloseable {

    private static final Pattern datePattern = Pattern.compile("(\\d{4})-(\\d{1,2})-(\\d{1,2})");
    private static final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");

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

    protected String readString() {
        while (true) {
            displayCursor();
            String line = scanner.nextLine().trim().toLowerCase();
            if(!line.isEmpty()) {
                return line;
            } else {
                displayLine("ERR, input was empty");
            }
        }
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

    protected LocalDate readLocalDate() {
        displayLine("Please enter a date in the format yyyy-mm-dd");
        while (true) {
            displayCursor();
            String line = scanner.nextLine().trim();
            Matcher dateMatcher = datePattern.matcher(line);
            if(dateMatcher.matches()) {
                String parsedLine = String.format("%4d-%02d-%02d",
                        Integer.parseInt(dateMatcher.group(1)),
                        Integer.parseInt(dateMatcher.group(2)),
                        Integer.parseInt(dateMatcher.group(3)));

                return LocalDate.parse(parsedLine, dateFormat);
            } else {
                displayLine("ERR, expected a date (yyyy-mm-dd)");
            }
        }
    }
}

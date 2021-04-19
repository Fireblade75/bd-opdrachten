package com.example.jpa.books.view;

import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class Window implements AutoCloseable {

    private final Terminal terminal;
    private final PrintWriter writer;
    private final Scanner scanner;

    public Window() throws IOException {
        terminal = TerminalBuilder.builder()
                .system(true)
                .streams(System.in, System.out)
                .build();
        writer = terminal.writer();
        writer.write("Book App\n");
        writer.flush();
        scanner = new Scanner(terminal.input());
    }

    public  <T> T selectElementFromList(List<T> elements, String elementName) {
        writer.write("The following " + elementName + "s are available\n");
        for (int i = 0; i < elements.size(); i++) {
            writer.write(String.format("%02d. %s%n", i+1, elements.get(i).toString()));
        }
        while (true) {
            int authorId = readInt();
            if(authorId > 0 && authorId <= elements.size()) {
                return elements.get(authorId - 1);
            }
        }
    }

    private int readInt() {
        writer.print("> ");
        writer.flush();
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());

            } catch (NumberFormatException e) {
                writer.print("ERR, expected an int\n> ");
                writer.flush();
            }
        }
    }

    @Override
    public void close() throws Exception {
        terminal.close();
    }
}

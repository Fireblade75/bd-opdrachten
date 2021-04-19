package com.example.jpa.books.view;

import com.example.jpa.books.actions.ActionList;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;
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

    public <T> T selectElementFromList(List<T> elements, String elementName) {
        return elements.get(selectIdFromList(elements, elementName));
    }

    public <T> int selectIdFromList(List<T> elements, String elementName) {
        writer.write("The following " + elementName + "s are available\n");
        for (int i = 0; i < elements.size(); i++) {
            writer.write(String.format("%02d. %s%n", i+1, elements.get(i).toString()));
        }
        while (true) {
            int authorId = readInt();
            if(authorId > 0 && authorId <= elements.size()) {
                return authorId - 1;
            }
        }
    }



    public boolean askYesNoQuestion(String question) {
        writer.write(question + "\n");
        return readBool();
    }

    private boolean readBool() {
        writer.print("> ");
        writer.flush();
        while (true) {
            String line = scanner.nextLine().trim().toLowerCase();
            if(line.equals("yes")) {
                return true;
            } else if(line.equals("no")) {
                return false;
            } else {
                writer.print("ERR, expected yes or no\n> ");
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
    public void close() throws IOException {
        terminal.close();
    }


}

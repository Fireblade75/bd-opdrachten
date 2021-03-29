package com.example.taskmanager.cli;

import com.example.taskmanager.commands.CommandHandlerServiceImpl;
import com.example.taskmanager.exceptions.CLIException;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

import javax.inject.Inject;
import java.io.IOException;
import java.io.PrintWriter;

public class TaskManagerTerminalImpl implements TaskManagerTerminal {
    private final Terminal terminal;
    private final PrintWriter writer;

    @Inject
    private CommandHandlerServiceImpl commandHandlerService;

    public TaskManagerTerminalImpl() throws CLIException {
        try {
            terminal = TerminalBuilder.builder()
                    .system(true)
                    .streams(System.in, System.out)
                    .build();
            writer = terminal.writer();
            writer.write("TaskManager 1.0; CLI Edition\n");
            writer.flush();
        } catch (IOException e) {
            throw new CLIException(e.getMessage());
        }
    }

    public void runTerminal() {
        commandHandlerService.initTaskBoard();
        LineReader lineReader = LineReaderBuilder.builder()
                .terminal(terminal)
                .completer(commandHandlerService.getCompleter())
                .build();

        while (true) {
            String line = lineReader.readLine("> ");
            String output = commandHandlerService.handleCommand(line);
            if(output.equals("exit")) {
                exit();
                break;
            } else {
                writer.println(output);
            }
        }
    }

    private void exit() {
        try {
            terminal.close();
        } catch (IOException e) {
            System.out.println("Failed to close terminal: " + e.getMessage());
        }
    }
}

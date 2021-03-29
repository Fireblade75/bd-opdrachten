package com.example.taskmanager.commands;

import com.example.taskmanager.commands.actions.UserService;
import org.jline.reader.Completer;

public interface CommandHandlerService {
    String handleCommand(String line);

    Completer getCompleter();
}

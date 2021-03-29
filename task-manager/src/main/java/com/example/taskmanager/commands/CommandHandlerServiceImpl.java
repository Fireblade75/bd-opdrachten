package com.example.taskmanager.commands;

import com.example.taskmanager.commands.actions.DataService;
import com.example.taskmanager.commands.actions.HelpService;
import com.example.taskmanager.commands.actions.TaskService;
import com.example.taskmanager.commands.actions.UserService;
import com.example.taskmanager.model.TaskBoard;
import com.example.taskmanager.persistence.TaskFileHandlerService;
import com.google.inject.Inject;
import org.jline.reader.Completer;
import org.jline.reader.impl.completer.StringsCompleter;

public class CommandHandlerServiceImpl implements CommandHandlerService {

    @Inject
    private TaskFileHandlerService taskFileHandlerService;

    @Inject
    private UserService userService;

    @Inject
    private DataService dataService;

    @Inject
    private TaskService taskService;

    @Inject
    private HelpService helpService;

    private TaskBoard taskBoard = null;

    public void initTaskBoard() {
        if(taskBoard == null) {
            taskBoard = taskFileHandlerService.readOrCreateTaskBoard();
        }
    }

    public String handleCommand(String line) {
        String[] words = line.split(" ");
        if(words.length == 0) {
            return "";
        }
        switch (words[0].toLowerCase()) {
            case "exit":
                return "exit";
            case "help":
                return helpService.help();
            case "newuser":
                return userService.newUser(taskBoard, line);
            case "activeuser":
                return userService.setActiveUser(taskBoard, line);
            case "save":
                return dataService.saveTaskBoard(taskBoard);
            case "newtask":
                return taskService.addNewTask(taskBoard, line);
            case "settaskstate":
                return taskService.setTaskState(taskBoard, line);
            case "listtasks":
                return taskService.listTasks(taskBoard);
            default:
                return "Unknown command: " + words[0].toLowerCase();
        }
    }

    public Completer getCompleter() {
        return new StringsCompleter("exit", "help", "newUser", "activeUser", "save",
                "newTask", "setTaskState", "listTasks");
    }
}

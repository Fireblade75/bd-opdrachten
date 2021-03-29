package com.example.taskmanager.commands.actions;

public class HelpService {

    public String help() {
        return "newUser - Add a new user to the task board\n" +
        "activeUser - Select a user as the active user\n" +
        "newTask - Add a new task and assign it to the active user\n" +
        "setTaskState - Set the task state for a task\n" +
        "listTasks - List all the tasks assigned to the active user\n" +
        "save - Save the task board to a file\n" +
        "help - Get this help text\n" +
        "exit - Exit the program (without saving)";
    }
}


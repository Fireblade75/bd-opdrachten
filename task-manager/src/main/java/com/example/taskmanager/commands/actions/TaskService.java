package com.example.taskmanager.commands.actions;

import com.example.taskmanager.exceptions.NoActiveUserException;
import com.example.taskmanager.exceptions.TaskNotFoundException;
import com.example.taskmanager.model.TaskBoard;
import com.example.taskmanager.model.TaskState;

import java.util.regex.Pattern;

public class TaskService {
    Pattern newTaskPattern = Pattern.compile("newTask \"([^\"]{0,20})\"(?: \"([^\"]{0,128})\")?", Pattern.CASE_INSENSITIVE);
    Pattern setTaskState = Pattern.compile("setTaskState \"([^\"]{0,20})\" (\\w+)", Pattern.CASE_INSENSITIVE);

    public String addNewTask(TaskBoard taskBoard, String line) {
        var match = newTaskPattern.matcher(line);
        if(!match.matches()) {
            return "Usage: newTask \"{taskName}\" \"{description}\"";
        }
        try {
            taskBoard.addTask(match.group(1), match.group(2));
            return "Added task: " + match.group(1);
        } catch (NoActiveUserException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    public String setTaskState(TaskBoard taskBoard, String line) {
        var match = setTaskState.matcher(line);
        if(!match.matches()) {
            return "Usage: setTaskState \"{taskName}\" {state}";
        }
        try {
            TaskState state = TaskState.valueOf(match.group(2).toUpperCase());
            taskBoard.setTaskState(match.group(1), state);
            return "The state of \"" + match.group(1) + "\"has been successfully changed";
        } catch (IllegalArgumentException e) {
            return "Usage: Invalid state, use: to_do, doing, done";
        } catch (NoActiveUserException | TaskNotFoundException e) {
            return e.getMessage();
        }
    }

    public String listTasks(TaskBoard taskBoard) {
        try {
            var response = new StringBuilder();
            var tasks = taskBoard.getTasksForActiveUser();
            tasks.forEach(task -> {
                response.append("- ").append(task.toString()).append("\n");
            });
            return response.toString();
        } catch (NoActiveUserException e) {
            return e.getMessage();
        }
    }
}

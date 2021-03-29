package com.example.taskmanager.commands.actions;

import com.example.taskmanager.exceptions.DuplicateUserException;
import com.example.taskmanager.exceptions.UserNotFoundException;
import com.example.taskmanager.model.TaskBoard;

import java.util.regex.Pattern;

public class UserService {

    Pattern newUserPattern = Pattern.compile("newUser (\\w+)", Pattern.CASE_INSENSITIVE);
    Pattern setUserPattern = Pattern.compile("activeUser (\\w+)", Pattern.CASE_INSENSITIVE);

    public String newUser(TaskBoard taskBoard, String line) {
        var match = newUserPattern.matcher(line);
        if(!match.matches()) {
            return "Usage: newUser {username}";
        }
        String username = match.group(1);
        try {
            taskBoard.addUser(username);
            return "User '" + username + "' has been added";
        } catch (DuplicateUserException e) {
            return "Username '" + username + "' is already taken";
        }
    }

    public String setActiveUser(TaskBoard taskBoard, String line) {
        var match = setUserPattern.matcher(line);
        if(!match.matches()) {
            return "Usage: activeUser {username}";
        }
        String username = match.group(1);
        try {
            taskBoard.setActiveUser(username);
            return "User '" + username + "' is active";
        } catch (UserNotFoundException e) {
            return "Username '" + username + "' is not registered";
        }
    }
}

package com.example.taskmanager.commands.actions;

import com.example.taskmanager.model.TaskBoard;
import com.example.taskmanager.persistence.TaskFileHandlerService;
import com.google.inject.Inject;

import java.io.IOException;

public class DataService {
    @Inject
    private TaskFileHandlerService tfhs;

    public String saveTaskBoard(TaskBoard taskBoard) {
        try {
            tfhs.saveTaskBoard(taskBoard);
            return "Task board saved successfully";
        } catch (IOException e) {
            return "Failed to save task board: " + e.getMessage();
        }
    }
}

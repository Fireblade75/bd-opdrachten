package com.example.taskmanager.persistence;

import com.example.taskmanager.model.TaskBoard;

import javax.inject.Inject;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class TaskFileHandlerServiceImpl implements TaskFileHandlerService {
    public static final String TASK_BOARD_LOCATION = "taskboard.tasks";
    private boolean persistenceMode = true;

    @Inject
    private JsonHandler jsonHandler;

    @Override
    public TaskBoard readOrCreateTaskBoard() {
        TaskBoard taskBoard = null;
        try {
            taskBoard = readTaskBoard(TASK_BOARD_LOCATION);
        } catch (IOException e) {
            System.out.println("WARN: Running Task Manager in non persistence mode");
            System.out.println("WARN: " + e.getMessage());
            System.out.flush();
        }
        if (taskBoard == null) {
            return new TaskBoard();
        }
        return taskBoard;
    }

    @Override
    public TaskBoard readTaskBoard() throws IOException {
        return readTaskBoard(TASK_BOARD_LOCATION);
    }

    @Override
    public TaskBoard readTaskBoard(String taskBoardLocation) throws IOException {
        try {
            File taskFile = new File(taskBoardLocation);
            if(!taskFile.exists()) {
                return null;
            }
            String taskFileStr = Files.readString(Path.of(taskBoardLocation));
            return jsonHandler.fromJson(taskFileStr);
        } catch (IOException e) {
            persistenceMode = false;
            throw e;
        }
    }

    @Override
    public void saveTaskBoard(TaskBoard taskBoard) throws IOException {
        saveTaskBoard(TASK_BOARD_LOCATION, taskBoard);
    }

    @Override
    public void saveTaskBoard(String taskBoardLocation, TaskBoard taskBoard) throws IOException {
        if (!persistenceMode) {
            throw new IOException("Persistence mode is disabled");
        }
        String taskBoardStr = jsonHandler.toJson(taskBoard);
        Files.writeString(Path.of(taskBoardLocation), taskBoardStr, StandardOpenOption.WRITE);
    }
}

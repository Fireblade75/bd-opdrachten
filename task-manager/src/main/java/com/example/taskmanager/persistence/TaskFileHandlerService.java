package com.example.taskmanager.persistence;

import com.example.taskmanager.model.TaskBoard;

import java.io.IOException;

public interface TaskFileHandlerService {
    TaskBoard readOrCreateTaskBoard();

    TaskBoard readTaskBoard() throws IOException;

    TaskBoard readTaskBoard(String taskBoardLocation) throws IOException;

    void saveTaskBoard(TaskBoard taskBoard) throws IOException;

    void saveTaskBoard(String taskBoardLocation, TaskBoard taskBoard) throws IOException;
}

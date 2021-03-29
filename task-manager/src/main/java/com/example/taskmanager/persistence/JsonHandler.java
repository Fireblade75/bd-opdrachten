package com.example.taskmanager.persistence;

import com.example.taskmanager.model.TaskBoard;

public interface JsonHandler {

    String toJson(TaskBoard taskBoard);

    TaskBoard fromJson(String json);
}

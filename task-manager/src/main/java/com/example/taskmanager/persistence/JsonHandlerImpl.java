package com.example.taskmanager.persistence;

import com.example.taskmanager.model.TaskBoard;
import com.google.gson.Gson;

public class JsonHandlerImpl implements JsonHandler {

    private final Gson gson = new Gson();

    public String toJson(TaskBoard taskBoard) {
        return gson.toJson(taskBoard);
    }

    public TaskBoard fromJson(String json) {
        return gson.fromJson(json, TaskBoard.class);
    }
}

package com.example.taskmanager.main;

import com.example.taskmanager.cli.TaskManagerTerminal;
import com.example.taskmanager.cli.TaskManagerTerminalImpl;
import com.example.taskmanager.commands.CommandHandlerService;
import com.example.taskmanager.commands.CommandHandlerServiceImpl;
import com.example.taskmanager.persistence.JsonHandler;
import com.example.taskmanager.persistence.JsonHandlerImpl;
import com.example.taskmanager.persistence.TaskFileHandlerService;
import com.example.taskmanager.persistence.TaskFileHandlerServiceImpl;
import com.google.inject.AbstractModule;

public class TaskModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(TaskFileHandlerService.class).to(TaskFileHandlerServiceImpl.class);
        bind(TaskManagerTerminal.class).to(TaskManagerTerminalImpl.class);
        bind(CommandHandlerService.class).to(CommandHandlerServiceImpl.class);
        bind(JsonHandler.class).to(JsonHandlerImpl.class);
    }
}

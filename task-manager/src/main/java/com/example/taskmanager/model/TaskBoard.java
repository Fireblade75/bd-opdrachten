package com.example.taskmanager.model;

import com.example.taskmanager.exceptions.DuplicateUserException;
import com.example.taskmanager.exceptions.NoActiveUserException;
import com.example.taskmanager.exceptions.TaskNotFoundException;
import com.example.taskmanager.exceptions.UserNotFoundException;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Stream;

public class TaskBoard implements Serializable {
    private static final long serialVersionUID = 3640184275285550105L;
    private final Set<User> users = new HashSet<>();
    private final List<Task> tasks = new ArrayList<>();

    private transient User activeUser = null;

    public void addUser(String username) throws DuplicateUserException {
        for(User user : users) {
            if(user.matchUsername(username)) {
                throw new DuplicateUserException();
            }
        }
        users.add(new User(username));
    }

    public User getActiveUser() {
        return activeUser;
    }

    public void setActiveUser(String username) throws UserNotFoundException {
        users.stream().filter(user -> user.matchUsername(username)).findFirst()
                .map(user -> activeUser = user)
                .orElseThrow(UserNotFoundException::new);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Tasks:");
        for(Task task : tasks) {
            sb.append("\n - ").append(task);
        }
        return sb.toString();
    }

    public void addTask(String name, String description) throws NoActiveUserException {
        if(activeUser == null) {
            throw new NoActiveUserException();
        }
        tasks.add(new Task(name, activeUser, description));
    }

    public void setTaskState(String taskName, TaskState state) throws TaskNotFoundException, NoActiveUserException {
        if(activeUser == null) {
            throw new NoActiveUserException();
        }
        for(var task : tasks) {
            if(task.matches(taskName, activeUser)) {
                task.setTaskState(state);
                return;
            }
        }
        throw new TaskNotFoundException("No task found with name " + taskName + " for user " + activeUser.getUsername());
    }

    public Stream<Task> getTasksForActiveUser() throws NoActiveUserException {
        if(activeUser == null) {
            throw new NoActiveUserException();
        }
        return tasks.stream().filter(task -> task.getOwner().equals(activeUser));
    }
}

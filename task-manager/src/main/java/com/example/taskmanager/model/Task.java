package com.example.taskmanager.model;

import com.google.common.base.Objects;

import java.io.Serializable;

public class Task implements Serializable {
    private static final long serialVersionUID = -8399456658269545173L;
    private static final int MAX_NAME_LENGTH = 20;
    private static final int MAX_DESCRIPTION_LENGTH = 128;

    private User owner;
    private TaskState taskState;
    private String name;
    private String description;

    /**
     * Creates a dummy task
     * @param name the name of the task
     * @param owner the owner of the task
     */
    public Task(String name, User owner) {
        this(name, owner, "", TaskState.UNKNOWN);
    }

    /**
     * Creates a new basic task with the status To Do
     * @param name the name of the task
     * @param owner the owner of the task
     * @param description a description for the task
     */
    public Task(String name, User owner, String description) {
        this(name, owner, description, TaskState.TO_DO);
    }

    /**
     * Creates a new basic task with a given state
     * @param name the name of the task
     * @param owner the owner of the task
     * @param description a description for the task
     * @param taskState the state of the task
     */
    public Task(String name, User owner, String description, TaskState taskState) {
        this.name = name;
        this.owner = owner;
        this.description = description;
        this.taskState = taskState;
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Task)) return false;
        Task other = (Task) o;
        return name.equals(other.name) && owner.equals(other.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(owner, name);
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public TaskState getTaskState() {
        return taskState;
    }

    public void setTaskState(TaskState taskState) {
        this.taskState = taskState;
    }

    @Override
    public String toString() {
        return String.format("[%s] \"%s\" - %s", taskState.toString(), name, description);
    }

    public boolean matches(String taskName, User user) {
        return this.name.equalsIgnoreCase(taskName)
                && this.owner.equals(user);
    }
}

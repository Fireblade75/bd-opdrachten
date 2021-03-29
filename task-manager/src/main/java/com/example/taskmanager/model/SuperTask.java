package com.example.taskmanager.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SuperTask extends Task implements Iterable<Task> {
    private static final long serialVersionUID = -6592962788492748743L;
    private final List<Task> taskList = new ArrayList<>();

    public SuperTask(String name, User owner, String description) {
        super(name, owner, description);
    }

    public SuperTask(String name, User owner, String description, List<Task> tasks) {
        super(name, owner, description, null);
        taskList.addAll(tasks);
    }

    public void addTask(Task task) {
        taskList.add(task);
    }

    public Task getTask(int i) {
        return taskList.get(i);
    }

    public int size() {
        return taskList.size();
    }

    @Override
    public TaskState getTaskState() {
        if(taskList.isEmpty()) {
            return TaskState.UNKNOWN;
        }
        boolean allTasksToDo = true;
        boolean allTasksDone = true;
        for (Task task : taskList) {
            TaskState taskState = task.getTaskState();
            if (!taskState.equals(TaskState.TO_DO)) {
                allTasksToDo = false;
            }
            if (!taskState.equals(TaskState.DONE)) {
                allTasksDone = false;
            }
            if(!allTasksDone && !allTasksToDo) {
                break;
            }
        }
        if(allTasksDone) {
            return TaskState.DONE;
        } else if (allTasksToDo) {
            return TaskState.TO_DO;
        } else {
            return TaskState.DOING;
        }
    }

    @Override
    public void setTaskState(TaskState taskState) {
        throw new UnsupportedOperationException("Cannot set TaskState on super task");
    }


    @Override
    public Iterator<Task> iterator() {
        return new SuperTaskIterator();
    }

    private class SuperTaskIterator implements Iterator<Task> {
        int taskId = 0;

        @Override
        public boolean hasNext() {
            return taskId < taskList.size();
        }

        @Override
        public Task next() {
            return taskList.get(taskId++);
        }
    }
}

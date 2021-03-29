package com.example.taskmanager.model;

import com.google.common.base.Objects;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 4595415329646114526L;
    private final String username;

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof User)) return false;
        return username.equals(((User) o).username);
    }

    @Override
    public int hashCode() {
        return username.hashCode();
    }

    public boolean matchUsername(String username) {
        return this.username.equalsIgnoreCase(username);
    }

    @Override
    public String toString() {
        return "User["+username + "]";
    }
}

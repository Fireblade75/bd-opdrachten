package com.example.office.actions.core;

public class ExitAction extends MenuAction {

    @Override
    public void runAction() {
    }

    @Override
    public String getActionName() {
        return "Exit";
    }

    @Override
    public int priority() {
        return Integer.MIN_VALUE;
    }
}

package com.example.office.actions.core;

public abstract class MenuAction implements Comparable<MenuAction> {
    public abstract void runAction();

    public abstract String getActionName();

    public int priority() {
        return 0;
    }

    @Override
    public final int compareTo(MenuAction o) {
        int priorityCompare = Integer.compare(o.priority(), priority());
        if(priorityCompare == 0) {
            if(getActionName() == null || o.getActionName() == null) {
                return 0;
            } else {
                return getActionName().compareTo(o.getActionName());
            }
        } else {
            return priorityCompare;
        }
    }
}

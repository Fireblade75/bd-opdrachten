package com.example.h10;

public class Android extends Human implements Chargeable {

    private int level = 0;

    @Override
    public String getGreeting() {
        return String.format("I'm only half human, but human still.... My energy level is %d%%", level);
    }

    @Override
    public int charge(int amount) {
        if(level + amount > 100) {
            throw new OverchargedException();
        } else {
            level += amount;
            return level;
        }
    }

    public static class OverchargedException extends RuntimeException {
    }

}

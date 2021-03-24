package com.example.h10;

public class Android extends Human implements Chargeable {

    private int level = 0;

    @Override
    public void greet() {
        System.out.printf("I'm only half human, but human still.... My energy level is %d%%%n", level);
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

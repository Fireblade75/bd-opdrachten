package com.example.overig;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

public class BossPetRoller {
    private static class BossPet {
        private final int threshold;
        private final int dropRate;
        private static final Random random = new Random();

        public BossPet(int dropRate, int threshold) {
            this.dropRate = dropRate;
            this.threshold = threshold;
        }

        public boolean rollDrop(int killCount) {
            int dropRateIncrease = Integer.max(killCount / threshold, 9);
            return random.nextDouble() < (1.0 + dropRateIncrease) / dropRate;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Integer> players = new ArrayList<>();
        BossPet bossPet = new BossPet(5000, 1000);
        int playerCount = 10000000;

        for (int i = 0; i < playerCount; i++) {
            int killCount = 0;
            do {
                killCount++;
            } while (!bossPet.rollDrop(killCount));
            players.add(killCount);
        }

        File file = new File("kills.txt");
        PrintWriter writer = new PrintWriter(file);
        players.stream().sorted().forEach(writer::println);
        writer.close();
    }
}

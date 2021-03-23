package com.example.datareader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class FileReader implements Iterable<String> {

    private final List<String> lines = new ArrayList<>();

    public void readFile(String fileName) {
        File file = new File(fileName);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    @Override
    public Iterator<String> iterator() {
        return new FileReaderIterator();
    }

    private class FileReaderIterator implements Iterator<String> {
        int index = 0;

        @Override
        public boolean hasNext() {
            return index < lines.size();
        }

        @Override
        public String next() {
            return lines.get(index++);
        }
    }
}

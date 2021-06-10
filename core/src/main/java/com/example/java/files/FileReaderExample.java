package com.example.java.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderExample {
    public static void main(String[] args) throws IOException {
        if(args.length == 1) {
            File file = new File(args[0]);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;

            if ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}

package com.example.java.chapters.h5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CloseResource {

    public String readFile() {
        int result = 0;
        try(BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("getallen.txt")))) {
            String line;
            while((line = br.readLine()) != null) {
                result += Integer.parseInt(line);
            }
        } catch (IOException | NumberFormatException e) {
            return e.getMessage();
        }
        return "" + result;
    }

    public static void main(String[] args) {
        CloseResource closeResource = new CloseResource();
        System.out.println("Content: " + closeResource.readFile());
    }
}

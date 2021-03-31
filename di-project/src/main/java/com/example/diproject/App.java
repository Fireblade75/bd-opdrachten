package com.example.diproject;

import com.example.di.DepManager;
import com.example.diproject.services.*;

public class App {
    public static void main(String[] args) {
        DepManager depManager = new DepManager();
        depManager.link(Adder.class, AdderImpl.class);
        depManager.link(Parser.class, ParserImpl.class);

        var adder = depManager.resolve(Adder.class);
        var writer = depManager.resolve(RandomTimeWriter.class);

        writer.writeToConsole(adder.add("4", "22"));
    }
}

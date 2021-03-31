package com.example.diproject;

import com.example.di.DepManager;
import com.example.diproject.services.Adder;
import com.example.diproject.services.AdderImpl;
import com.example.diproject.services.Parser;
import com.example.diproject.services.ParserImpl;

public class App {
    public static void main(String[] args) {
        DepManager depManager = new DepManager();
        depManager.link(Adder.class, AdderImpl.class);
        depManager.link(Parser.class, ParserImpl.class);

        Adder adder = (Adder) depManager.resolve(Adder.class);

        System.out.println(adder.add("4", "22"));
    }
}

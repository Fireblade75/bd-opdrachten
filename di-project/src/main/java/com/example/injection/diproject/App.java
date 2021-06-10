package com.example.injection.diproject;

import com.example.injection.di.DepManager;
import com.example.injection.diproject.services.*;
import com.example.injection.diproject.services.logger.BasicLogger;
import com.example.injection.diproject.services.logger.MyLogger;

public class App {
    public static void main(String[] args) {
        DepManager depManager = new DepManager();
        depManager.link(Adder.class, AdderImpl.class);
        depManager.link(Parser.class, ParserImpl.class);
        depManager.link(BasicLogger.class, new MyLogger("DI-Project"));

        var adder = depManager.resolve(Adder.class);
        var writer = depManager.resolve(RandomTimeWriter.class);
        var multiInject = depManager.resolve(MultiInject.class);

        writer.writeToConsole(adder.add("4", "22"));
        writer.writeToConsole("services use the same instances: " + multiInject.servicesUseOneInstance());
    }
}

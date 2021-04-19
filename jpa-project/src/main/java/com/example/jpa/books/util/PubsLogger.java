package com.example.jpa.books.util;

import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;

import java.io.IOException;
import java.io.InputStream;

public class PubsLogger {
    static {
        try {
            InputStream logConfigStream = PubsLogger.class.getClassLoader().getResourceAsStream("log4j2.xml");
            if(logConfigStream == null) {
                System.err.println("ERROR: Cannot find logger configuration!");
            } else {
                ConfigurationSource source = new ConfigurationSource(logConfigStream);
                Configurator.initialize(null, source);
            }
        } catch (IOException e) {
            System.err.println("ERROR: Failed to read logger configuration!");
            e.printStackTrace();
        }
    }
}

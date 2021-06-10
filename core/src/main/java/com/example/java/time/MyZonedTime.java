package com.example.java.time;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class MyZonedTime {

    public static void main(String[] args) {

        var timeFormat = DateTimeFormatter.ofPattern("HH:mm");


        Instant now = Instant.now();
        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(now, ZoneOffset.UTC);

        ZoneId westEuZone = ZoneId.of("Europe/Paris");

        String utcDateStr = zonedDateTime.format(timeFormat);
        ZonedDateTime euDateTime = ZonedDateTime.ofInstant(now, westEuZone);
        String localDateStr = euDateTime.format(timeFormat);

        System.out.println("UTC:   " + utcDateStr);
        System.out.println("Local: " + localDateStr);

    }
}

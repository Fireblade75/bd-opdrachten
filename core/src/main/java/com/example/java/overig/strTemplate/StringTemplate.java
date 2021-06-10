package com.example.java.overig.strTemplate;

import org.jetbrains.annotations.NotNull;

import java.util.regex.Pattern;

public class StringTemplate {

    String template;

    private static final Pattern paramPattern = Pattern.compile("(?<!\\\\)\\$[\\w]+");

    public StringTemplate(@NotNull String template) {
        this.template = template;
    }


}

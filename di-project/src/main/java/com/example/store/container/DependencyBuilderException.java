package com.example.store.container;

public class DependencyBuilderException extends RuntimeException {
    public DependencyBuilderException(String s) {
        super(s);
    }

    public DependencyBuilderException(String s, Exception e) {
        super(s, e);
    }
}

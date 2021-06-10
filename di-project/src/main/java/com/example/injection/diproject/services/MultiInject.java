package com.example.injection.diproject.services;

import com.example.injection.di.Inject;

public class MultiInject {

    @Inject
    private Adder adder1;

    @Inject
    private Adder adder2;

    public boolean servicesUseOneInstance() {
        if(adder1 == null) {
            throw new NullPointerException();
        }
        return adder1 == adder2;
    }
}

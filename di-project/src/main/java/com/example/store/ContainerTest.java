package com.example.store;

import com.example.store.container.DependencyBuilderException;
import com.example.store.container.DependencyContainer;
import com.example.store.services.CalculatorService;

public class ContainerTest {
    public static void main(String[] args) {

        DependencyContainer container = new DependencyContainer();
        CalculatorService calculator = container.getInstance(CalculatorService.class);

        var five = calculator.box(5);
        var ten = calculator.box(10);

        var res = calculator.multiply(five, ten);
        System.out.println(calculator.unBox(res));

    }
}

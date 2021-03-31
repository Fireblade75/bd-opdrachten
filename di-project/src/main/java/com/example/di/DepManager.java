package com.example.di;

import com.example.diproject.services.Adder;
import com.example.diproject.services.AdderImpl;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class DepManager {
    private HashMap<String, Object> dependencyMap = new HashMap<>();
    private HashMap<String, Class> abstractMappings = new HashMap<>();

    private void resolveDependencies(Object target) {
        for(Field field : target.getClass().getDeclaredFields()) {
            if(field.isAnnotationPresent(Inject.class)) {
                Class requestedClass = field.getType();
                field.setAccessible(true);
                try {
                    field.set(target, getInstance(requestedClass));
//                    field.set(target, requestedClass.cast(field.getType()));
                } catch (IllegalAccessException e) {
                    System.err.printf("Failed to inject dependency on field %s of class %s%n",
                            field.getName(), requestedClass.getName());
                    System.err.println(e.getMessage());
                }
            }
        }
    }

    private <T> Object getInstance(Class<T> requestedClass) {
        if(dependencyMap.containsKey(requestedClass.getName())) {
            return dependencyMap.get(requestedClass.getName());
        }
        try {
            Constructor<T> constructor  = requestedClass.getConstructor();
            T result = constructor.newInstance();
            resolveDependencies(result);
            dependencyMap.put(requestedClass.getName(), result);
            return result;
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            System.err.println("Failed to resolve dependency for " + requestedClass.getName());
            System.err.println(e.getMessage());
            return null;
        }
    }

    public <T> Object resolve(Class<T> requestedClass) {
        if(abstractMappings.containsKey(requestedClass.getName())) {
            return getInstance(abstractMappings.get(requestedClass.getName()));
        }
        return getInstance(requestedClass);
    }

    public void link(Class abstractClass, Class implClass) {
        if(!abstractClass.isAssignableFrom(implClass)) {
            throw new RuntimeException(String.format("%s is not an implementation for %s", implClass.getName(), abstractClass.getName()));
        }
        abstractMappings.put(abstractClass.getName(), implClass);
    }
}

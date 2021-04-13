package com.example.di;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class DepManager {
    private final HashMap<String, Object> dependencyMap = new HashMap<>();
    private final HashMap<String, Class<Object>> abstractMappings = new HashMap<>();

    /**
     * Resolve a dependency by using the empty constructor,
     * also resolves dependencies of this dependency bij injecting classes
     * @param requestedClass the requested class type
     * @return an instance of the class
     */
    public <T> T resolve(Class<T> requestedClass) {
        if(abstractMappings.containsKey(requestedClass.getName())) {
            return getInstance((Class<T>) abstractMappings.get(requestedClass.getName()));
        }
        return getInstance(requestedClass);
    }

    /**
     * Bind an implementation to an abstract class or interface
     * @param abstractClass the interface or abstract class
     * @param implClass the implementation to use
     */
    public <T, V extends T> void link(Class<T> abstractClass, Class<V> implClass) {
        if(!abstractClass.isAssignableFrom(implClass)) {
            throw new RuntimeException(String.format("%s is not an implementation for %s", implClass.getName(), abstractClass.getName()));
        }
        abstractMappings.put(abstractClass.getName(), (Class) implClass);
    }

    /**
     * Bind an instance to a class or interface
     * @param type the class that the instance is bound to
     * @param instance the instance of the class
     */
    public <T> void link(Class<T> type, T instance) {
        dependencyMap.put(type.getName(), instance);
    }

    private void resolveDependencies(Object target) {
        for(Field field : target.getClass().getDeclaredFields()) {
            if(field.isAnnotationPresent(Inject.class)) {
                Class<?> requestedClass = field.getType();
                field.setAccessible(true);
                try {
                    field.set(target, getInstance(requestedClass));
                } catch (IllegalAccessException e) {
                    System.err.printf("Failed to inject dependency on field %s of class %s%n",
                            field.getName(), requestedClass.getName());
                    System.err.println(e.getMessage());
                }
            }
        }
    }

    private <T> T getInstance(Class<T> requestedClass) {
        if(abstractMappings.containsKey(requestedClass.getName())) {
            return getDirectInstance((Class<T>) abstractMappings.get(requestedClass.getName()));
        }
        return this.<T>getDirectInstance(requestedClass);
    }

    private <T> T getDirectInstance(Class<T> requestedClass) {
        if(dependencyMap.containsKey(requestedClass.getName())) {
            return (T) dependencyMap.get(requestedClass.getName());
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
}

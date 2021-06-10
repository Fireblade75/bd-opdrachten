package com.example.store.container;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class DependencyContainer {
    private final Map<Class<?>, Object> dependencies = new HashMap<>();

    public <T> T getInstance(Class<T> clazz) {
        if(dependencies.containsKey(clazz)) {
            return (T) dependencies.get(clazz);
        } else {
            var constructors = clazz.getConstructors();
            if(constructors.length == 0) {
                T result = buildInstance(clazz);
                dependencies.put(clazz, result);
                return result;
            } if(constructors.length == 1) {
                var constructor = constructors[0];
                T result = (T) buildInstance(constructor);
                dependencies.put(clazz, result);
                return result;
            } else {
                throw new DependencyBuilderException(clazz.getName()
                        + " must have no more then 1 constructor, found " + constructors.length);
            }
        }
    }

    private <T> T buildInstance(Class<T> clazz) {
        try {
            Constructor<T> constructor = clazz.getConstructor();
            constructor.setAccessible(true);
            return constructor.newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new DependencyBuilderException("Failed to build instance of" + clazz.getName(), e);
        }
    }

    private <T> T buildInstance(Constructor<T> constructor) {
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        Object[] parameters = new Object[parameterTypes.length];

        for(int i = 0; i < parameterTypes.length; i++) {
            parameters[i] = getInstance(parameterTypes[i]);
        }

        try {
            constructor.setAccessible(true);
            return constructor.newInstance(parameters);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            String className = constructor.getDeclaringClass().getName();
            throw new DependencyBuilderException("Failed to build instance of " + className, e);
        }
    }
}

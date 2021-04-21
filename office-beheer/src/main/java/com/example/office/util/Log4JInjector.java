package com.example.office.util;

import com.google.inject.AbstractModule;
import com.google.inject.MembersInjector;
import com.google.inject.TypeLiteral;
import com.google.inject.matcher.Matchers;
import com.google.inject.spi.TypeEncounter;
import com.google.inject.spi.TypeListener;

import java.lang.reflect.Field;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4JInjector extends AbstractModule {

    @Override
    protected void configure() {
        bindListener(Matchers.any(), new Log4JTypeListener());
    }

    private static class Log4JTypeListener implements TypeListener {
        public <T> void hear(TypeLiteral<T> typeLiteral, TypeEncounter<T> typeEncounter) {
            Class<?> clazz = typeLiteral.getRawType();
            while (clazz != null) {
                for (Field field : clazz.getDeclaredFields()) {
                    if (field.getType() == Logger.class &&
                            field.isAnnotationPresent(InjectLogger.class)) {
                        typeEncounter.register(new Log4JMembersInjector<T>(field));
                    }
                }
                clazz = clazz.getSuperclass();
            }
        }
    }

    private static class Log4JMembersInjector<T> implements MembersInjector<T> {
        private final Field field;
        private final Logger logger;

        Log4JMembersInjector(Field field) {
            this.field = field;
            this.logger = LogManager.getLogger(field.getDeclaringClass());
            field.setAccessible(true);
        }

        public void injectMembers(T t) {
            try {
                field.set(t, logger);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

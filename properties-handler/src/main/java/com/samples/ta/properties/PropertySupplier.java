package com.samples.ta.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

public class PropertySupplier {
    private static ThreadLocal<Properties> threadProperties = new ThreadLocal<>();

    public static void load(InputStream stream) {
        try {
            getThreadProperties().load(stream);
        } catch (IOException e) {
            throw new ResourceReadFailedException("Problem occurred during reading properties file", e);
        }
    }

    public static String getProperty(final String propertyName) {
        return getThreadProperties().getProperty(propertyName);
    }

    private static Properties getThreadProperties() {
        if (Objects.isNull(threadProperties.get())) {
            threadProperties.set(new Properties());
        }
        return threadProperties.get();
    }
}

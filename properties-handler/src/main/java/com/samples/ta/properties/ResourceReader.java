package com.samples.ta.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ResourceReader {

    public static Properties getResourceAsProperties(String path) {
        try {
            InputStream stream = ResourceReader.class.getClassLoader().getResourceAsStream(path);
            Properties properties = new Properties();
            properties.load(stream);
            return properties;
        } catch (IOException e) {
            throw new ResourceReadFailedException("Exception on reading properties file", e);
        }
    }
}

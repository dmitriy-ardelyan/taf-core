package com.samples.ta.properties;

import java.io.IOException;
import java.io.InputStream;

public class PropertyLoader {
    public static void loadThreadProperties(Class loaderClass, String path) {
        try (final InputStream stream = loaderClass.getClassLoader().getResourceAsStream(path)) {
            PropertySupplier.load(stream);
        } catch (IOException e) {
            throw new ResourceReadFailedException("Problem occurred during reading properties file", e);
        }
    }
}

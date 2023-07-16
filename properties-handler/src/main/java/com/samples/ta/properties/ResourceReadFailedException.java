package com.samples.ta.properties;

public class ResourceReadFailedException extends RuntimeException {

    public ResourceReadFailedException(final String message) {
        super(message);
    }

    public ResourceReadFailedException(final String message, Object... args) {
        super(String.format(message, args));
    }
}

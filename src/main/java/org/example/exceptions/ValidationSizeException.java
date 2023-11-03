package org.example.exceptions;

public class ValidationSizeException extends RuntimeException {
    public ValidationSizeException() {
    }

    public ValidationSizeException(String message) {
        super(message);
    }

    public ValidationSizeException(String message, Throwable cause) {
        super(message, cause);
    }

    public ValidationSizeException(Throwable cause) {
        super(cause);
    }

    public ValidationSizeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

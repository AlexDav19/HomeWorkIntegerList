package org.example.exceptions;

public class ValidationIndexException extends RuntimeException {
    public ValidationIndexException() {
    }

    public ValidationIndexException(String message) {
        super(message);
    }

    public ValidationIndexException(String message, Throwable cause) {
        super(message, cause);
    }

    public ValidationIndexException(Throwable cause) {
        super(cause);
    }

    public ValidationIndexException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

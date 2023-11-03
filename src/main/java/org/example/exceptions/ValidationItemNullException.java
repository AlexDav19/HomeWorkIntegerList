package org.example.exceptions;

public class ValidationItemNullException extends RuntimeException {
    public ValidationItemNullException() {
    }

    public ValidationItemNullException(String message) {
        super(message);
    }

    public ValidationItemNullException(String message, Throwable cause) {
        super(message, cause);
    }

    public ValidationItemNullException(Throwable cause) {
        super(cause);
    }

    public ValidationItemNullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

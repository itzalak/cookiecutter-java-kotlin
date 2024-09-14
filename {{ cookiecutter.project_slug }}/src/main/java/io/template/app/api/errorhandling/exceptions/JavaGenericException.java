package io.template.app.api.errorhandling.exceptions;

public class JavaGenericException extends RuntimeException {

    private final ErrorType errorType;

    public JavaGenericException(String message, ErrorType errorType) {
        this(message, errorType, null);
    }

    JavaGenericException(String message, ErrorType errorType, Throwable cause) {
        super(message, cause);
        this.errorType = errorType;
    }

    public ErrorType getErrorCode() {
        return this.errorType;
    }
}

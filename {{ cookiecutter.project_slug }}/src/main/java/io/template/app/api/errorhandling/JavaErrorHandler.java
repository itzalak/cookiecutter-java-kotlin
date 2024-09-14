package io.template.app.api.errorhandling;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.template.app.api.controller.v1.JavaApiErrorResponse;
import io.template.app.api.errorhandling.exceptions.JavaGenericException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static io.template.app.api.errorhandling.exceptions.ErrorType.BAD_REQUEST;
import static io.template.app.api.errorhandling.exceptions.ErrorType.UNKNOWN_ERROR;

@RestControllerAdvice
public class JavaErrorHandler {

    @ExceptionHandler(Exception.class)
    @ApiResponse(
            responseCode = "500",
            description = "Internal error, unknown error, server error, etc"
    )
    public ResponseEntity<JavaApiErrorResponse> handleUnknownException(Exception ex) {
        return new ResponseEntity<>(
                new JavaApiErrorResponse(UNKNOWN_ERROR.name(), ex.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    @ExceptionHandler(JavaGenericException.class)
    public ResponseEntity<JavaApiErrorResponse> handleGenericException(Exception ex) {
        return new ResponseEntity<>(
                new JavaApiErrorResponse(BAD_REQUEST.name(), ex.getMessage()),
                HttpStatus.BAD_REQUEST
        );
    }
}

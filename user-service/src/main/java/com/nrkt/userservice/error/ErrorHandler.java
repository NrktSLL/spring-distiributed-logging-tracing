package com.nrkt.userservice.error;

import com.nrkt.userservice.exception.BadRequestException;
import lombok.extern.log4j.Log4j2;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Log4j2
@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler({
            IllegalArgumentException.class,
            BadRequestException.class
    })
    @ResponseStatus(BAD_REQUEST)
    ResponseEntity<ApiError> handleCustomBadRequestException(BadRequestException ex, HttpServletRequest request) {
        return new ResponseEntity<>(errorDetails(ex.getMessage(), BAD_REQUEST, request), BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    ResponseEntity<ApiError> handleException(Exception ex, HttpServletRequest request) {
        return new ResponseEntity<>(errorDetails(ex.getMessage(), INTERNAL_SERVER_ERROR, request), INTERNAL_SERVER_ERROR);
    }

    private ApiError errorDetails(String message, HttpStatus httpStatus, HttpServletRequest request) {
        var errorDetail = ApiError.builder()
                .message(message)
                .status(httpStatus.value())
                .timestamp(new Date())
                .error(httpStatus.getReasonPhrase())
                .path(request.getRequestURI().substring(request.getContextPath().length())).build();

        log.error(errorDetail.toString());
        return errorDetail;
    }
}
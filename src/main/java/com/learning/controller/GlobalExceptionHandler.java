package com.learning.controller;

import com.learning.exception.DataExistsException;
import com.learning.exception.EventDataHandlingException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.TypeMismatchException;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by amits on 15/09/16.
 */
@ControllerAdvice
@Log4j2
public class GlobalExceptionHandler {
    @ExceptionHandler(DataAccessException.class)
    public Response handleSQLException(DataAccessException ex) {
        log.error("Database error occurred", ex);
        return Response.failure(ResponseErrorCode.UNKNOWN_ERROR, "Internal system error occurred");
    }

    @ExceptionHandler(DataExistsException.class)
    public Response handleDataExistsException(DataExistsException ex) {
        log.error("Data already exists", ex);
        return Response.failure(ResponseErrorCode.USER_ALREADY_EXISTS, ex.getMessage());
    }

    @ExceptionHandler(EventDataHandlingException.class)
    public Response handleJsonParsingException(Exception ex) {
        log.error("Error occurred in parsing json", ex);
        return Response.failure(ResponseErrorCode.INVALID_RESPONSE, ex.getMessage());
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    public Response illegalArgumentExceptionHandler(IllegalArgumentException exception) {
        log.error("Wrong arguments passed to exception", exception);
        return Response.failure(ResponseErrorCode.INVALID_REQUEST, exception.getMessage());
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(TypeMismatchException.class)
    @ResponseBody
    public Response typeMismatchException(TypeMismatchException exception) {
        log.error("Error occurred in matching request arguments", exception);
        return Response.failure(ResponseErrorCode.INVALID_REQUEST, exception.getMessage());
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    public Response httpRequestMethodNotSupportedExceptionHandler(HttpRequestMethodNotSupportedException exception) {
        log.error("Invalid method mapping", exception);
        return Response.failure(ResponseErrorCode.INVALID_RESPONSE, exception.getMessage());
    }

}

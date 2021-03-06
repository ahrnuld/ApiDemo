package io.swagger.api;

import io.swagger.model.DTO.ExceptionDTO;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.logging.Logger;

@ControllerAdvice
public class ResponseStatusExceptionHandler extends ResponseEntityExceptionHandler {

    private final Logger log = Logger.getLogger(this.getClass().getName());

    @Order(1)
    @ExceptionHandler(value = {ResponseStatusException.class})
    protected ResponseEntity<Object> handleResponseStatusException(ResponseStatusException ex, WebRequest request) {
        ExceptionDTO dto = new ExceptionDTO(ex.getReason());
        return handleExceptionInternal(ex, dto, new HttpHeaders(), HttpStatus.valueOf(ex.getStatus().value()), request);
    }

    @Order(2)
    @ExceptionHandler(value = {Exception.class})
    protected ResponseEntity<Object> handleTheRest(Exception ex, WebRequest request) {
        log.info("Actual exception is: " + ex.getClass().getCanonicalName());
        ExceptionDTO dto = new ExceptionDTO(ex.getMessage());
        if (ex instanceof BadCredentialsException) {
            return handleExceptionInternal(ex, dto, new HttpHeaders(), HttpStatus.FORBIDDEN, request);
        }
        return handleExceptionInternal(ex, dto, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}

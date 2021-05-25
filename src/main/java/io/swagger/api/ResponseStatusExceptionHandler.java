package io.swagger.api;

import io.swagger.model.DTO.ExceptionDTO;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.naming.AuthenticationException;
import javax.security.auth.message.AuthException;
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
    @ExceptionHandler(value = {AuthException.class})
    protected ResponseEntity<Object> handleAuthenticationException(AuthenticationException ex, WebRequest request) {
        ExceptionDTO dto = new ExceptionDTO(ex.getMessage());
        return handleExceptionInternal(ex, dto, new HttpHeaders(), HttpStatus.FORBIDDEN, request);
    }

    @Order(3)
    @ExceptionHandler(value = {Exception.class})
    protected ResponseEntity<Object> handleTheRest(Exception ex, WebRequest request) {
        log.info(ex.getClass().getName());
        ExceptionDTO dto = new ExceptionDTO(ex.getMessage());
        return handleExceptionInternal(ex, dto, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}

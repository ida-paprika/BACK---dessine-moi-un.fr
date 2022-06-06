package co.simplon.p25.dessinemoiun.exceptions;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import co.simplon.p25.dessinemoiun.configuration.RestTemplateException;

@RestControllerAdvice
public class ControllerAdvice extends ResponseEntityExceptionHandler {

    private final static Log LOGGER = LogFactory.getLog(ControllerAdvice.class);

    @ExceptionHandler(RestTemplateException.class)
    protected ResponseEntity<Object> handleRestTemplateException(
	    RestTemplateException ex, WebRequest request) {
	return handleExceptionInternal(ex, ex.getBody(), new HttpHeaders(),
		ex.getStatus(), request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
	    MethodArgumentNotValidException ex, HttpHeaders headers,
	    HttpStatus status, WebRequest request) {
	ValidationErrors errors = toValidationErrors(ex.getGlobalErrors(),
		ex.getFieldErrors());
	return handleExceptionInternal(ex, errors, headers, status, request);
    }

    @ExceptionHandler(BadCredentialsException.class)
    protected ResponseEntity<Object> handleBadCredentialsException(
	    BadCredentialsException ex, WebRequest request) {

	Map<String, Object> body = new LinkedHashMap<>();
	body.put("timestamp", new Date());
	body.put("message", ex.getMessage());
	body.put("status", HttpStatus.UNAUTHORIZED.value());

	return handleExceptionInternal(ex, body, new HttpHeaders(),
		HttpStatus.UNAUTHORIZED, request);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    protected ResponseEntity<Object> handleResourceNotFoundException(
	    ResourceNotFoundException ex, WebRequest request) {

	Map<String, Object> body = new LinkedHashMap<>();
	body.put("timestamp", new Date());
	body.put("message", ex.getMessage());
	body.put("status", HttpStatus.NOT_FOUND.value());

	return handleExceptionInternal(ex, body, new HttpHeaders(),
		HttpStatus.NOT_FOUND, request);
    }

    private static ValidationErrors toValidationErrors(
	    List<ObjectError> objectErrors, List<FieldError> fieldErrors) {
	ValidationErrors errors = new ValidationErrors();
	objectErrors
		.forEach((e) -> errors.addGlobalError(e.getDefaultMessage()));
	fieldErrors.forEach((e) -> errors.addFieldError(e.getField(),
		e.getDefaultMessage()));
	return errors;
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex,
	    Object body, HttpHeaders headers, HttpStatus status,
	    WebRequest request) {
	LOGGER.debug(ex);
	return super.handleExceptionInternal(ex, body, headers, status,
		request);
    }

}

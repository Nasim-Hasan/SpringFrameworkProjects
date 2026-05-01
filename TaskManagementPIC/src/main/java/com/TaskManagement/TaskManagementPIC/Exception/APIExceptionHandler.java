package com.TaskManagement.TaskManagementPIC.Exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.net.URI;
import java.time.Instant;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@RestControllerAdvice
public class APIExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ProblemDetail handleValidation(MethodArgumentNotValidException ex, HttpServletRequest req){
        ProblemDetail pd = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, "Validation failed");
        pd.setType(URI.create("https://acme.com/problems/validation-error"));
        pd.setInstance(URI.create(req.getRequestURI()));
        Map<String,String> fields = ex.getBindingResult().getFieldErrors().stream()
                .collect(Collectors.toMap(FieldError::getField, DefaultMessageSourceResolvable::getDefaultMessage, (a, b)->a));
        pd.setProperty("fields", fields);
        pd.setProperty("timestamp", Instant.now());
        pd.setProperty("errorId", UUID.randomUUID().toString());
        return pd;
    }

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ProblemDetail handleForbidden(AccessDeniedException ex, HttpServletRequest req){ /* similar */ }

    @ExceptionHandler(ChangeSetPersister.NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ProblemDetail handleNotFound(ChangeSetPersister.NotFoundException ex, HttpServletRequest req){ /* similar */ }

    @ExceptionHandler(ConflictException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ProblemDetail handleConflict(ConflictException ex, HttpServletRequest req){ /* similar */ }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ProblemDetail handleUnknown(Exception ex, HttpServletRequest req){
        // Log full details with traceId; do not expose internals
        ProblemDetail pd = ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, "Unexpected server error");
        pd.setType(URI.create("https://acme.com/problems/internal-error"));
        pd.setInstance(URI.create(req.getRequestURI()));
        pd.setProperty("timestamp", Instant.now());
        pd.setProperty("errorId", UUID.randomUUID().toString());
        return pd;
    }
}

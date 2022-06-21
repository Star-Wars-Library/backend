package edu.sanvalero.starwarslibrary.app;

import edu.sanvalero.starwarslibrary.shared.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalErrorHandler {
    private final Logger logger = LoggerFactory.getLogger(GlobalErrorHandler.class);

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(Exception e) {
        logger.error(e.getMessage());
        return new ResponseEntity<>(
                new ErrorResponse(
                        HttpStatus.INTERNAL_SERVER_ERROR.value(),
                        e.getLocalizedMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
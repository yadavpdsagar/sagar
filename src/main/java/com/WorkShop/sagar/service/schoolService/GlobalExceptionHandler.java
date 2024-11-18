package com.WorkShop.sagar.service.schoolService;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends Throwable {

    @Autowired
    private ErrorLogService errorLogService;

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<String> handleCustomException(CustomException ex) {
        // Log the error to the database
        errorLogService.logError(ex.getMessage(), ex.getStackTrace().toString(), "School System");
        return new ResponseEntity<>("Custom Error: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> nullhandleCustomException(CustomException Np){
        errorLogService.logError(Np.getMessage() , Np.getStackTrace().toString() , "nullpointError");
        return new ResponseEntity<>("Custom Error: " + Np.getMessage(),  HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleEntityNotFoundException(EntityNotFoundException ex) {
        // Log the error to the database
        errorLogService.logError(ex.getMessage(), ex.getStackTrace().toString(), "School System");
        return new ResponseEntity<>("Entity Not Found: " + ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralException(Exception ex) {
        // Log the error to the database
        errorLogService.logError(ex.getMessage(), ex.getStackTrace().toString(), "Unknown Endpoint");
        return new ResponseEntity<>("An error occurred: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

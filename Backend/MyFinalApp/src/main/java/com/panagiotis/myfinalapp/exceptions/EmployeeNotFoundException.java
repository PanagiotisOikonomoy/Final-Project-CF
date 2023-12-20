package com.panagiotis.myfinalapp.exceptions;

/**
 * @author Panagiotis Oikonomou
 */
public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(String message) {
        super(message);
    }
}

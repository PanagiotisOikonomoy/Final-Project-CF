package com.panagiotis.myfinalapp.exceptions;

/**
 * @author Panagiotis Oikonomou
 */
public class employeeAlreadyExistsException extends RuntimeException {
    public employeeAlreadyExistsException(String message) {
        super(message);
    }
}

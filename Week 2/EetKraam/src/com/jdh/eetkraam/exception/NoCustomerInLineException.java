package com.jdh.eetkraam.exception;

/**
 * This Exception class is used to address that there is no customer is in line
 */
public class NoCustomerInLineException extends Exception {

    public NoCustomerInLineException() {
    }

    public NoCustomerInLineException(String message) {
        super(message);
    }
}
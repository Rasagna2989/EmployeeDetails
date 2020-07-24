package com.employee.exceptionhandler;

/**
 * This class provides a common Exception Method that can be used across the Employee
 * application for throwing generic Exception.
 */
@SuppressWarnings("serial")
public class EmployeeCommonException extends Exception {

    /**
     * Simple Exception with Just exception Message.
     * @param message {@link String} Exception Message.
     */
    public EmployeeCommonException(String message) {
        super(message);
    }

    /**
     * Exception With Custom {@link Throwable} cause.
     * @param message  {@link String} Exception Message.
     * @param cause {@link Throwable} Cause for the Exception.
     */
    public EmployeeCommonException(String message, Throwable cause) {
        super(message, cause);
    }
}
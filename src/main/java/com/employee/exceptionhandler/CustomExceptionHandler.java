package com.employee.exceptionhandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Order(value = 1)
public class CustomExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Map<String, List<Object>> handleValidationExceptions(HttpServletRequest request, MethodArgumentNotValidException exception) {

        Map<String, List<Object>> errors = new HashMap<>();
        List<Object> fieldErrors = exception.getBindingResult()
                .getFieldErrors().stream()
                .map(FieldError::getField)
                .collect(Collectors.toList());

        List<Object> errorMessages = exception.getBindingResult()
                .getAllErrors().stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.toList());

        errors.put("Field Errors", fieldErrors);
        errors.put("Error Messages", errorMessages);
        return errors;
    }
	
	@ExceptionHandler(value = EmployeeCommonException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public Map<String, String> handleEmployeeCommonException(HttpServletRequest request, EmployeeCommonException exception) {
        HashMap<String, String> commonError = new HashMap<>();
        commonError.put("message", exception.getMessage());
        return commonError;
    }
	
	
}
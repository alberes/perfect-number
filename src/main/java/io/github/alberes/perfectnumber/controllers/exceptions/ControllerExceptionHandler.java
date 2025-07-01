package io.github.alberes.perfectnumber.controllers.exceptions;

import io.github.alberes.perfectnumber.controllers.exceptions.dto.FieldErrorDto;
import io.github.alberes.perfectnumber.controllers.exceptions.dto.StandardErrorDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException,
                                                             HttpServletRequest httpServletRequest){
        List<FieldError> fieldErrors = methodArgumentNotValidException.getFieldErrors();

        List<FieldErrorDto> fieldErrorsDto = fieldErrors
                .stream()
                .map(fd -> new FieldErrorDto(fd.getField(), fd.getDefaultMessage()))
                .toList();

        StandardErrorDto standardErrorDto = new StandardErrorDto(
                System.currentTimeMillis(),
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.getReasonPhrase(),
                methodArgumentNotValidException.getMessage(),
                httpServletRequest.getRequestURI(),
                fieldErrorsDto);

        return ResponseEntity
                .status(standardErrorDto.getStatus()).body(standardErrorDto);

    }
}

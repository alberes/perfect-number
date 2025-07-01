package io.github.alberes.perfectnumber.controllers.exceptions;

import io.github.alberes.perfectnumber.controllers.exceptions.dto.FieldErrorDto;
import io.github.alberes.perfectnumber.controllers.exceptions.dto.StandardErrorDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(HandlerMethodValidationException.class)
    public ResponseEntity<StandardErrorDto> constraintViolationException(HandlerMethodValidationException handlerMethodValidationException,
                                                             HttpServletRequest httpServletRequest){

        List<FieldErrorDto> fields = new ArrayList<FieldErrorDto>();
        FieldErrorDto fieldErrorDto = new FieldErrorDto("perfectNumber", "Fill this field greater than 0");
        fields.add(fieldErrorDto);

        StandardErrorDto standardErrorDto = new StandardErrorDto(
                System.currentTimeMillis(),
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.getReasonPhrase(),
                handlerMethodValidationException.getMessage(),
                httpServletRequest.getRequestURI(),
                fields);

        return ResponseEntity
                .status(standardErrorDto.getStatus()).body(standardErrorDto);

    }
}

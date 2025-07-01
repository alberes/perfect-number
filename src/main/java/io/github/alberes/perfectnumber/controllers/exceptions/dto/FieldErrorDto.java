package io.github.alberes.perfectnumber.controllers.exceptions.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "FieldError")
public record FieldErrorDto(String field, String message){
}
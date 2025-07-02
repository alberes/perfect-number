package io.github.alberes.perfectnumber.controllers.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "PerfectNumberResponse")
public record PerfectNumberResponseDto(
        int number,
        boolean perfectNumber
) {
}

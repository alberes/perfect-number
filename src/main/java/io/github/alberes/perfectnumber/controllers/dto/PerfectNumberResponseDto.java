package io.github.alberes.perfectnumber.controllers.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "PerfectNumber")
public record PerfectNumberResponseDto(
        boolean perfectNumber
) {
}

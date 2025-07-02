package io.github.alberes.perfectnumber.controllers;

import io.github.alberes.perfectnumber.controllers.dto.PerfectNumberRequestDto;
import io.github.alberes.perfectnumber.controllers.dto.PerfectNumberResponseDto;
import io.github.alberes.perfectnumber.controllers.exceptions.dto.StandardErrorDto;
import io.github.alberes.perfectnumber.services.PerfectNumberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/perfect-numbers")
@Tag(name = "PerfectNumber")
public class PerfectNumberController {

    private PerfectNumberService service;

    public PerfectNumberController(PerfectNumberService service){
        this.service = service;
    }

    @GetMapping("/{perfectNumber}")
    @Operation(summary = "Verify perfect number.", description = "Verify perfect number.",
            operationId = "perfectNumber")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Success."),
            @ApiResponse(responseCode = "400", description = "Validation error.",
                    content = @Content(schema = @Schema(implementation = StandardErrorDto.class)))
    })
    public ResponseEntity<PerfectNumberResponseDto> verifyPerfectNumber(@PathVariable @Min(1) int perfectNumber){

        boolean verify = this.service.isPerfectNumber(perfectNumber);
        PerfectNumberResponseDto dto = new PerfectNumberResponseDto(perfectNumber, verify);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(dto);
    }

    @PostMapping
    @Operation(summary = "Verify perfect number.", description = "Verify perfect number.",
            operationId = "perfectNumbers")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Success."),
            @ApiResponse(responseCode = "400", description = "Validation error.",
                    content = @Content(schema = @Schema(implementation = StandardErrorDto.class)))
    })
    public ResponseEntity<List<PerfectNumberResponseDto>> verifyPerfectNumbers(@RequestBody @Valid  PerfectNumberRequestDto perfectNumbers){
        List<PerfectNumberResponseDto> response = new ArrayList<PerfectNumberResponseDto>();

        for (int perfectNumber : perfectNumbers.getPerfectNumbers()) {
            boolean verify = this.service.isPerfectNumber(perfectNumber);
            PerfectNumberResponseDto dto = new PerfectNumberResponseDto(perfectNumber, verify);
            response.add(dto);
        }

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }
}

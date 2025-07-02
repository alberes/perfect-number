package io.github.alberes.perfectnumber.controllers.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;

import java.util.List;

@Schema(name = "PerfectNumberRequest")
public class PerfectNumberRequestDto{

    private List<@Min(1) Integer> perfectNumbers;

    public List<Integer> getPerfectNumbers() {
        return perfectNumbers;
    }

    public void setPerfectNumbers(List<Integer> perfectNumbers) {
        this.perfectNumbers = perfectNumbers;
    }
}

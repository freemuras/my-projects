package com.carecheck.carecheck_back.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ReqAddVitalInAdmDto {
    @Schema(description = "접수번호", example = "3", required = true)
    private int admId;
    @Schema(description = "등록한 직원 코드", example = "2025010001", required = true)    
    private String usercode;
    @Schema(description = "키", example = "130")
    private double height;
    @Schema(description = "몸무게", example = "39.3")
    private double weight;
    @Schema(description = "체온", example = "38.5")
    private double fever;
}

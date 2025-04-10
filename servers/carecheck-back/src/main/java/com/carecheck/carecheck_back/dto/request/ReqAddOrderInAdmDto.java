package com.carecheck.carecheck_back.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ReqAddOrderInAdmDto {
    @Schema(description = "접수번호", example = "1", required = true)
    private int admId;
    @Schema(description = "오더코드", example = "AA156", required = true)
    private String orderCode;
    @Schema(description = "용량ml, mg", example = "1.56", required = true)
    private Double orderDose;
    @Schema(description = "횟수", example = "3", required = true)
    private int orderCount;
    @Schema(description = "일수", example = "3", required = true)
    private int orderDays;
    @Schema(description = "방법", example = "하루 3일치 먹으세요")
    private String orderMethod;
}

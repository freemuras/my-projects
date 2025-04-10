package com.carecheck.carecheck_back.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ReqAddDiagnosisInAdmDto {
    @Schema(description = "접수번호", example = "1", required = true)
    private int admId;
    @Schema(description = "상병코드", example = "j00", required = true)
    private String diseaseCode;
    @Schema(description = "상병이름")
    private String diseaseKName;
}

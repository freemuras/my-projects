package com.carecheck.carecheck_back.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ReqAddAdmissionDto {
    @Schema(description = "환자차트번호", example = "1", required = true)
    private String patientId;
    @Schema(description = "의사사번", example = "2025020004", required = true)
    private String usercode;
    @Schema(description = "진료과", example="소아과", required = true)
    private String clinicDeft;
}

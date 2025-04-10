package com.carecheck.carecheck_back.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "환자 검색 DTO")
public class ReqSearchChartDto {

    @Schema(description = "환자 차트 번호")
    private Integer patientId;
}

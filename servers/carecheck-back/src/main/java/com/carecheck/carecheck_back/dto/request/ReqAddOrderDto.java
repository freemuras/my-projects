package com.carecheck.carecheck_back.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "오더 등록")
public class ReqAddOrderDto {
    @Schema(description = "오더코드")
    private String orderCode;
    @Schema(description = "오더명")
    private String orderName;
    @Schema(description = "상대가치점수")
    private Double orderScore;
}

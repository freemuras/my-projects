package com.carecheck.carecheck_back.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "오더 검색 DTO")
public class ReqSearchOrderDto {

    @Schema(description = "오더명")
    private String keyword = "";
}

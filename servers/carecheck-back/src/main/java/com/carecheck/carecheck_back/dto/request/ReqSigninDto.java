package com.carecheck.carecheck_back.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReqSigninDto {
    @Schema(description = "사원번호", example = "2025010001", required = true)
    private String usercode;
    @Schema(description = "비밀번호", example = "qwer1234!", required = true)
    private String password;
}

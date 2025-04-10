package com.carecheck.carecheck_back.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ReqPatientRegDto {
    @Schema(description = "환자 이름" ,example = "이순신", required = true)
    private String patientName;
    @Schema(description = "주민등록번호", example = "111111-2222222", required = true)
    private String regidentNum;
    @Schema(description = "휴대폰번호", example = "010-1234-5678")
    private String phoneNumber;

}

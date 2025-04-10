package com.carecheck.carecheck_back.dto.request;

import com.carecheck.carecheck_back.entity.User;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReqSignupDto {
    @Schema(description = "성명", example = "홍길동", required = true)
    private String username;
    @Schema(description = "비밀번호", example = "qwer1234!", required = true)
    private String password;
    @Schema(description = "이메일", example = "test@gmail.com", required = true)
    private String email;
    @Schema(description = "휴대폰 번호", example = "010-1234-5678", required = true)
    private String phoneNumber;
    @Schema(description = "권한 ID", example = "1", required = true)
    private int roleId;
}

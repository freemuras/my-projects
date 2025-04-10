package com.carecheck.carecheck_back.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "공지사항 작성")
public class ReqWriteNoticeDto {
    @Schema(description = "제목")
    private String title;
    @Schema(description = "내용")
    private String content;
}
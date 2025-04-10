package com.carecheck.carecheck_back.dto.request;

import com.carecheck.carecheck_back.entity.Notice;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Schema(description = "공지 수정")
public class ReqModifyNoticeDto {
    @NotEmpty(message = "제목은 필수 입력 사항입니다.")
    private String title;
    @NotEmpty(message = "내용은 필수 입력 사항입니다.")
    private String content;

    public Notice toNotice(int noticeId) {
        return Notice.builder()
                .noticeId(noticeId)
                .title(title)
                .content(content)
                .build();
    }
}

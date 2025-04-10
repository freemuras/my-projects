package com.carecheck.carecheck_back.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoticeSearch {
    private int noticeId;
    private String usercode;
    private String title;
    private String content;
    private int viewCount;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private String username;
}

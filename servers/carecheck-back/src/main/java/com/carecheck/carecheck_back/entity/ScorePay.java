package com.carecheck.carecheck_back.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ScorePay {
    private int scorePayId;
    private Double scorePay;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
}
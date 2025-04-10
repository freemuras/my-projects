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
public class Diagnosis {
    private int diagnosisId;
    private int admId;
    private String diseaseCode;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
}
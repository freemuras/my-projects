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
public class PatientVital {
    private int patientVitalId;
    private int admId;
    private String usercode;
    private Double height;
    private Double weight;
    private Double fever;
    private String vitalCheckTime;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

}
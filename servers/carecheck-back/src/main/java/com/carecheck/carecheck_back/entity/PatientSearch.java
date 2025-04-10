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

public class PatientSearch {
    private int admId;
    private int patientId;
    private String patientName;
    private String regidentNum;
    private String phoneNum;
    private String admDate;
    private String doctorName;
    private int totalPay;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
package com.carecheck.carecheck_back.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
    private int patientId;
    private String patientName;
    private String regidentNum;
    private String phoneNum;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String createdAtDateFormat;
    private String updatedAtDateFormat;
}
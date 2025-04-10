package com.carecheck.carecheck_back.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Disease {
    private String diseaseCode;
    private String diaseseEName;
    private String diseaseKName;
}
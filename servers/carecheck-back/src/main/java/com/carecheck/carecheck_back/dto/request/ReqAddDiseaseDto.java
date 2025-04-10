package com.carecheck.carecheck_back.dto.request;

import lombok.Data;

@Data
public class ReqAddDiseaseDto {
    private String diseaseCode;
    private String diseaseEName;
    private String diseaseKName;
}

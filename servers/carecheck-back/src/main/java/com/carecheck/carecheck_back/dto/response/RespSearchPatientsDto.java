package com.carecheck.carecheck_back.dto.response;

import com.carecheck.carecheck_back.entity.Patient;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class RespSearchPatientsDto {
    private int page;
    private int limitCount;
    private int totalPages;
    private int totalElements;
    private boolean isFirstPage;
    private boolean isLastPage;

    private List<Patient> patientList;
}

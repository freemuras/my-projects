package com.carecheck.carecheck_back.dto.request;

import lombok.Data;

@Data
public class ReqSearchPatientsDto {
    private int page;
    private int limitCount;
    private String searchText;
}

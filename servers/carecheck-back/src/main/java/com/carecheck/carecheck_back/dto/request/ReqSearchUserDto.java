package com.carecheck.carecheck_back.dto.request;

import lombok.Data;

@Data
public class ReqSearchUserDto {
    private int page;
    private int limitCount;
    private String order;
    private String searchName;
}

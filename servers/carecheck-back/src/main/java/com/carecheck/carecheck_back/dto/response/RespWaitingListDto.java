package com.carecheck.carecheck_back.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RespWaitingListDto {
    private Long admId;
    private Long patientId;
    private String patientName;
    private String phoneNum;
    private String usercode;
    private String admDate;
    private String startDate;
    private String endDate;
}

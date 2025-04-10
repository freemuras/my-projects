package com.carecheck.carecheck_back.mapper;

import java.util.List;

import com.carecheck.carecheck_back.dto.response.RespWaitingListDto;
import com.carecheck.carecheck_back.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AdmissionMapper {
    int insertAdmission(Admission admission);
    int selectPatientId(int patientId);
    Admission selectPatientInfoByAdmId(int admissionId);
    int insertOrderInAdmission(DiagnosisOrder diagnosisOrder);
    int deleteOrderInAdmission(int diagnosisOrderId);
    int insertDiagnosisInAdmission(Diagnosis diagnosis);
    int insertVitalInAdmId(PatientVital patientVital);
    Integer selectTotalPayByAdmId(int admissionId);
    List<Admission> selectWaitingListByUserCode(String usercode);
    List<Admission> selectVitalInfoByAdmId(int admissionId);
    Admission selectDetailOrderByAdmId(int admissionId);
    int updateAdmissionStartDate(int admissionId);
    int updateAdmissionEndDate(int admissionId);

    List<PatientSearch> selectAllWaitingListAdmId(
            @Param("startIndex") int startIndex,
            @Param("limitCount") int limitCount,
            @Param("patientName") String patientName);
    int selectAllWaitingListCount (String patientName);

    int deleteAllWaitingByAdmId(int admId);
    List<Admission> selectAdmissionIdBySearchValue(
            @Param("patientName") String patientName,
            @Param("regidentNum") String regidentNum
    );
}

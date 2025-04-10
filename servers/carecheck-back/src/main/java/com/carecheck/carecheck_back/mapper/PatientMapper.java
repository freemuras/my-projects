package com.carecheck.carecheck_back.mapper;

import com.carecheck.carecheck_back.entity.Patient;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PatientMapper {
    int insertPatient(Patient patient);
    Patient selectPatientById(int patientId);

    int selectPatientsCount(String patientName);
    List<Patient> selectPatientsByName(
            @Param("startIndex") int startIndex,
            @Param("limitCount") int limitCount,
            @Param("patientName") String patientName
    );
}

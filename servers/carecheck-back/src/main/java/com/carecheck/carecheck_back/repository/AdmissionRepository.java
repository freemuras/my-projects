package com.carecheck.carecheck_back.repository;

import java.util.List;
import java.util.Optional;

import com.carecheck.carecheck_back.dto.response.RespWaitingListDto;
import com.carecheck.carecheck_back.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.carecheck.carecheck_back.mapper.AdmissionMapper;

@Repository
public class AdmissionRepository {

    @Autowired
    private AdmissionMapper admissionMapper;

    //환자 접수
    public Admission insert(Admission admission) {
        admissionMapper.insertAdmission(admission);
        return admission;
    }

    // 환자 patientId 접수 조회
    public Optional<Integer> findPatientId(int patientId) {
        return Optional.ofNullable(admissionMapper.selectPatientId(patientId));
    }

    //접수 번호로 환자정보 가져오기
    public Optional<Admission> selectPatientInfoByUserCode(int admissionId) {
        Admission admPatientInfo = admissionMapper.selectPatientInfoByAdmId(admissionId);
        if (admPatientInfo == null) {
            return Optional.empty();
        }
        return Optional.of(admPatientInfo);
    }

    //진료대기자 명단 (usercode)별 조회
    public Optional<List<Admission>> selectWaitingListByUserCode(String usercode) {
        List<Admission> waitingList = admissionMapper.selectWaitingListByUserCode(usercode);
        return waitingList.isEmpty()
            ? Optional.empty()   
            : Optional.of(waitingList);
    }

    //환자의 바이탈 정보 조회(admId)
    public Optional<List<Admission>> selectVitalInfoByAdmId(int admId) {
        List<Admission> vitalInfo = admissionMapper.selectVitalInfoByAdmId(admId);
        return vitalInfo.isEmpty()
            ? Optional.empty()
            : Optional.of(vitalInfo);
    }

    //처방에 대한 세부내역
    public Optional<Admission> selectDetailOrderByAdmId(int admissionId){
        Admission detailBillList = admissionMapper.selectDetailOrderByAdmId(admissionId);
        if(detailBillList == null) {
            return Optional.empty();
        }
        return Optional.of(detailBillList);
    }

    public void insertOrderInAdm(DiagnosisOrder diagnosisOrders) {
        admissionMapper.insertOrderInAdmission(diagnosisOrders);
    }

    public void deleteOrderInAdm(int diagnosisOrderId) {
        admissionMapper.deleteOrderInAdmission(diagnosisOrderId);
    }

    public void insertVitalInAdm(PatientVital patientVital) {
        admissionMapper.insertVitalInAdmId(patientVital);
    }

    public void insertDiagnosisInAdm(Diagnosis diagnosis) {
        admissionMapper.insertDiagnosisInAdmission(diagnosis);
    }

    public Integer selectTotalPayInAdm(int admissionId) {
        return admissionMapper.selectTotalPayByAdmId(admissionId);
    }

    public void updateAdmissionStartDate(int admissionId) {
        admissionMapper.updateAdmissionStartDate(admissionId);
    }

    public void updateAdmissionEndDate(int admissionId) {
        admissionMapper.updateAdmissionEndDate(admissionId);
    }

//    전체 진료대기자 명단 조회
    public List<PatientSearch> selectAllWaitingListByPatientName(
            int startIndex,
            int limitCount,
            String patientName) {
        List<PatientSearch> foundPatients = admissionMapper.selectAllWaitingListAdmId(startIndex, limitCount, patientName);
        return foundPatients;
    }

    public int selectWaitingListCount(String patientName) {
        return admissionMapper.selectAllWaitingListCount(patientName);
    }

    public void deleteAllWaitingByAdmId(int admId) {
        admissionMapper.deleteAllWaitingByAdmId(admId);
    }

    public Optional<List<Admission>> selectAllAdmissionIdBySearchValue (String patientName, String regidentNum) {
        List<Admission> allAdmissionsList = admissionMapper.selectAdmissionIdBySearchValue(patientName, regidentNum);
        if(allAdmissionsList == null) {
            return Optional.empty();
        }
        return Optional.of(allAdmissionsList);
    }
}


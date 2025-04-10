package com.carecheck.carecheck_back.service;

import java.util.List;

import com.carecheck.carecheck_back.dto.request.*;
import com.carecheck.carecheck_back.entity.*;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.carecheck.carecheck_back.exception.DuplicatedValueException;
import com.carecheck.carecheck_back.exception.FieldError;
import com.carecheck.carecheck_back.repository.AdmissionRepository;

@Service
public class AdmissionService {

    @Autowired
    private AdmissionRepository admissionRepository;


    @Transactional(rollbackFor = Exception.class)
    public Admission insertAdmission(ReqAddAdmissionDto dto) throws NotFoundException {
        int patientId = Integer.parseInt(dto.getPatientId());

        if (!selectPatientId(patientId)) {
            throw new NotFoundException("환자번호를 확인하세요.");
        }

        Admission admission = Admission.builder()
                .patientId(patientId)
                .clinicDeft(dto.getClinicDeft())
                .usercode(dto.getUsercode())
                .build();

        admissionRepository.insert(admission);
        return admission;
    }
    @Transactional(readOnly = true)
    public Admission selectPatientInfoByAdmId(int admissionId) throws Exception {
        return admissionRepository.selectPatientInfoByUserCode(admissionId)
            .orElseThrow(()-> new NotFoundException("해당 접수번호에 맞는 환자정보가 없습니다."));
    }

    @Transactional(readOnly = true)
    public boolean selectPatientId(int patientId) {
        return admissionRepository.findPatientId(patientId).orElse(0) > 0;
    }

    @Transactional(readOnly = true)
    public List<Admission> selectWaitingListUserCode(String usercode) throws Exception {
        return admissionRepository.selectWaitingListByUserCode(usercode)
        .orElseThrow(()-> new NotFoundException("접수된 내역이 없습니다."));
    }

    @Transactional(rollbackFor = Exception.class)
    public void insertVitalInAdm(ReqAddVitalInAdmDto dto) {
        PatientVital patientVital = PatientVital.builder()
                .admId(dto.getAdmId())
                .usercode(dto.getUsercode())
                .height(dto.getHeight())
                .weight(dto.getWeight())
                .fever(dto.getFever())
                .build();
        admissionRepository.insertVitalInAdm(patientVital);
    }
    @Transactional(readOnly = true)
    public List<Admission> selectVitalByAdmId(int admissionId) throws Exception{
        return admissionRepository.selectVitalInfoByAdmId(admissionId)
        .orElseThrow(()->new NotFoundException("바이탈 체크 내역이 없습니다."));
    }

    @Transactional(readOnly = true)
    public Admission selectDetailOrderByAdmId(int admissionId) throws Exception{
        return admissionRepository.selectDetailOrderByAdmId(admissionId)
        .orElseThrow(()-> new NotFoundException("입력된 내역이 없습니다."));
    }

    @Transactional(rollbackFor = Exception.class)
    public void insertOrderInAdm(List<ReqAddOrderInAdmDto> dtoList) {
        for(ReqAddOrderInAdmDto dto : dtoList) {
            DiagnosisOrder order = DiagnosisOrder.builder()
                .admId(dto.getAdmId())
                .orderCode(dto.getOrderCode())
                .orderDose(dto.getOrderDose())
                .orderCount(dto.getOrderCount())
                .orderDays(dto.getOrderDays())
                .orderMethod(dto.getOrderMethod())
                .build();
            admissionRepository.insertOrderInAdm(order);
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public void insertDiagnosisInAdm(List<ReqAddDiagnosisInAdmDto> dtoList) {
        for (ReqAddDiagnosisInAdmDto dto : dtoList) {
            Diagnosis diagnosis = Diagnosis.builder()
                .admId(dto.getAdmId())
                .diseaseCode(dto.getDiseaseCode())
                .build();
            admissionRepository.insertDiagnosisInAdm(diagnosis);
        }
    }

    @Transactional(readOnly = true)
    public Integer selectTotalPayInAdm(int admissionId) {
        return admissionRepository.selectTotalPayInAdm(admissionId);
    }

    @Transactional(rollbackFor = Exception.class)
    public void updateAdmissionStartDate(int admissionId) {
        admissionRepository.updateAdmissionStartDate(admissionId);  
    }

    @Transactional(rollbackFor = Exception.class)
    public void updateAdmissionEndDate(int admissionId) {
        admissionRepository.updateAdmissionEndDate(admissionId);
    }

    public List<PatientSearch> getTodayWaitingListByPatientName(ReqSearchTodayReciptPatientsDto reqSearchTodayReciptPatientsDto) {
        int startIndex = (reqSearchTodayReciptPatientsDto.getPage() - 1) * reqSearchTodayReciptPatientsDto.getLimitCount();
        List<PatientSearch> foundPatients = admissionRepository.selectAllWaitingListByPatientName(
                startIndex,
                reqSearchTodayReciptPatientsDto.getLimitCount(),
                reqSearchTodayReciptPatientsDto.getSearchText()
        );
        return foundPatients;
    }

    public int getWaitingListCount(String patientName) {
        return admissionRepository.selectWaitingListCount(patientName);
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteAllWaitingByAdmId(int admId) {
        admissionRepository.deleteAllWaitingByAdmId(admId);
    }

    @Transactional(readOnly = true)
    public List<Admission> getAllAdmissionListBySearchValue(ReqAdmissionListDto reqAdmissionListDto) throws Exception {
        return admissionRepository.selectAllAdmissionIdBySearchValue(reqAdmissionListDto.getPatientName(), reqAdmissionListDto.getRegidentNum())
            .orElseThrow(()-> new NotFoundException("접수된 내역이 없습니다."));
    }

}

package com.carecheck.carecheck_back.service;

import java.util.List;

import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carecheck.carecheck_back.dto.request.ReqAddDiseaseDto;
import com.carecheck.carecheck_back.entity.Disease;
import com.carecheck.carecheck_back.repository.DiseaseRepository;

@Service
public class DiseaseService {
    @Autowired
    private DiseaseRepository diseaseRepository;

    public void insertDisease(ReqAddDiseaseDto dto) {
        Disease disease = Disease.builder()
                .diseaseCode(dto.getDiseaseCode())
                .diaseseEName(dto.getDiseaseEName())
                .diseaseKName(dto.getDiseaseKName())
                .build();
        diseaseRepository.insertDisease(disease);
    }

    public List<Disease> selectDiseaseByDiseaseName(String diseaseName) throws Exception {
        return diseaseRepository.selectDiseaseByContain(diseaseName).orElseThrow(()-> new NotFoundException("해당 질병이 존재하지 않습니다."));
    }
}

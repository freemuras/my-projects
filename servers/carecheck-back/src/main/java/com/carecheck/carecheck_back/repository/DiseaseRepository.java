package com.carecheck.carecheck_back.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.carecheck.carecheck_back.entity.Disease;
import com.carecheck.carecheck_back.mapper.DiseaseMapper;

@Repository
public class DiseaseRepository {
    @Autowired
    private DiseaseMapper diseaseMapper;

    public void insertDisease(Disease disease) {
        diseaseMapper.insertDisease(disease);
    }

    public Optional<List<Disease>> selectDiseaseByContain(String diseaseName) {
        return diseaseMapper.selectDiseaseByDiseaseName(diseaseName).isEmpty()
                ? Optional.empty()
                : Optional.of(diseaseMapper.selectDiseaseByDiseaseName(diseaseName));
    }
}

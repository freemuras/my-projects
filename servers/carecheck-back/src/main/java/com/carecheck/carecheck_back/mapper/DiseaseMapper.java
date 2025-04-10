package com.carecheck.carecheck_back.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.carecheck.carecheck_back.entity.Disease;

@Mapper
public interface DiseaseMapper {
    int insertDisease(Disease disease);
    List<Disease> selectDiseaseByDiseaseName(String diseaseName); 
}

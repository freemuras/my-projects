package com.carecheck.carecheck_back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.carecheck.carecheck_back.dto.request.ReqAddDiseaseDto;
import com.carecheck.carecheck_back.service.DiseaseService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/diseases")
public class DiseaseController {
    @Autowired
    private DiseaseService diseaseService;
    
    @Operation(summary = "질병등록", description = "질병등록")
    @PostMapping
    public void insertDesease(ReqAddDiseaseDto reqAddDiseaseDto) {
        diseaseService.insertDisease(reqAddDiseaseDto);
    }

    @Operation(summary = "질병검색", description = "질병명으로 검색")
    @GetMapping
    public ResponseEntity<?> selectDiseaseByDiseaseName(
        @RequestParam String diseaseName) throws Exception {
        return ResponseEntity.ok().body(diseaseService.selectDiseaseByDiseaseName(diseaseName));
    }
}

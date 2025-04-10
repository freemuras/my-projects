package com.carecheck.carecheck_back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.carecheck.carecheck_back.service.SummaryService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
@RequestMapping("/api/summary")
public class SummaryController {
    @Autowired
    private SummaryService summaryService;

    @Operation(summary = "연도에 따른 분기별 금액", description = "분기별 병원 총 수익")
    @GetMapping
    public ResponseEntity<?> selectTotalByYear( 
        @Parameter(description = "조회할 년도", example = "2025", required = true)
        @RequestParam int year
    ) throws Exception {
        return ResponseEntity.ok().body(summaryService.selectSummaryTotal(year));
    }

    @Operation(summary = "직원 사번에 따른 분기별 금액", description = "직원사번에 따른 병원 총 수익")
    @GetMapping("/usercode")
    public ResponseEntity<?> selectTotalByUserCodeAndYear(
        @Parameter(description = "조회할 년도", example = "2025", required = true)
        @RequestParam int year,
        @Parameter(description = "조회할 사번", example = "2025020003", required = true)
        @RequestParam String usercode
    ) throws Exception{
        return ResponseEntity.ok().body(summaryService.selectSummaryTotalByUsercode(usercode, year));
    }
}

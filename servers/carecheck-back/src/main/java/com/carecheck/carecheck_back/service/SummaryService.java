package com.carecheck.carecheck_back.service;

import java.util.List;

import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.carecheck.carecheck_back.entity.TotalSummary;
import com.carecheck.carecheck_back.repository.SummaryRepository;

@Service
public class SummaryService {
    @Autowired
    private SummaryRepository summaryRepository;

    @Transactional(readOnly = true)
    public List<TotalSummary> selectSummaryTotal(int year) throws Exception{
        return summaryRepository.selectSummaryByYear(year)
            .orElseThrow(()-> new NotFoundException("해당년도에 정보가 없습니다."));
    }

    @Transactional(readOnly = true)
    public List<TotalSummary> selectSummaryTotalByUsercode(String usercode, int year) throws Exception {
        return summaryRepository.selectSummaryByUsercodeAndYear(usercode, year)
            .orElseThrow(()-> new NotFoundException("조회된 정보가 없습니다."));
    }
}

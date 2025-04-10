package com.carecheck.carecheck_back.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.carecheck.carecheck_back.entity.TotalSummary;

@Mapper
public interface SummaryMapper {
    List<TotalSummary> selectTotalSummaryByYear(int year);
    List<TotalSummary> selectTotalSummaryByUsercode(String usercode, int year);
}
